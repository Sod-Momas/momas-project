package cc.momas.smbms.dao;

import java.util.List;

import cc.momas.smbms.entity.Address;

public interface AddressMapper {
	int count();
	
	List<Address> queryAll();
	
	int add(Address address);
	
	int delete(Address address);
	
	int update(Address address);
	
}
