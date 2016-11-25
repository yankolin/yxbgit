package com.snmp.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceSystemInformation_d")
public class NetDeviceSystemInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="SystemInfoId")
	private Integer SystemInfoId;
	
	@Column(name="DeviceName")
	private String DeviceName;
	
	@Column(name="SystemTotalCapacity")
	private String SystemTotalCapacity;
	
	@Column(name="SystemTotalFreeSpace")
	private String SystemTotalFreeSpace;
	
	@Column(name="SystemIp")
	private String SystemIp;
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;

	public Integer getSystemInfoId() {
		return SystemInfoId;
	}

	public void setSystemInfoId(Integer systemInfoId) {
		SystemInfoId = systemInfoId;
	}

	public String getDeviceName() {
		return DeviceName;
	}

	public void setDeviceName(String deviceName) {
		DeviceName = deviceName;
	}

	public String getSystemTotalCapacity() {
		return SystemTotalCapacity;
	}

	public void setSystemTotalCapacity(String systemTotalCapacity) {
		SystemTotalCapacity = systemTotalCapacity;
	}

	public String getSystemTotalFreeSpace() {
		return SystemTotalFreeSpace;
	}

	public void setSystemTotalFreeSpace(String systemTotalFreeSpace) {
		SystemTotalFreeSpace = systemTotalFreeSpace;
	}

	public String getSystemIp() {
		return SystemIp;
	}

	public void setSystemIp(String systemIp) {
		SystemIp = systemIp;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}

	public String toString() {
		return "NetDeviceSystemInfo{" +
							"SystemInfoId=" + SystemInfoId +"," + 
							"DeviceName = '" + DeviceName + '\'' + "," + 
							"SystemTotalCapacity = '" + SystemTotalCapacity + '\'' + "," +
							"SystemTotalFreeSpace = '" +SystemTotalFreeSpace + '\'' + "," +
							"SystemIp= '" +SystemIp + '\'' + "," +
							"NetDeviceId=" + NetDeviceId +
							"}";
	}
	
 
}
