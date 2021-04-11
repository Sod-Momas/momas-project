package cc.momas.vote.entity;

/**
 * 用户实体类
 * 
 * @author 陈伟明
 * 
 */
public final class User {
	/**
	 * 用户id
	 */
	private Integer uid;
	/**
	 * 用户名
	 */
	private String uusername;
	/**
	 * 用户密码
	 */
	private String upassword;
	/**
	 * 用户邮箱
	 */
	private String uemail;

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUusername() {
		return uusername;
	}

	public void setUusername(String uusername) {
		this.uusername = uusername;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

}
