package cc.momas.car.web.action;

import java.util.List;

import cc.momas.car.entity.Brand;
import cc.momas.car.service.IBrandService;

public class BrandAction extends BaseAction {

	private static final long serialVersionUID = 1L;
	private List<Brand> blist;
	private IBrandService bSvc;

	public String queryAll() {
		blist = bSvc.findAll();
		return SUCCESS;
	}

	public void setBlist(List<Brand> blist) {
		this.blist = blist;
	}

	public List<Brand> getBlist() {
		return blist;
	}

	public void setbSvc(IBrandService bSvc) {
		this.bSvc = bSvc;
	}
}
