package cc.momas.petshop.dao;

import java.sql.Connection;
import java.util.List;

import cc.momas.petshop.entity.PetStore;

public interface IPetStoreDAO extends IBaseDAO{
	/**
	 * 查询全部商店
	 * @param con
	 * @return
	 */
	public List<PetStore> queryAll(Connection con);
	
	public List<PetStore> queryByTj(Connection con, String where, Object[] param) ;
}
