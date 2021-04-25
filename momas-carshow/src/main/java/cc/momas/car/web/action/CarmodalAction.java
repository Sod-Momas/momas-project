package cc.momas.car.web.action;

import java.util.List;

import cc.momas.car.entity.Carmodal;
import cc.momas.car.service.ICarmodalService;

public class CarmodalAction extends BaseAction {


	private static final long serialVersionUID = 1L;
	private List<Carmodal> mlist;
	private ICarmodalService mSvc;
	private Integer brandId;
	
	public String queryAll() {
		mlist = mSvc.findAll();
		return SUCCESS;
	}
	
	public String queryByBrandId(){
		mlist = mSvc.findByBrandId(brandId);
		return SUCCESS;
	}
	

	public void setmSvc(ICarmodalService mSvc) {
		this.mSvc = mSvc;
	}

	public List<Carmodal> getMlist() {
		return mlist;
	}

	public void setMlist(List<Carmodal> mlist) {
		this.mlist = mlist;
	}

	public Integer getBrandId() {
		return brandId;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

}
