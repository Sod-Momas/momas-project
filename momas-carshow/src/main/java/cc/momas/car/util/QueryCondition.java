package cc.momas.car.util;

public class QueryCondition {

	
	@Override
	public String toString() {
		return "QueryCondition [brandId=" + brandId + ", maxPrice=" + maxPrice
				+ ", minPrice=" + minPrice + ", modalId=" + modalId + "]";
	}

	private Integer brandId;
	private Integer modalId;
	private Double minPrice;
	private Double maxPrice;

	public Integer getBrandId() {
		return brandId;
	}

	public Integer getModalId() {
		return modalId;
	}

	public Double getMinPrice() {
		return minPrice;
	}

	public Double getMaxPrice() {
		return maxPrice;
	}

	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}

	public void setModalId(Integer modalId) {
		this.modalId = modalId;
	}
	
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}

	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}

}
