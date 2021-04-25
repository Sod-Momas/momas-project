package cc.momas.car.entity;

import java.lang.Integer;

/**
 * Carinfo entity. @author MyEclipse Persistence Tools
 */

public class Carinfo implements java.io.Serializable {

	// Fields

	private Integer carid;
	private Carmodal carmodal;
	private String carname;
	private Double carprice;
	private String cardisplacement;
	private String carclutch;
	private String carcolor;

	// Constructors

	/** default constructor */
	public Carinfo() {
	}

	/** minimal constructor */
	public Carinfo(String carname, Double carprice) {
		this.carname = carname;
		this.carprice = carprice;
	}

	/** full constructor */
	public Carinfo(Carmodal carmodal, String carname, Double carprice,
			String cardisplacement, String carclutch, String carcolor) {
		this.carmodal = carmodal;
		this.carname = carname;
		this.carprice = carprice;
		this.cardisplacement = cardisplacement;
		this.carclutch = carclutch;
		this.carcolor = carcolor;
	}

	// Property accessors

	public Integer getCarid() {
		return this.carid;
	}

	public void setCarid(Integer carid) {
		this.carid = carid;
	}

	public Carmodal getCarmodal() {
		return this.carmodal;
	}

	public void setCarmodal(Carmodal carmodal) {
		this.carmodal = carmodal;
	}

	public String getCarname() {
		return this.carname;
	}

	public void setCarname(String carname) {
		this.carname = carname;
	}

	public Double getCarprice() {
		return this.carprice;
	}

	public void setCarprice(Double carprice) {
		this.carprice = carprice;
	}

	public String getCardisplacement() {
		return this.cardisplacement;
	}

	public void setCardisplacement(String cardisplacement) {
		this.cardisplacement = cardisplacement;
	}

	public String getCarclutch() {
		return this.carclutch;
	}

	public void setCarclutch(String carclutch) {
		this.carclutch = carclutch;
	}

	public String getCarcolor() {
		return this.carcolor;
	}

	public void setCarcolor(String carcolor) {
		this.carcolor = carcolor;
	}

}