package cc.momas.smbms.entity;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class User {

	private String address;
	private Date birthday;
	private Integer createdBy;
	private Date creationDate;
	private Integer gender;
	private Integer modifyBy;
	private Date modifyDate;
	private String phone;
	private String userCode;
	private Integer userId;
	private String userName;
	private String userPassword;
	private Integer userRole;


	
	
	public User() {
		super();
	}

	public User(Integer userid, String userCode, String userName, String userPassword, Integer gender, Date birthday,
			String phone, String address, Integer userRole, Integer createdBy, Date creationDate, Integer modifyBy,
			Date modifyDate) {
		super();
		this.userId = userid;
		this.userCode = userCode;
		this.userName = userName;
		this.userPassword = userPassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userRole = userRole;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
		this.modifyBy = modifyBy;
		this.modifyDate = modifyDate;
	}

	
	
	public String getAddress() {
		return address;
	}

	public Date getBirthday() {
		return birthday;
	}

	public Integer getCreatedBy() {
		return createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public Integer getGender() {
		return gender;
	}

	public Integer getModifyBy() {
		return modifyBy;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public String getPhone() {
		return phone;
	}


	public String getUserCode() {
		return userCode;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}


	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userid=" + userId + ", userCode=" + userCode + ", userName=" + userName + ", userPassword="
				+ userPassword + ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + ", address="
				+ address + ", userRole=" + userRole + ", createdBy=" + createdBy + ", creationDate=" + creationDate
				+ ", modifyBy=" + modifyBy + ", modifyDate=" + modifyDate + "]";
	}

}
