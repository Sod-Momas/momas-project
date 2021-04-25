package cc.momas.car.entity;

import java.lang.Integer;
import java.util.HashSet;
import java.util.Set;

/**
 * Carmodal entity. @author MyEclipse Persistence Tools
 */

public class Carmodal implements java.io.Serializable {

	// Fields

	private Integer modelid;
	private Brand brand;
	private String modalname;
	private Set carinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Carmodal() {
	}

	/** minimal constructor */
	public Carmodal(String modalname) {
		this.modalname = modalname;
	}

	/** full constructor */
	public Carmodal(Brand brand, String modalname, Set carinfos) {
		this.brand = brand;
		this.modalname = modalname;
		this.carinfos = carinfos;
	}

	// Property accessors

	public Integer getModelid() {
		return this.modelid;
	}

	public void setModelid(Integer modelid) {
		this.modelid = modelid;
	}

	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getModalname() {
		return this.modalname;
	}

	public void setModalname(String modalname) {
		this.modalname = modalname;
	}

	public Set getCarinfos() {
		return this.carinfos;
	}

	public void setCarinfos(Set carinfos) {
		this.carinfos = carinfos;
	}

}