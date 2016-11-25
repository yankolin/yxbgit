package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceHostStatus_dTemp")
public class NetDeviceHostStatus  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="HostStatusId")
	private Integer HostStatusId;
	
	@Column(name="HostName")
	private String HostName ;
	
	@Column(name="HostStatus")
	private String HostStatus ;
	
	@Column(name="HostStatusDate")
	private Date HostStatusDate ;   
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;

	public Integer getHostStatusId() {
		return HostStatusId;
	}

	public void setHostStatusId(Integer hostStatusId) {
		HostStatusId = hostStatusId;
	}

	public String getHostName() {
		return HostName;
	}

	public void setHostName(String hostName) {
		HostName = hostName;
	}

	public String getHostStatus() {
		return HostStatus;
	}

	public void setHostStatus(String hostStatus) {
		HostStatus = hostStatus;
	}

	public Date getHostStatusDate() {
		return HostStatusDate;
	}

	public void setHostStatusDate(Date hostStatusDate) {
		HostStatusDate = hostStatusDate;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}

	public String toString() {
		return "NetDeviceHostStatus{" +
							"HostStatusId=" + HostStatusId +"," + 
							"HostName = '" + HostName + '\'' + "," + 
							"HostStatus = '" + HostStatus + '\'' + "," +
							"HostStatusDate = '" + HostStatusDate.toString() + '\'' + "," +
							"NetDeviceId=" + NetDeviceId +
							"}";
	}
}
