package cc.momas.dms.pojo;

public class BcRegion  {
	private Integer regionId;
	private String province;
	private String city;
	private String district;
	private String postcode;
	private String shortcode;
	private String citycode;

	
	public String getName() {
		return new StringBuilder()
				.append(this.getProvince())
				.append('-')
				.append(this.getCity())
				.append('-')
				.append(this.getDistrict())
				.toString();
				
	}
	
	public BcRegion() {
		super();
	}

	public BcRegion(Integer regionId, String province, String city, String district, String postcode, String shortcode,
			String citycode) {
		super();
		this.regionId = regionId;
		this.province = province;
		this.city = city;
		this.district = district;
		this.postcode = postcode;
		this.shortcode = shortcode;
		this.citycode = citycode;
	}

	public Integer getRegionId() {
		return regionId;
	}

	public void setRegionId(Integer regionId) {
		this.regionId = regionId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province == null ? null : province.trim();
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city == null ? null : city.trim();
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district == null ? null : district.trim();
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode == null ? null : postcode.trim();
	}

	public String getShortcode() {
		return shortcode;
	}

	public void setShortcode(String shortcode) {
		this.shortcode = shortcode == null ? null : shortcode.trim();
	}

	public String getCitycode() {
		return citycode;
	}

	public void setCitycode(String citycode) {
		this.citycode = citycode == null ? null : citycode.trim();
	}
}