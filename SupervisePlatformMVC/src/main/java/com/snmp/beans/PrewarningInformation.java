package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_PrewarningInformation_d")
public class PrewarningInformation implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="PrewarningInfoId")
	private Integer PrewarningInfoId;
	
	@Column(name="DeviceId")
	private Integer DeviceId;
	
	@Column(name="PrewarningInfoCPU")
	private Integer PrewarningInfoCPU;
	
	@Column(name="PrewarningInfoMem")
	private Long  PrewarningInfoMem;
	
	@Column(name="PrewarningInfoStor")
	private Long  PrewarningInfoStor;
	
	@Column(name="PrewarningInfoUpFlow")
	private Long  PrewarningInfoUpFlow;
	
	@Column(name="PrewarningInfoDownFlow")
	private Long  PrewarningInfoDownFlow;
	
	@Column(name="PrewarningInfoDate")
	private Date PrewarningInfoDate;

	public Integer getPrewarningInfoId() {
		return PrewarningInfoId;
	}

	public void setPrewarningInfoId(Integer prewarningInfoId) {
		PrewarningInfoId = prewarningInfoId;
	}

	public Integer getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(Integer deviceId) {
		DeviceId = deviceId;
	}

	public Integer getPrewarningInfoCPU() {
		return PrewarningInfoCPU;
	}

	public void setPrewarningInfoCPU(Integer prewarningInfoCPU) {
		PrewarningInfoCPU = prewarningInfoCPU;
	}

	public Long getPrewarningInfoMem() {
		return PrewarningInfoMem;
	}

	public void setPrewarningInfoMem(Long prewarningInfoMem) {
		PrewarningInfoMem = prewarningInfoMem;
	}

	public Long getPrewarningInfoStor() {
		return PrewarningInfoStor;
	}

	public void setPrewarningInfoStor(Long prewarningInfoStor) {
		PrewarningInfoStor = prewarningInfoStor;
	}

	public Long getPrewarningInfoUpFlow() {
		return PrewarningInfoUpFlow;
	}

	public void setPrewarningInfoUpFlow(Long prewarningInfoUpFlow) {
		PrewarningInfoUpFlow = prewarningInfoUpFlow;
	}

	public Long getPrewarningInfoDownFlow() {
		return PrewarningInfoDownFlow;
	}

	public void setPrewarningInfoDownFlow(Long prewarningInfoDownFlow) {
		PrewarningInfoDownFlow = prewarningInfoDownFlow;
	}

	public Date getPrewarningInfoDate() {
		return PrewarningInfoDate;
	}

	public void setPrewarningInfoDate(Date prewarningInfoDate) {
		PrewarningInfoDate = prewarningInfoDate;
	}

	public String toString() {
		return "PrewarningInfo{" +
							"PrewarningInfoId=" +PrewarningInfoId +"," + 
							"DeviceId=" +DeviceId+"," + 
							"PrewarningInfoCPU=" +PrewarningInfoCPU +"," + 
							"PrewarningInfoMem=" +PrewarningInfoMem +"," + 
							"PrewarningInfoStor=" +PrewarningInfoStor +"," + 
							"PrewarningInfoUpFlow=" +PrewarningInfoUpFlow +"," + 
							"PrewarningInfoDownFlow=" +PrewarningInfoDownFlow+"," + 
							"PrewarningInfoDate = '" + PrewarningInfoDate.toString() + '\'' + 
							"}";
	}
	
}
