package cc.momas.smbms.service;

import java.util.List;

import cc.momas.smbms.entity.Provider;

public interface IProviderService {

	Provider queryById(Integer id);

	List<Provider> queryAll();

	int add(Provider provider);

	int delete(Provider provider);

	int update(Provider provider);
}