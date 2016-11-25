package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ESM_SystemLog_l")

public class SystemLog implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="SystemLogId")
	private Integer SystemLogId;
	
	@Column(name="UserId")
	private Integer UserId;
	
	@Column(name="SystemLogIp")
	private String SystemLogIp;
	
	@Column(name="SystemLogDesc")
	private String  SystemLogDesc;    //text对应String?
	
	@Column(name="SystemLogDate")
	private Date SystemLogDate;

	public Integer getSystemLogId() {
		return SystemLogId;
	}

	public void setSystemLogId(Integer systemLogId) {
		SystemLogId = systemLogId;
	}

	public Integer getUserId() {
		return UserId;
	}

	public void setUserId(Integer userId) {
		UserId = userId;
	}

	public String getSystemLogIp() {
		return SystemLogIp;
	}

	public void setSystemLogIp(String systemLogIp) {
		SystemLogIp = systemLogIp;
	}

	public String getSystemLogDesc() {
		return SystemLogDesc;
	}

	public void setSystemLogDesc(String systemLogDesc) {
		SystemLogDesc = systemLogDesc;
	}

	public Date getSystemLogDate() {
		return SystemLogDate;
	}

	public void setSystemLogDate(Date systemLogDate) {
		SystemLogDate = systemLogDate;
	}
	
	public String toString() {
		return "SystemLog{" +
							"SystemLogId=" + SystemLogId + "," + 
							"UserId=" + UserId + "," + 
							"SystemLogIp = '" + SystemLogIp + '\'' + "," + 
							"SystemLogDesc = '" + SystemLogDesc + '\'' + "," +
							"SystemLogDate = '" + SystemLogDate.toString() + '\'' + 
							"}";
	}
	
}
