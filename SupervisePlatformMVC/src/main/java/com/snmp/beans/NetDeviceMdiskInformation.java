package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_NetDeviceMdiskInformation_d")
public class NetDeviceMdiskInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="MdiskInfoId")
	private Integer MdiskInfoId;
	
	@Column(name="MdiskId")
	private Integer MdiskId;
	
	@Column(name="MdiskCapacity")
	private Integer MdiskCapacity;
	
	@Column(name="PoolName")
	private String PoolName;
	
	@Column(name="MdiskInfoDate")
	private Date MdiskInfoDate ;   
	
	@Column(name="NetDeviceId")
	private Integer NetDeviceId;

	public Integer getMdiskInfoId() {
		return MdiskInfoId;
	}

	public void setMdiskInfoId(Integer mdiskInfoId) {
		MdiskInfoId = mdiskInfoId;
	}

	public Integer getMdiskId() {
		return MdiskId;
	}

	public void setMdiskId(Integer mdiskId) {
		MdiskId = mdiskId;
	}

	public Integer getMdiskCapacity() {
		return MdiskCapacity;
	}

	public void setMdiskCapacity(Integer mdiskCapacity) {
		MdiskCapacity = mdiskCapacity;
	}


	public Date getMdiskInfoDate() {
		return MdiskInfoDate;
	}

	public void setMdiskInfoDate(Date mdiskInfoDate) {
		MdiskInfoDate = mdiskInfoDate;
	}

	public Integer getNetDeviceId() {
		return NetDeviceId;
	}

	public void setNetDeviceId(Integer netDeviceId) {
		NetDeviceId = netDeviceId;
	}

	public String toString() {
		return "NetDeviceMdiskInfo{" +
							"MdiskInfoId=" + MdiskInfoId +"," + 
							"MdiskId=" + MdiskId +"," + 
							"MdiskCapacity=" + MdiskCapacity +"," + 
							"PoolName=" + PoolName +"," + 
							"MdiskInfoDate = '" + MdiskInfoDate.toString() + '\'' + "," + 
							"NetDeviceId=" + NetDeviceId +
							"}";
	}

	public String getPoolName() {
		return PoolName;
	}

	public void setPoolName(String poolName) {
		PoolName = poolName;
	}
	
}
