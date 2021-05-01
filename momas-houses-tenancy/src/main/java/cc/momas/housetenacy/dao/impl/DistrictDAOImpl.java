package cc.momas.housetenacy.dao.impl;

import java.util.List;

import org.hibernate.Session;

import cc.momas.housetenacy.dao.IDistrictDAO;
import cc.momas.housetenacy.entity.District;
import cc.momas.housetenacy.utils.HibernateSessionFactory;

public class DistrictDAOImpl implements IDistrictDAO {

	@SuppressWarnings("unchecked")
	public List<District> queryAll() {
		Session session = HibernateSessionFactory.getSession();
		return session.createQuery("FROM District").list();
	}

	public District queryById(Integer id) {
		Session session = HibernateSessionFactory.getSession();
		return (District) session.createQuery("FROM District d WHERE d.id=?")
				.setInteger(0, id).uniqueResult();
	}

}
