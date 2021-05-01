package cc.momas.housetenacy.dao;

import cc.momas.housetenacy.entity.Users;

public interface IUsersDAO {
	public boolean save(Users user);
	
	public Users queryByPwd(Users user);
	
}
