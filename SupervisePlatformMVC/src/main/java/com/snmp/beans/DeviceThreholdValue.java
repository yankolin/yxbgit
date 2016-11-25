package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_DeviceThreholdValue_d")
public class DeviceThreholdValue implements Serializable {

	
	private static final long serialVersionUID = 354323423423L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="ThreholdValueId")
	private Integer ThreholdValueId;
	
	@Column(name="DeviceId")
	private Integer DeviceId ;
	
	@Column(name="ThreholdValueCPU")
	private Integer  ThreholdValueCPU ;
	
	@Column(name="ThreholdValueMem")
	private long  ThreholdValueMem ;     //Bigint 对应long？
	
	@Column(name="ThreholdValueStor")
	private long  ThreholdValueStor; 
	
	@Column(name="ThreholdValueUpFlow")
	private long  ThreholdValueUpFlow; 
	
	@Column(name="ThreholdValueDownFlow")
	private long  ThreholdValueDownFlow;
	
	@Column(name="ThreholdValueDate")
	private Date  ThreholdValueDate;
	
	public Integer getThreholdValueId() {
		return ThreholdValueId;
	}

	public void setThreholdValueId(Integer threholdValueId) {
		ThreholdValueId = threholdValueId;
	}

	public Integer getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(Integer deviceId) {
		DeviceId = deviceId;
	}

	public Integer getThreholdValueCPU() {
		return ThreholdValueCPU;
	}

	public void setThreholdValueCPU(Integer threholdValueCPU) {
		ThreholdValueCPU = threholdValueCPU;
	}

	public long getThreholdValueMem() {
		return ThreholdValueMem;
	}

	public void setThreholdValueMem(long threholdValueMem) {
		ThreholdValueMem = threholdValueMem;
	}

	public long getThreholdValueStor() {
		return ThreholdValueStor;
	}

	public void setThreholdValueStor(long threholdValueStor) {
		ThreholdValueStor = threholdValueStor;
	}

	public long getThreholdValueUpFlow() {
		return ThreholdValueUpFlow;
	}

	public void setThreholdValueUpFlow(long threholdValueUpFlow) {
		ThreholdValueUpFlow = threholdValueUpFlow;
	}

	public long getThreholdValueDownFlow() {
		return ThreholdValueDownFlow;
	}

	public void setThreholdValueDownFlow(long threholdValueDownFlow) {
		ThreholdValueDownFlow = threholdValueDownFlow;
	}

	public Date getThreholdValueDate() {
		return ThreholdValueDate;
	}

	public void setThreholdValueDate(Date threholdValueDate) {
		ThreholdValueDate = threholdValueDate;
	}
	
	public String toString() {
		return "DeviceThreholdValue{" +
							"ThreholdValueId=" + ThreholdValueId +"," + 
							"DeviceId = " + DeviceId  + "," + 
							"ThreholdValueCPU = " + ThreholdValueCPU + "," + 
							"ThreholdValueMem = " + ThreholdValueMem + "," +
							"ThreholdValueStor = " + ThreholdValueStor + "," +
							"ThreholdValueUpFlow = " + ThreholdValueUpFlow + "," +
							"ThreholdValueUpFlow = " + ThreholdValueUpFlow + "," +
							"ThreholdValueDate = '" + ThreholdValueDate.toString()   + '\''+ 
							"}";
	}
	
}
