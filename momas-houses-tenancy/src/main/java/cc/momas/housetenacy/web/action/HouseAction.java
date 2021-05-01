package cc.momas.housetenacy.web.action;

import java.io.File;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import cc.momas.housetenacy.entity.House;
import cc.momas.housetenacy.entity.Qb;
import cc.momas.housetenacy.entity.Types;
import cc.momas.housetenacy.entity.Users;
import cc.momas.housetenacy.service.IHouseService;
import cc.momas.housetenacy.service.ITypesService;
import cc.momas.housetenacy.utils.BeanFactory;
import cc.momas.housetenacy.utils.FileUtil;
import cc.momas.housetenacy.utils.Pager;

public class HouseAction extends BaseAction {
	private static final long serialVersionUID = 1L;

	private IHouseService houseService = (IHouseService) BeanFactory
			.getBean("houseService");
	private ITypesService typesService = (ITypesService) BeanFactory
			.getBean("typesService");

	private House house;
	private Pager<House> pager;
	private List<Types> typesList;
	private Qb qb;
	
	private File pic;
	private String picFileName;
	
	public String queryAll() {
		if (pager == null) {
			pager = new Pager<House>();
		}
		pager = houseService.queryAllByPager(pager);
		return "queryallhouse";
	}
	
	public String search(){
		if(pager == null ){
			pager = new Pager<House>();
		}
		pager = houseService.queryAllByTjPager(pager,qb);
		return "queryallhouse";
		
	}
	
	public String toAdd() {
		typesList = typesService.queryAll();
		return "toaddhouse";
	}
	
	public String queryAllTypes(){
		typesList = typesService.queryAll();
		return "querytypesjson";
	}
	
	public String add(){
		 Users u = (Users) this.getSession().get("LOGIN_USER");
		 house.setUsers(u);
		 
		 String dir = ServletActionContext.getServletContext().getRealPath("/upload/house");
		 picFileName = FileUtil.uploadFile(pic, picFileName.substring(picFileName.lastIndexOf(".")), dir);
		 house.setPic(picFileName);
		 
		 if(houseService.addHouse(house)){
			System.out.println("添加成功");
		}else{
			System.out.println("添加失败了");
		}
		return "addsuccess";
	}

	public House getHouse() {
		return house;
	}

	public void setHouse(House house) {
		this.house = house;
	}

	public Pager<House> getPager() {
		return pager;
	}

	public void setPager(Pager<House> pager) {
		this.pager = pager;
	}

	public void setTypesList(List<Types> typesList) {
		this.typesList = typesList;
	}

	public List<Types> getTypesList() {
		return typesList;
	}

	public void setQb(Qb qb) {
		this.qb = qb;
	}

	public Qb getQb() {
		return qb;
	}

	public File getPic() {
		return pic;
	}

	public String getFileName() {
		return picFileName;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}

	public void setFileName(String fileName) {
		this.picFileName = fileName;
	}

	public String getPicFileName() {
		return picFileName;
	}

	public void setPicFileName(String picFileName) {
		this.picFileName = picFileName;
	}

}
