package cc.momas.housetenacy.service;

import cc.momas.housetenacy.entity.Users;

public interface IUsersService {
	public boolean register(Users user);

	public Users login(Users user);
}
