package cc.momas.car.entity;

import java.lang.Integer;
import java.util.HashSet;
import java.util.Set;

/**
 * Brand entity. @author MyEclipse Persistence Tools
 */

public class Brand implements java.io.Serializable {

	// Fields

	private Integer brandid;
	private String brandname;
	private Set carmodals = new HashSet(0);

	// Constructors

	/** default constructor */
	public Brand() {
	}

	/** full constructor */
	public Brand(String brandname, Set carmodals) {
		this.brandname = brandname;
		this.carmodals = carmodals;
	}

	// Property accessors

	public Integer getBrandid() {
		return this.brandid;
	}

	public void setBrandid(Integer brandid) {
		this.brandid = brandid;
	}

	public String getBrandname() {
		return this.brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public Set getCarmodals() {
		return this.carmodals;
	}

	public void setCarmodals(Set carmodals) {
		this.carmodals = carmodals;
	}

}