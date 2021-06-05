package cc.momas.smbms.service;

import java.util.List;

import cc.momas.smbms.entity.Bill;

public interface IBillService {
	int count();

	Bill queryById(Integer id);

	int add(Bill bill);

	int delete(Bill bill);

	int update(Bill bill);

	List<Bill> queryAll();
}