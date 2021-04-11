package cc.momas.petshop.ui;

import cc.momas.petshop.dao.IPetDAO;
import cc.momas.petshop.dao.IPetOwnerDAO;
import cc.momas.petshop.dao.IPetStoreDAO;
import cc.momas.petshop.dao.impl.AccountDAOImpl;
import cc.momas.petshop.dao.impl.PetDAOImpl;
import cc.momas.petshop.dao.impl.PetOwnerDAOImpl;
import cc.momas.petshop.dao.impl.PetStoreDAOImpl;
import cc.momas.petshop.service.IPetService;
import cc.momas.petshop.dao.IAccountDAO;
import cc.momas.petshop.service.impl.PetServiceImpl;

/**
 * @author Sod-Momas
 * @since 2021.04.11
 */
public class MomasPetShopApplication {
	/**
	 * 程序入口
	 * 
	 * @param args
	 *            程序启动参数(空)
	 */
	public static void main(String[] args) {
		// 表示层
		StartPet startPet = new StartPet();
		// 接入服务提供方接口
		IPetService petService = new PetServiceImpl();
		startPet.setPm(petService);
		// 接入数据提供方接口
		IAccountDAO accountDao = new AccountDAOImpl();
		IPetDAO petDao = new PetDAOImpl();
		IPetStoreDAO petStoreDao = new PetStoreDAOImpl();
		IPetOwnerDAO petOwnerDao = new PetOwnerDAOImpl();
		// 为服务提供方接入数据接口
		petService.setAccountDao(accountDao);
		petService.setPetDao(petDao);
		petService.setPetOwnerDao(petOwnerDao);
		petService.setPetStoreDao(petStoreDao);
		// 启动表示层页面显示
		startPet.init();
		startPet.loginMenu();

	}

}
