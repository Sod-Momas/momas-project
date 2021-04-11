package cc.momas.test.newportal.entity;

import java.sql.Date;

/**
 * 评论实体类
 * 
 * @author sothe
 * 
 */
public final class Comments {
	private Integer cid;
	private Integer cnid;
	private String ccontent;
	private Date cdate;
	private String cip;
	private String cauthor;

	/**** getter and setter ****/
	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getCnid() {
		return cnid;
	}

	public void setCnid(Integer cnid) {
		this.cnid = cnid;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public String getCip() {
		return cip;
	}

	public void setCip(String cip) {
		this.cip = cip;
	}

	public String getCauthor() {
		return cauthor;
	}

	public void setCauthor(String cauthor) {
		this.cauthor = cauthor;
	}

}
