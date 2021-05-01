package cc.momas.housetenacy.dao.impl;

import java.util.List;

import org.hibernate.Session;

import cc.momas.housetenacy.dao.ITypesDAO;
import cc.momas.housetenacy.entity.Types;
import cc.momas.housetenacy.utils.HibernateSessionFactory;

public class TypesDAOImpl implements ITypesDAO {

	@SuppressWarnings("unchecked")
	public List<Types> queryAll() {
		Session session = HibernateSessionFactory.getSession();
		return session.createQuery("FROM Types").list();
	}

}
