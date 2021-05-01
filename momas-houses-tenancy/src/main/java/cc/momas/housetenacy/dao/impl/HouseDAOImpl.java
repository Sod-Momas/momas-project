package cc.momas.housetenacy.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import cc.momas.housetenacy.dao.IHouseDAO;
import cc.momas.housetenacy.entity.House;
import cc.momas.housetenacy.entity.Qb;
import cc.momas.housetenacy.utils.HibernateSessionFactory;
import cc.momas.housetenacy.utils.Pager;

public class HouseDAOImpl implements IHouseDAO {

	@SuppressWarnings("unchecked")
	public Pager<House> queryAll(Pager<House> pager) {
		Session session = HibernateSessionFactory.getSession();
		Query query = session.createQuery("FROM House");
		query.setFirstResult(pager.getFirstIndex());
		query.setMaxResults(pager.getPageSize());
		pager.setList(query.list());

		// 查询总记录数
		String hql = "SELECT COUNT(h) FROM House h";
		long totalRecordCount = (Long) session.createQuery(hql).uniqueResult();
		pager.setTotalRecordCount((int) totalRecordCount);
		return pager;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pager<House> queryAllByTjPager(Pager<House> pager, Qb qb) {
		Session session = HibernateSessionFactory.getSession();
		Criteria criteria = session.createCriteria(House.class);
		
		
		criteria.createAlias("street", "s");
		if (qb != null) {
			if (qb.getTitle() != null) {
				// ilike是忽略大小写的like
				criteria.add(Restrictions.ilike("title", "%" + qb.getTitle()+ "%"));
			}
			if (qb.getDistrictId() != null) {
				criteria.add(Restrictions.eq("s.district.id", qb
						.getDistrictId()));
			}
			if (qb.getStreetId() != null) {
				criteria.add(Restrictions.eq("s.id", qb.getStreetId()));
			}
			if (qb.getTypesId() != null) {
				criteria.add(Restrictions.eq("types.id", qb.getTypesId()));
			}
			// 有范围的值
			if (qb.getPrice() != null) {
				criteria.add(Restrictions.between("price", qb.getMinPrice(), qb
						.getMaxPrice()));
			}
			if (qb.getFloorAge() != null) {
				criteria.add(Restrictions.between("floorage", qb
						.getMinFloorAge(), qb.getMaxFloorAge()));
			}

		}
		
		//分页查询
		criteria.setFirstResult(pager.getFirstIndex());//查询的第一条数据的序号
		criteria.setMaxResults(pager.getPageSize());//查询的数据条数
		pager.setList(criteria.list());
		
		// 查询总记录数
		criteria = session.createCriteria(House.class);
		criteria.createAlias("street", "s");
		if (qb != null) {
			if (qb.getTitle() != null) {
				// ilike是忽略大小写的like
				criteria.add(Restrictions.ilike("title", "%" + qb.getTitle()+ "%"));
			}
			if (qb.getDistrictId() != null) {
				criteria.add(Restrictions.eq("s.district.id", qb
						.getDistrictId()));
			}
			if (qb.getStreetId() != null) {
				criteria.add(Restrictions.eq("s.id", qb.getStreetId()));
			}
			if (qb.getTypesId() != null) {
				criteria.add(Restrictions.eq("types.id", qb.getTypesId()));
			}
			// 有范围的值
			if (qb.getPrice() != null) {
				criteria.add(Restrictions.between("price", qb.getMinPrice(), qb
						.getMaxPrice()));
			}
			if (qb.getFloorAge() != null) {
				criteria.add(Restrictions.between("floorage", qb
						.getMinFloorAge(), qb.getMaxFloorAge()));
			}

		}
		
		criteria.setProjection(Projections.rowCount());
		// TODO 这个ID查不出来,不知道 为什么
		Object  o  =  criteria.uniqueResult();
		Integer i = (Integer) o;
		pager.setTotalRecordCount(i);
		
		
		return pager;
	}

	public boolean addHouse(House house) {
		Session session = HibernateSessionFactory.getSession();
		try {
			session.save(house);
		} catch (HibernateException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
