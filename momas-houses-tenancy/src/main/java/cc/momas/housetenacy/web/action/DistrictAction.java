package cc.momas.housetenacy.web.action;

import java.util.List;

import cc.momas.housetenacy.entity.District;
import cc.momas.housetenacy.service.IDistrictService;
import cc.momas.housetenacy.utils.BeanFactory;

public class DistrictAction {
	private District district;
	private List<District> districtList;
	
	private IDistrictService districtService = (IDistrictService) BeanFactory.getBean("districtService");
	
	public String queryAllDistrict(){
		districtList  = districtService.queryAll();
		return "showdistrict";
	}
	
	public String querydistrictbyId(){
		district = districtService.queryById(district.getId());
		return "showstreestbydistrict";
	}
	
	public District getDistrict() {
		return district;
	}
	public void setDistrict(District district) {
		this.district = district;
	}
	public List<District> getDistrictList() {
		return districtList;
	}
	public void setDistrictList(List<District> districtList) {
		this.districtList = districtList;
	}
	
	
}
