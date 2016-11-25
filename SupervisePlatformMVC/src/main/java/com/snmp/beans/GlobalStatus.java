package com.snmp.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="ESM_GlobalStatus_d")

public class GlobalStatus implements Serializable {

	private static final long serialVersionUID = 354323423423L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="GlobalId")
	private Integer GlobalId;
	
	@Column(name="AverageCPURate")
	private Float AverageCPURate ;
	
	@Column(name="AverageMemoryRate")
	private Float AverageMemoryRate ;
	
	@Column(name="AverageStorRate")
	private Float AverageStorRate ;
	
	@Column(name="AverageUpFlow")
	private Float AverageUpFlow ;
	
	@Column(name="AverageDownFlow")
	private Float AverageDownFlow ;
	
	@Column(name="TotalServiceNum")
	private Integer TotalServiceNum ;
	
	@Column(name="TotalNetDeviceNum")
	private Integer TotalNetDeviceNum ;
	
	@Column(name="TotalSwitchDeviceNum")
	private Integer TotalSwitchDeviceNum ;
	
	@Column(name="TotalNormalDeviceNum")
	private Integer TotalNormalDeviceNum ;
	
	@Column(name="TotalPrewarningDeviceNum")
	private Integer TotalPrewarningDeviceNum ;
	
	@Column(name="NormalServiceNum")
	private Integer NormalServiceNum ;
	
	@Column(name="NormalNetDeviceNum")
	private Integer NormalNetDeviceNum ;
	
	@Column(name="NormalSwitchDeviceNum")
	private Integer NormalSwitchDeviceNum ;
	
	@Column(name="PrewarningServiceNum")
	private Integer PrewarningServiceNum ;
	
	@Column(name="PrewarningNetDeviceNum")
	private Integer PrewarningNetDeviceNum ;
	
	@Column(name="PrewarningSwitchDeviceNum")
	private Integer PrewarningSwitchDeviceNum ;
	
	public Integer getGlobalId() {
		return GlobalId;
	}



	public void setGlobalId(Integer globalId) {
		GlobalId = globalId;
	}



	public Float getAverageCPURate() {
		return AverageCPURate;
	}



	public void setAverageCPURate(Float averageCPURate) {
		AverageCPURate = averageCPURate;
	}



	public Float getAverageMemoryRate() {
		return AverageMemoryRate;
	}



	public void setAverageMemoryRate(Float averageMemoryRate) {
		AverageMemoryRate = averageMemoryRate;
	}



	public Float getAverageStorRate() {
		return AverageStorRate;
	}



	public void setAverageStorRate(Float averageStorRate) {
		AverageStorRate = averageStorRate;
	}



	public Float getAverageUpFlow() {
		return AverageUpFlow;
	}



	public void setAverageUpFlow(Float averageUpFlow) {
		AverageUpFlow = averageUpFlow;
	}



	public Float getAverageDownFlow() {
		return AverageDownFlow;
	}



	public void setAverageDownFlow(Float averageDownFlow) {
		AverageDownFlow = averageDownFlow;
	}



	public Integer getTotalServiceNum() {
		return TotalServiceNum;
	}



	public void setTotalServiceNum(Integer totalServiceNum) {
		TotalServiceNum = totalServiceNum;
	}



	public Integer getTotalNetDeviceNum() {
		return TotalNetDeviceNum;
	}



	public void setTotalNetDeviceNum(Integer totalNetDeviceNum) {
		TotalNetDeviceNum = totalNetDeviceNum;
	}



	public Integer getTotalSwitchDeviceNum() {
		return TotalSwitchDeviceNum;
	}



	public void setTotalSwitchDeviceNum(Integer totalSwitchDeviceNum) {
		TotalSwitchDeviceNum = totalSwitchDeviceNum;
	}



	public Integer getTotalNormalDeviceNum() {
		return TotalNormalDeviceNum;
	}



	public void setTotalNormalDeviceNum(Integer totalNormalDeviceNum) {
		TotalNormalDeviceNum = totalNormalDeviceNum;
	}



	public Integer getTotalPrewarningDeviceNum() {
		return TotalPrewarningDeviceNum;
	}



	public void setTotalPrewarningDeviceNum(Integer totalPrewarningDeviceNum) {
		TotalPrewarningDeviceNum = totalPrewarningDeviceNum;
	}



	public Integer getNormalServiceNum() {
		return NormalServiceNum;
	}



	public void setNormalServiceNum(Integer normalServiceNum) {
		NormalServiceNum = normalServiceNum;
	}



	public Integer getNormalNetDeviceNum() {
		return NormalNetDeviceNum;
	}



	public void setNormalNetDeviceNum(Integer normalNetDeviceNum) {
		NormalNetDeviceNum = normalNetDeviceNum;
	}



	public Integer getNormalSwitchDeviceNum() {
		return NormalSwitchDeviceNum;
	}



	public void setNormalSwitchDeviceNum(Integer normalSwitchDeviceNum) {
		NormalSwitchDeviceNum = normalSwitchDeviceNum;
	}



	public Integer getPrewarningServiceNum() {
		return PrewarningServiceNum;
	}



	public void setPrewarningServiceNum(Integer prewarningServiceNum) {
		PrewarningServiceNum = prewarningServiceNum;
	}



	public Integer getPrewarningNetDeviceNum() {
		return PrewarningNetDeviceNum;
	}



	public void setPrewarningNetDeviceNum(Integer prewarningNetDeviceNum) {
		PrewarningNetDeviceNum = prewarningNetDeviceNum;
	}



	public Integer getPrewarningSwitchDeviceNum() {
		return PrewarningSwitchDeviceNum;
	}



	public void setPrewarningSwitchDeviceNum(Integer prewarningSwitchDeviceNum) {
		PrewarningSwitchDeviceNum = prewarningSwitchDeviceNum;
	}



	public String toString() {
		return "GlobalStatus{" +
							"GlobalId=" + GlobalId +"," + 
							"AverageCPURate=" + AverageCPURate +"," + 
							"AverageMemoryRate=" + AverageMemoryRate +"," + 
							"AverageStorRate=" + AverageStorRate +"," + 
							"AverageUpFlow=" + AverageUpFlow +"," + 
							"AverageDownFlow=" + AverageDownFlow +"," + 
							"TotalServiceNum=" + TotalServiceNum +"," + 
							"TotalNetDeviceNum=" + TotalNetDeviceNum +"," + 
							"TotalSwitchDeviceNum=" + TotalSwitchDeviceNum +"," + 
							"TotalNormalDeviceNum=" + TotalNormalDeviceNum +"," + 
							"TotalPrewarningDeviceNum=" + TotalPrewarningDeviceNum +"," + 
							"NormalServiceNum=" + NormalServiceNum +"," + 
							"NormalNetDeviceNum=" + NormalNetDeviceNum +"," + 
							"NormalSwitchDeviceNum=" + NormalSwitchDeviceNum +"," + 
							"PrewarningServiceNum=" + PrewarningServiceNum +"," + 
							"PrewarningNetDeviceNum=" + PrewarningNetDeviceNum +"," + 
							"PrewarningSwitchDeviceNum=" + PrewarningSwitchDeviceNum +
							"}";
	}
}
