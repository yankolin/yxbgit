package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceDriveStatus_dTemp")
public class NetDeviceDriveStatus implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="DriveStatusId")
	private Integer DriveStatusId;

	@Column(name="DriveId")
	private Integer  DriveId ;
	
	@Column(name="DriveStatus")
	private String DriveStatus ;
	
	@Column(name="DriveStatusDate")
	private Date DriveStatusDate ;     //timestamp对应？
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId ;
	
	@Column(name="SlotId")
	private Integer SlotId ;

	public Integer getDriveStatusId() {
		return DriveStatusId;
	}

	public void setDriveStatusId(Integer driveStatusId) {
		DriveStatusId = driveStatusId;
	}

	public Integer getDriveId() {
		return DriveId;
	}

	public void setDriveId(Integer driveId) {
		DriveId = driveId;
	}

	public String getDriveStatus() {
		return DriveStatus;
	}

	public void setDriveStatus(String driveStatus) {
		DriveStatus = driveStatus;
	}

	public Date getDriveStatusDate() {
		return DriveStatusDate;
	}

	public void setDriveStatusDate(Date driveStatusDate) {
		DriveStatusDate = driveStatusDate;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}
	
	public String toString() {
		return "NetDeviceDriveStatus{" +
							"DriveStatusId=" + DriveStatusId + "," + 
							"DriveId=" + DriveId + "," + 
							"DriveStatus = '" + DriveStatus + '\'' + "," + 
							"DriveStatusDate = '" + DriveStatusDate.toString() + '\'' + "," +
							"NetDeviceId=" + NetDeviceId + 
							"}";
	}
	
}
