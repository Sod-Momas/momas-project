package cc.momas.petshop.service;

import cc.momas.petshop.dao.IAccountDAO;
import cc.momas.petshop.dao.IPetDAO;
import cc.momas.petshop.dao.IPetOwnerDAO;
import cc.momas.petshop.dao.IPetStoreDAO;
import cc.momas.petshop.entity.PetOwner;

public interface IPetService {
	/** 显示服务层欢迎菜单 */
	public void init();

	/** 主人登录模块 */
	public PetOwner petOwnerLogin();

	/** 购买库存宠物模块 */
	public void buyKuCunPet();

	/** 培育新宠物功能模块 */
	public void buyNewPet();

	/** 出卖宠物功能模块 */
	public void salePet();

	public void setAccountDao(IAccountDAO accountDao);

	public void setPetDao(IPetDAO petDao);

	public void setPetOwnerDao(IPetOwnerDAO petOwnerDao);

	public void setPetStoreDao(IPetStoreDAO petStoreDao);

}
