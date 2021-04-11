package cc.momas.petshop.dao;

import java.sql.Connection;
import java.util.List;

import cc.momas.petshop.entity.Account;

public interface IAccountDAO extends IBaseDAO {
	/**
	 * 查询全部商店
	 * 
	 * @param con
	 *            数据库连接
	 * @return 查询出来的结果集
	 */
	public List<Account> queryAll(Connection con);
}
