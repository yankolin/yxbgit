package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ESM_DeviceManagemnt_d")

public class DeviceManagemnt implements Serializable {

	private static final long serialVersionUID = 354323423423L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="DeviceId")
	private Integer DeviceId;
	
	@Column(name="DeviceIp")
	private String DeviceIp ;
	
	@Column(name="DeviceName")
	private String DeviceName ;
	
	@Column(name="DeviceType")
	private Integer DeviceType ;
	
	@Column(name="DeviceLoc")
	private String DeviceLoc ;
	
	@Column(name="DeviceDesc")
	private String DeviceDesc ;  
	
	@Column(name="DeviceDate")
	private Date DeviceDate ;  
	
	public Integer getDeviceId() {
		return DeviceId;
	}
	public void setDeviceId(Integer DeviceId) {
		this.DeviceId = DeviceId;
	}

	public String getDeviceIp() {
		return DeviceIp;
	}
	public void setDeviceIp(String DeviceIp) {
		this.DeviceIp = DeviceIp == null ? null:DeviceIp.trim();
	}
	
	public String getDeviceName() {
		return DeviceName;
	}
	public void setDeviceName(String DeviceName) {
		this.DeviceName = DeviceName == null ? null:DeviceName.trim();
	}
	
	public Integer getDeviceType() {
		return DeviceType;
	}
	public void setDeviceType(Integer DeviceType) {
		this.DeviceType = DeviceType;
	}
	
	public String getDeviceLoc() {
		return DeviceLoc;
	}
	public void setDeviceLoc(String DeviceLoc) {
		this.DeviceLoc = DeviceLoc == null ? null:DeviceLoc.trim();
	}
	
	public String getDeviceDesc() {
		return DeviceDesc;
	}
	public void setDeviceDesc(String DeviceDesc) {
		this.DeviceDesc = DeviceDesc == null ? null:DeviceDesc.trim();
	}
	
	public Date getDeviceDate() {
		return DeviceDate;
	}
	public void setDeviceDate(Date deviceDate) {
		DeviceDate = deviceDate;
	}
	
	public String toString() {
		return "DeviceInfo{" +
							"DeviceId=" + DeviceId +"," + 
							"DeviceIp = '" + DeviceIp + '\'' + "," + 
							"DeviceName = '" + DeviceName + '\'' + "," + 
							"DeviceType = " + DeviceType + "," +
							"DeviceLoc = '" + DeviceLoc + '\'' + "," +
							"DeviceDesc = '" + DeviceDesc + '\'' + "," +
							"DeviceDate = '" + DeviceDate.toString() + '\''  +
							"}";
	}
}
