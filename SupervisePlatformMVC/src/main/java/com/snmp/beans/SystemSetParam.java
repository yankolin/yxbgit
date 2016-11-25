package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_SystemSetParam_c")
public class SystemSetParam implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="SystemSetId")
	private Integer SystemSetId;
	
	@Column(name="DeviceType")
	private Integer DeviceType;
	
	@Column(name="SystemSetCollectPeriod")
	private Integer SystemSetCollectPeriod;
	
	@Column(name="SystemSetCleanTime")
	private Integer SystemSetCleanTime;
	
	@Column(name="SystemSetStorCapacity")
	private Integer SystemSetStorCapacity;
	
	@Column(name="SystemSetDate")
	private Date SystemSetDate;

	public Integer getSystemSetId() {
		return SystemSetId;
	}

	public void setSystemSetId(Integer systemSetId) {
		SystemSetId = systemSetId;
	}

	public Integer getDeviceType() {
		return DeviceType;
	}

	public void setDeviceType(Integer deviceType) {
		DeviceType = deviceType;
	}

	public Integer getSystemSetCollectPeriod() {
		return SystemSetCollectPeriod;
	}

	public void setSystemSetCollectPeriod(Integer systemSetCollectPeriod) {
		SystemSetCollectPeriod = systemSetCollectPeriod;
	}

	public Integer getSystemSetCleanTime() {
		return SystemSetCleanTime;
	}

	public void setSystemSetCleanTime(Integer systemSetCleanTime) {
		SystemSetCleanTime = systemSetCleanTime;
	}

	public Integer getSystemSetStorCapacity() {
		return SystemSetStorCapacity;
	}

	public void setSystemSetStorCapacity(Integer systemSetStorCapacity) {
		SystemSetStorCapacity = systemSetStorCapacity;
	}

	public Date getSystemSetDate() {
		return SystemSetDate;
	}

	public void setSystemSetDate(Date systemSetDate) {
		SystemSetDate = systemSetDate;
	}

	public String toString() {
		return "SystemSetParam{" +
							"SystemSetId=" + SystemSetId + "," +
							"DeviceType=" + DeviceType + "," +
							"SystemSetCollectPeriod=" + SystemSetCollectPeriod + "," +
							"SystemSetCleanTime=" + SystemSetCleanTime + "," +
							"SystemSetStorCapacity=" + SystemSetStorCapacity + "," +
							"SystemSetDate = '" + SystemSetDate.toString() + '\'' + 
							"}";
	}
	
}
