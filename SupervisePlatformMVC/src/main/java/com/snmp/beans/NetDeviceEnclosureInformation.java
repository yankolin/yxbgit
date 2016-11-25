package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceEnclosureInformation_d")
public class NetDeviceEnclosureInformation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="EnclosureInfoId")
	private Integer EnclosureInfoId;
	
	@Column(name="EnclosureInfoDate")
	private Date EnclosureInfoDate ;  
	
	public Date getEnclosureInfoDate() {
		return EnclosureInfoDate;
	}

	public void setEnclosureInfoDate(Date enclosureInfoDate) {
		EnclosureInfoDate = enclosureInfoDate;
	}


	@Column(name="EnclosureSerialNumber")
	private String EnclosureSerialNumber ;
	
	@Column(name="EnclosureId")
	private String EnclosureId ;
	
	public String getEnclosureId() {
		return EnclosureId;
	}

	public void setEnclosureId(String enclosureId) {
		EnclosureId = enclosureId;
	}


	@Column(name="EnclosureType")
	private String EnclosureType ;
	
	@Column(name="Managed")
	private String  Managed ;
	
	@Column(name="IoGroupId")
	private Integer IoGroupId;
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;
	
	

	public Integer getEnclosureInfoId() {
		return EnclosureInfoId;
	}

	public void setEnclosureInfoId(Integer enclosureInfoId) {
		EnclosureInfoId = enclosureInfoId;
	}

	public String getEnclosureSerialNumber() {
		return EnclosureSerialNumber;
	}

	public void setEnclosureSerialNumber(String enclosureSerialNumber) {
		EnclosureSerialNumber = enclosureSerialNumber;
	}

	public String getEnclosureType() {
		return EnclosureType;
	}

	public void setEnclosureType(String enclosureType) {
		EnclosureType = enclosureType;
	}

	public String getManaged() {
		return Managed;
	}

	public void setManaged(String managed) {
		Managed = managed;
	}

	public Integer getIoGroupId() {
		return IoGroupId;
	}

	public void setIoGroupId(Integer ioGroupId) {
		IoGroupId = ioGroupId;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}
	
	public String toString() {
		return "NetDeviceEnclosureInfo{" +
							"EnclosureInfoId=" +EnclosureInfoId +"," + 
							"EnclosureSerialNumber = '" + EnclosureSerialNumber + '\'' + "," + 
							"EnclosureType = '" + EnclosureType + '\'' + "," +
				/*			"IsManaged = '" + IsManaged + '\'' + "," +*/
							"IoGroupId=" +IoGroupId +"," + 
							"NetDeviceId=" +NetDeviceId  + 
							"}";
	}


}
