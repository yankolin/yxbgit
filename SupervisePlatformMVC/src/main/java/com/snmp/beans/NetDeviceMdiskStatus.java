package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceMdiskStatus_dTemp")
public class NetDeviceMdiskStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="MdiskStatusId")
	private Integer MdiskStatusId;
	
	@Column(name="MdiskId")
	private Integer MdiskId;
	
	@Column(name="MdiskStatus")
	private String MdiskStatus;
	
	@Column(name="MdiskStatusDate")
	private Date MdiskStatusDate;
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;

	public Integer getMdiskStatusId() {
		return MdiskStatusId;
	}

	public void setMdiskStatusId(Integer mdiskStatusId) {
		MdiskStatusId = mdiskStatusId;
	}

	public Integer getMdiskId() {
		return MdiskId;
	}

	public void setMdiskId(Integer mdiskId) {
		MdiskId = mdiskId;
	}

	public String getMdiskStatus() {
		return MdiskStatus;
	}

	public void setMdiskStatus(String mdiskStatus) {
		MdiskStatus = mdiskStatus;
	}

	public Date getMdiskStatusDate() {
		return MdiskStatusDate;
	}

	public void setMdiskStatusDate(Date mdiskStatusDate) {
		MdiskStatusDate = mdiskStatusDate;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}
	
	public String toString() {
		return "NetDeviceMdiskStatus{" +
							"MdiskStatusId=" + MdiskStatusId +"," + 
							"MdiskId=" + MdiskId +"," + 
							"MdiskStatus = '" + MdiskStatus + '\'' + "," + 
							"MdiskStatusDate = '" + MdiskStatusDate.toString() + '\'' + "," +
							"NetDeviceId=" + NetDeviceId +
							"}";
	}

}
