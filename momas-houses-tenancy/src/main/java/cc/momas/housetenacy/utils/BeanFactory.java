package cc.momas.housetenacy.utils;

import java.util.HashMap;
import java.util.Map;

import cc.momas.housetenacy.dao.impl.DistrictDAOImpl;
import cc.momas.housetenacy.dao.impl.HouseDAOImpl;
import cc.momas.housetenacy.dao.impl.TypesDAOImpl;
import cc.momas.housetenacy.dao.impl.UsersDAOImpl;
import cc.momas.housetenacy.service.impl.DistrictServiceImpl;
import cc.momas.housetenacy.service.impl.HouseServiceImpl;
import cc.momas.housetenacy.service.impl.TypesServiceImpl;
import cc.momas.housetenacy.service.impl.UsersServiceImpl;

public class BeanFactory {
	private static Map<String,Object> beans =new HashMap<String, Object>();
	
	static{
		beans.put("usersDao",new UsersDAOImpl());
		beans.put("usersService",new UsersServiceImpl());
		beans.put("houseDao", new HouseDAOImpl());
		beans.put("houseService", new HouseServiceImpl());
		beans.put("typesDao", new TypesDAOImpl());
		beans.put("typesService", new TypesServiceImpl());
		beans.put("districtDao", new DistrictDAOImpl());
		beans.put("districtService", new DistrictServiceImpl());
	}
	public static Object getBean(String key){
		return beans.get(key);
	}
}
