package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceEnclosureStatus_dTemp")
public class NetDeviceEnclosureStatus  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="EnclosureStatusId")
	private Integer EnclosureStatusId;
	
	@Column(name="EnclosureId")
	private Integer EnclosureId;
	
	@Column(name="EnclosureStatus")
	private String EnclosureStatus ;
	
	@Column(name="EnclosureStatusDate")
	private Date EnclosureStatusDate ;
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;

	public Integer getEnclosureStatusId() {
		return EnclosureStatusId;
	}

	public void setEnclosureStatusId(Integer enclosureStatusId) {
		EnclosureStatusId = enclosureStatusId;
	}

	public Integer getEnclosureId() {
		return EnclosureId;
	}

	public void setEnclosureId(Integer enclosureId) {
		EnclosureId = enclosureId;
	}

	public String getEnclosureStatus() {
		return EnclosureStatus;
	}

	public void setEnclosureStatus(String enclosureStatus) {
		EnclosureStatus = enclosureStatus;
	}

	public Date  getEnclosureStatusDate() {
		return EnclosureStatusDate;
	}

	public void setEnclosureStatusDate(Date enclosureStatusDate) {
		EnclosureStatusDate = enclosureStatusDate;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}
	
	public String toString() {
		return "NetDeviceEnclosureStatus{" +
							"EnclosureStatusId=" + EnclosureStatusId +"," + 
							"EnclosureId=" + EnclosureId +"," + 
							"EnclosureStatus = '" + EnclosureStatus + '\'' + "," + 
							"EnclosureStatusDate = '" + EnclosureStatusDate.toString() + '\'' + "," + 
							"NetDeviceId=" + NetDeviceId +"," + 
							"}";
	}

	
}
