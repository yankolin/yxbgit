package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceDriveInformation_d")//实现虚拟化的接口
public class NetDeviceDriveInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="DriveInfoId")
	private Integer DriveInfoId;
	
	@Column(name="DriveCapacity")
	private Integer  DriveCapacity ;
	
	@Column(name="DriveId")
	private Integer  DriveId;
	
	@Column(name="MdiskId")
	private Integer  MdiskId;
	
	@Column(name="EnclosureId")
	private Integer EnclosureId ;
	
	@Column(name="SlotId")
	private Integer  SlotId ;
	
	@Column(name="NetDeviceId")
	private Integer  NetDeviceId ;
	
	@Column(name="DriveInfoDate")
	private Date  DriveInfoDate ;

	public Integer getDriveInfoId() {
		return DriveInfoId;
	}

	public void setDriveInfoId(Integer driveInfoId) {
		DriveInfoId = driveInfoId;
	}

	public Integer getDriveCapacity() {
		return DriveCapacity;
	}

	public void setDriveCapacity(Integer driveCapacity) {
		DriveCapacity = driveCapacity;
	}

	
	public Integer getDriveId() {
		return DriveId;
	}

	public void setDriveId(Integer driveId) {
		DriveId = driveId;
	}

	public Integer getMdiskId() {
		return MdiskId;
	}

	public void setMdiskId(Integer mdiskId) {
		MdiskId = mdiskId;
	}

	public Integer getEnclosureId() {
		return EnclosureId;
	}

	public void setEnclosureId(Integer enclosureId) {
		EnclosureId = enclosureId;
	}

	public Integer getSlotId() {
		return SlotId;
	}

	public void setSlotId(Integer slotId) {
		SlotId = slotId;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}

	public Date getDriveInfoDate() {
		return DriveInfoDate;
	}

	public void setDriveInfoDate(Date driveInfoDate) {
		DriveInfoDate = driveInfoDate;
	}
	
	public String toString() {
		return "NetDeviceDriveInfo{" +
							"DriveInfoId=" + DriveInfoId +"," + 
							"DriveCapacity=" + DriveCapacity +"," + 
							"DriveId=" + DriveId +"," + 
							"MdiskId=" + MdiskId +"," + 
							"EnclosureId=" + EnclosureId +"," + 
							"SlotId=" + SlotId +"," + 
							"NetDeviceId=" + NetDeviceId +"," + 
							"DriveInfoDate = '" + DriveInfoDate.toString() + '\'' + 
							"}";
	}
	
}
