package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceHostInformation_d")
public class NetDeviceHostInformation  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="HostInfoId")
	private Integer HostInfoId;
	
	@Column(name="HostName")
	private String HostName ;
	
	@Column(name="HostPortCount")
	private Integer HostPortCount;
	
	@Column(name="HostInfoDate")
	private Date HostInfoDate ;    //datetime对应Date？
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;

	public Integer getHostInfoId() {
		return HostInfoId;
	}

	public void setHostInfoId(Integer hostInfoId) {
		HostInfoId = hostInfoId;
	}

	public String getHostName() {
		return HostName;
	}

	public void setHostName(String hostName) {
		HostName = hostName;
	}

	public Integer getHostPortCount() {
		return HostPortCount;
	}

	public void setHostPortCount(Integer hostPortCount) {
		HostPortCount = hostPortCount;
	}


	public Date getHostInfoDate() {
		return HostInfoDate;
	}

	public void setHostInfoDate(Date hostInfoDate) {
		HostInfoDate = hostInfoDate;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}
	
	public String toString() {
		return "NetDeviceSystemInfo{" +
							"HostInfoId=" +HostInfoId +"," + 
							"HostName = '" + HostName + '\'' + "," + 
							"HostPortCount=" +HostPortCount +"," + 
							"HostInfoDate = '" + HostInfoDate.toString() + '\'' + "," +
							"NetDeviceId=" +NetDeviceId + 
							"}";
	}
	
}
