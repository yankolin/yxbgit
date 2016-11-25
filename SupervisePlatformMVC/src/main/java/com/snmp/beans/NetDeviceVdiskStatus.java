package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceVdiskStatus_dTemp")
public class NetDeviceVdiskStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="VdiskStatusId")
	private Integer VdiskStatusId;
	
	@Column(name="VdiskName")
	private String VdiskName;
	
	@Column(name="VdiskStatus")
	private String VdiskStatus;
	
	@Column(name="VdiskDate")
	private Date VdiskDate;
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;

	public Integer getVdiskStatusId() {
		return VdiskStatusId;
	}

	public void setVdiskStatusId(Integer vdiskStatusId) {
		VdiskStatusId = vdiskStatusId;
	}

	public String getVdiskName() {
		return VdiskName;
	}

	public void setVdiskName(String vdiskName) {
		VdiskName = vdiskName;
	}

	public String getVdiskStatus() {
		return VdiskStatus;
	}

	public void setVdiskStatus(String vdiskStatus) {
		VdiskStatus = vdiskStatus;
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
		return "NetDeviceVdiskStatus{" +
							"VdiskStatusId=" +VdiskStatusId + "," + 
							"VdiskName = '" + VdiskName + '\'' + "," + 
							"VdiskStatus = '" + VdiskStatus + '\'' + "," +
							"VdiskDate = '" + VdiskDate.toString() + '\'' + "," +
							"NetDeviceId=" +NetDeviceId + "," + 
							"}";
	}
	
}
