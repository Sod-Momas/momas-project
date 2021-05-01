package cc.momas.housetenacy.entity;

public class Qb {
	private String title;
	private Integer districtId;
	private Integer streetId;
	private Integer typesId;
	private String price;
	private Integer minPrice;
	private Integer maxPrice;
	private String floorAge;
	private Integer minFloorAge;
	private Integer maxFloorAge;

	public Qb() {
		super();
	}

	public Qb(String title, String price, Integer districtId, Integer streetId,
			Integer typesId) {
		super();
		this.title = title;
		this.price = price;
		this.districtId = districtId;
		this.streetId = streetId;
		this.typesId = typesId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	public Integer getStreetId() {
		return streetId;
	}

	public void setStreetId(Integer streetId) {
		this.streetId = streetId;
	}

	public Integer getTypesId() {
		return typesId;
	}

	public void setTypesId(Integer typesId) {
		this.typesId = typesId;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		if(!(price == null  || "".equals(price.trim()))){
			this.price = price;
			String [] p = this.price.split("-");
			this.setMinPrice(Integer.parseInt(p[0]));
			this.setMaxPrice(Integer.parseInt(p[1]));
		}
	}

	public Integer getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(Integer minPrice) {
		this.minPrice = minPrice;
	}

	public Integer getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(Integer maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getFloorAge() {
		return floorAge;
	}

	public void setFloorAge(String floorAge) {
		if(!(floorAge == null || "".equals(floorAge.trim()))){
			this.floorAge = floorAge;
			String [] r = this.floorAge.split("-");
			this.setMinFloorAge(Integer.parseInt(r[0]));
			this.setMaxFloorAge(Integer.parseInt(r[1]));
		}
	}

	public Integer getMinFloorAge() {
		return minFloorAge;
	}

	public void setMinFloorAge(Integer minFloorAge) {
		this.minFloorAge = minFloorAge;
	}

	public Integer getMaxFloorAge() {
		return maxFloorAge;
	}

	public void setMaxFloorAge(Integer maxFloorAge) {
		this.maxFloorAge = maxFloorAge;
	}


}
