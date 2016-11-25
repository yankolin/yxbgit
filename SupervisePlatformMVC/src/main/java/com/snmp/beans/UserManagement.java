package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_UserManagement_d")

public class UserManagement implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="UserManId")
	private Integer UserManId;
	
	@Column(name="UserManName")
	private String UserManName;
	
	@Column(name="UserManPwd")
	private String UserManPwd;
	
	@Column(name="UserManType")
	private Integer UserManType;
	
	@Column(name="UserManEmail")
	private String UserManEmail;
	
	@Column(name="UserManTag")
	private Integer UserManTag;
	
	@Column(name="UserManDate")
	private Date UserManDate;

	public Integer getUserManId() {
		return UserManId;
	}

	public void setUserManId(Integer userManId) {
		UserManId = userManId;
	}

	public String getUserManName() {
		return UserManName;
	}

	public void setUserManName(String userManName) {
		UserManName = userManName;
	}

	public String getUserManPwd() {
		return UserManPwd;
	}

	public void setUserManPwd(String userManPwd) {
		UserManPwd = userManPwd;
	}

	public Integer getUserManType() {
		return UserManType;
	}

	public void setUserManType(Integer userManType) {
		UserManType = userManType;
	}

	public String getUserManEmail() {
		return UserManEmail;
	}

	public void setUserManEmail(String userManEmail) {
		UserManEmail = userManEmail;
	}

	public Integer getUserManTag() {
		return UserManTag;
	}

	public void setUserManTag(int userManTag) {
		UserManTag = userManTag;
	}

	public Date getUserManDate() {
		return UserManDate;
	}

	public void setUserManDate(Date userManDate) {
		UserManDate = userManDate;
	}

	public String toString() {
		return "UserManagement{" +
							"UserManId=" + UserManId +"," + 
							"UserManName = '" + UserManName + '\'' + "," + 
							"UserManPwd = '" + UserManPwd + '\'' + "," +
							"UserManType=" + UserManType +"," + 
							"UserManEmail = '" + UserManEmail + '\'' + "," + 
							"UserManTag=" + UserManTag +"," + 
							"UserManDate = '" + UserManDate.toString() + '\'' + "," + 
							"}";
	}
	
}
