package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceVdiskInformation_d")
public class NetDeviceVdiskInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="VdiskInfoId")
	private Integer VdiskInfoId;
	
	@Column(name="VdiskName")
	private String VdiskName;
	
	@Column(name="VdiskCapacity")
	private String VdiskCapacity;
	
	
	
	@Column(name="VdiskDate")
	private Date VdiskDate;
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;

	public Integer getVdiskInfoId() {
		return VdiskInfoId;
	}

	public void setVdiskInfoId(Integer vdiskInfoId) {
		VdiskInfoId = vdiskInfoId;
	}

	public String getVdiskName() {
		return VdiskName;
	}

	public void setVdiskName(String vdiskName) {
		VdiskName = vdiskName;
	}

	public String getVdiskCapacity() {
		return VdiskCapacity;
	}

	public void setVdiskCapacity(String vdiskCapacity) {
		VdiskCapacity = vdiskCapacity;
	}



	public Date getVdiskDate() {
		return VdiskDate;
	}

	public void setVdiskDate(Date vdiskDate) {
		VdiskDate = vdiskDate;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}
	
	public String toString() {
		return "NetDeviceVdiskInfo{" +
							"VdiskInfoId=" +VdiskInfoId +"," + 
							"VdiskName = '" +VdiskName + '\'' + "," + 
							"VdiskCapacity = '" + VdiskCapacity + '\'' + "," +
							"VdiskDate = '" + VdiskDate.toString() + '\'' + "," +
							"NetDeviceId=" +NetDeviceId +
							"}";
	}

}
