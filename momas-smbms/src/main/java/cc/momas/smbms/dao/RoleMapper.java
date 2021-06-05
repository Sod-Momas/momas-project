package cc.momas.smbms.dao;

import java.util.List;

import cc.momas.smbms.entity.Role;

public interface RoleMapper {
	int count();

	List<Role> queryAll();

	int add(Role role);

	int delete(Role role);

	int update(Role role);
}
