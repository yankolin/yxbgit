package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class NetDeviceGlobalStatus   implements Serializable{
	private static final long serialVersionUID = 15L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="NetDeviceGlobalId")
	private Integer NetDeviceGlobalId;
	
	@Column(name="NetDeviceIp")
	private String NetDeviceIp;
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;
	
	@Column(name="TotalDriveNum")
	private Integer TotalDriveNum;
	
	@Column(name="OfflineDriveNum")
	private Integer OfflineDriveNum;
	
	@Column(name="TotalMdiskNum")
	private Integer TotalMdiskNum;
	
	@Column(name="OfflineMdiskNum")
	private Integer OfflineMdiskNum;
	
	@Column(name="TotalVdiskNum")
	private Integer TotalVdiskNum;
	
	@Column(name="OfflineVdiskNum")
    private Integer OfflineVdiskNum;
    
	@Column(name="TotalHostNum")
	private Integer TotalHostNum;
	
	 @Column(name="OfflineHostNum")
	 private Integer OfflineHostNum;
	 
	 @Column(name="SystemTotalCapacity")
	 private String SystemTotalCapacity;
	 
	
	@Column(name="SystemTotalFreeSpace")
	 private String SystemTotalFreeSpace;
	
	@Column(name="NetDeviceName")
	private String NetDeviceName;
	
	@Column(name="NetDeviceGlobalStatusDate")
	private Date  NetDeviceGlobalStatusDate;
	
	public Integer getNetDeviceGlobalId() {
		return NetDeviceGlobalId;
	}

	public void setNetDeviceGlobalId(Integer netDeviceGlobalId) {
		NetDeviceGlobalId = netDeviceGlobalId;
	}

	public String getNetDeviceIp() {
		return NetDeviceIp;
	}

	public void setNetDeviceIp(String netDeviceIp) {
		NetDeviceIp = netDeviceIp;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}

	public Integer getTotalDriveNum() {
		return TotalDriveNum;
	}

	public void setTotalDriveNum(Integer totalDriveNum) {
		TotalDriveNum = totalDriveNum;
	}

	public Integer getOfflineDriveNum() {
		return OfflineDriveNum;
	}

	public void setOfflineDriveNum(Integer offlineDriveNum) {
		OfflineDriveNum = offlineDriveNum;
	}

	public Integer getTotalMdiskNum() {
		return TotalMdiskNum;
	}

	public void setTotalMdiskNum(Integer totalMdiskNum) {
		TotalMdiskNum = totalMdiskNum;
	}

	public Integer getOfflineMdiskNum() {
		return OfflineMdiskNum;
	}

	public void setOfflineMdiskNum(Integer offlineMdiskNum) {
		OfflineMdiskNum = offlineMdiskNum;
	}

	public Integer getTotalVdiskNum() {
		return TotalVdiskNum;
	}

	public void setTotalVdiskNum(Integer totalVdiskNum) {
		TotalVdiskNum = totalVdiskNum;
	}

	public Integer getOfflineVdiskNum() {
		return OfflineVdiskNum;
	}

	public void setOfflineVdiskNum(Integer offlineVdiskNum) {
		OfflineVdiskNum = offlineVdiskNum;
	}

	public Integer getTotalHostNum() {
		return TotalHostNum;
	}

	public void setTotalHostNum(Integer totalHostNum) {
		TotalHostNum = totalHostNum;
	}

	public Integer getOfflineHostNum() {
		return OfflineHostNum;
	}

	public void setOfflineHostNum(Integer offlineHostNum) {
		OfflineHostNum = offlineHostNum;
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

	public String getNetDeviceName() {
		return NetDeviceName;
	}

	public void setNetDeviceName(String netDeviceName) {
		NetDeviceName = netDeviceName;
	}

	public Date getNetDeviceGlobalStatusDate() {
		return NetDeviceGlobalStatusDate;
	}

	public void setNetDeviceGlobalStatusDate(Date netDeviceGlobalStatusDate) {
		NetDeviceGlobalStatusDate = netDeviceGlobalStatusDate;
	}
	public String toString() {
		return "NetDeviceGlobalStatus{" +
							"NetDeviceGlobalId =" + NetDeviceGlobalId +"," + 
							"NetDeviceIp=" + NetDeviceIp+"," + 
							"NetDeviceId=" + NetDeviceId+"," + 
							" TotalDriveNum=" +  TotalDriveNum+"," + 
							" OfflineDriveNum=" + OfflineDriveNum +"," + 
							"TotalMdiskNum=" + TotalMdiskNum +"," + 
							"OfflineMdiskNum=" + OfflineMdiskNum +"," + 
							"TotalVdiskNum=" + TotalVdiskNum +"," + 
							"OfflineVdiskNum=" + OfflineVdiskNum +"," + 
							"TotalHostNum=" + TotalHostNum +"," + 
							"OfflineHostNum=" + OfflineHostNum +"," + 
							"NetDeviceName=" + NetDeviceName +"," + 
							"NetDeviceGlobalStatusDate=" + NetDeviceGlobalStatusDate +
							"}";
	}
	

}
