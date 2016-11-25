package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceAbnormalInformation_d")
public class NetDeviceAbnormalInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="AbnormalId")
	private Integer AbnormalId;
	
	@Column(name="AbnormalDriveId")
	private Integer AbnormalDriveId;
	
	@Column(name="AbnormalMdiskId")
	private Integer AbnormalMdiskId;
	
	@Column(name="AbnormalEnclosureId")
	private Integer AbnormalEnclosureId;
	
	@Column(name="AbnormalVdiskId")
	private Integer AbnormalVdiskId;
	
	@Column(name="AbnormalHostName")
	private String AbnormalHostName;
	
	@Column(name="AbnormalData")
	private Date AbnormalData;

	public Integer getAbnormalId() {
		return AbnormalId;
	}

	public void setAbnormalId(Integer abnormalId) {
		AbnormalId = abnormalId;
	}

	public Integer getAbnormalDriveId() {
		return AbnormalDriveId;
	}

	public void setAbnormalDriveId(Integer abnormalDriveId) {
		AbnormalDriveId = abnormalDriveId;
	}

	public Integer getAbnormalMdiskId() {
		return AbnormalMdiskId;
	}

	public void setAbnormalMdiskId(Integer abnormalMdiskId) {
		AbnormalMdiskId = abnormalMdiskId;
	}

	public Integer getAbnormalEnclosureId() {
		return AbnormalEnclosureId;
	}

	public void setAbnormalEnclosureId(Integer abnormalEnclosureId) {
		AbnormalEnclosureId = abnormalEnclosureId;
	}

	public Integer getAbnormalVdiskId() {
		return AbnormalVdiskId;
	}

	public void setAbnormalVdiskId(Integer abnormalVdiskId) {
		AbnormalVdiskId = abnormalVdiskId;
	}

	public String getAbnormalHostName() {
		return AbnormalHostName;
	}

	public void setAbnormalHostName(String abnormalHostName) {
		AbnormalHostName = abnormalHostName;
	}

	public Date getAbnormalData() {
		return AbnormalData;
	}

	public void setAbnormalData(Date abnormalData) {
		AbnormalData = abnormalData;
	}

	public String toString() {
		return "NetDeviceAbnormalInfo{" +
							"AbnormalId=" + AbnormalId + "," + 
							"AbnormalDriveId=" + AbnormalDriveId + "," + 
							"AbnormalMdiskId=" +AbnormalMdiskId + "," + 
							"AbnormalEnclosureId=" +AbnormalEnclosureId + "," + 
							"AbnormalVdiskId=" + AbnormalVdiskId + "," + 
							"AbnormalHostName = '" + AbnormalHostName + '\'' + "," + 
							"AbnormalData = '" + AbnormalData.toString() + '\'' + 
							"}";
	}
	
}
