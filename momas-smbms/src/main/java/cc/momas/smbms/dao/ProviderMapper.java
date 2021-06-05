package cc.momas.smbms.dao;

import java.util.List;

import cc.momas.smbms.entity.Provider;

public interface ProviderMapper {
	int count();
	
	Provider queryById(Integer id);

	List<Provider> queryAll();

	int add(Provider provider);

	int delete(Provider provider);

	int update(Provider provider);
}
