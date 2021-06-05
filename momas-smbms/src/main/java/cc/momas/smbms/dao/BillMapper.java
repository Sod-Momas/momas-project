package cc.momas.smbms.dao;

import java.util.List;

import cc.momas.smbms.entity.Bill;

public interface BillMapper {
	int count();

	List<Bill> qeuryAll();

	Bill queryById(Integer id);

	int add(Bill bill);

	int delete(Bill bill);

	int update(Bill bill);
}
