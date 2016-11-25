package com.snmp.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="ESM_ServiceStatus_dTemp")
public class ServiceStatus  implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="ServiceStatusId")
	private Integer ServiceStatusId;
	
	@Column(name="DeviceId")
	private Integer DeviceId;
	
	@Column(name="ServiceStatusCPU")
	private Integer ServiceStatusCPU;
	
	@Column(name="ServiceStatusAllMem")
	private Long ServiceStatusAllMem;
	
	@Column(name="ServiceStatusMem")
	private Long ServiceStatusMem;
	
	@Column(name="ServiceStatusStor")
	private Long ServiceStatusStor;
	
	@Column(name="ServiceStatusUpFlow")
	private Long ServiceStatusUpFlow;
	
	
 @Column(name="ServiceStatusUpFlowAvg")
 private Long ServiceStatusUpFlowAvg;
 
	@Column(name="ServiceStatusDownFlow")
	private Long ServiceStatusDownFlow;
	
	
	@Column(name="ServiceStatusDownFlowAvg")
  private Long ServiceStatusDownFlowAvg;
	
	public Long getServiceStatusUpFlowAvg() {
        return ServiceStatusUpFlowAvg;
    }

    public void setServiceStatusUpFlowAvg(Long serviceStatusUpFlowAvg) {
        ServiceStatusUpFlowAvg = serviceStatusUpFlowAvg;
    }

    public Long getServiceStatusDownFlowAvg() {
        return ServiceStatusDownFlowAvg;
    }

    public void setServiceStatusDownFlowAvg(Long serviceStatusDownFlowAvg) {
        ServiceStatusDownFlowAvg = serviceStatusDownFlowAvg;
    }

    @Column(name="ServiceStatusDate")
	private Date ServiceStatusDate;
	
	@Column(name="ServiceStatusAllStor")
	private Long ServiceStatusAllStor;

	public Integer getServiceStatusId() {
		return ServiceStatusId;
	}

	public void setServiceStatusId(Integer serviceStatusId) {
		ServiceStatusId = serviceStatusId;
	}

	public Integer getDeviceId() {
		return DeviceId;
	}

	public void setDeviceId(Integer deviceId) {
		DeviceId = deviceId;
	}

	public Integer getServiceStatusCPU() {
		return ServiceStatusCPU;
	}

	public void setServiceStatusCPU(Integer serviceStatusCPU) {
		ServiceStatusCPU = serviceStatusCPU;
	}

	public Long getServiceStatusAllMem() {
		return ServiceStatusAllMem;
	}

	public void setServiceStatusAllMem(Long serviceStatusAllMem) {
		ServiceStatusAllMem = serviceStatusAllMem;
	}

	public Long getServiceStatusMem() {
		return ServiceStatusMem;
	}

	public void setServiceStatusMem(Long serviceStatusMem) {
		ServiceStatusMem = serviceStatusMem;
	}

	public Long getServiceStatusStor() {
		return ServiceStatusStor;
	}

	public void setServiceStatusStor(Long serviceStatusStor) {
		ServiceStatusStor = serviceStatusStor;
	}

	public Long getServiceStatusUpFlow() {
		return ServiceStatusUpFlow;
	}

	public void setServiceStatusUpFlow(Long serviceStatusUpFlow) {
		ServiceStatusUpFlow = serviceStatusUpFlow;
	}

	public Long getServiceStatusDownFlow() {
		return ServiceStatusDownFlow;
	}

	public void setServiceStatusDownFlow(Long serviceStatusDownFlow) {
		ServiceStatusDownFlow = serviceStatusDownFlow;
	}

	public Date getServiceStatusDate() {
		return ServiceStatusDate;
	}

	public void setServiceStatusDate(Date serviceStatusDate) {
		ServiceStatusDate = serviceStatusDate;
	}

	public Long getServiceStatusAllStor() {
		return ServiceStatusAllStor;
	}

	public void setServiceStatusAllStor(Long serviceStatusAllStor) {
		ServiceStatusAllStor = serviceStatusAllStor;
	}

	public String toString() {
		return "ServiceStatus{" +
							"ServiceStatusId=" +ServiceStatusId +"," + 
							"DeviceId=" +DeviceId +"," + 
							"ServiceStatusCPU=" +ServiceStatusCPU +"," + 
							"ServiceStatusAllMem=" +ServiceStatusAllMem +"," + 
							"ServiceStatusMem=" +ServiceStatusMem +"," + 
							"ServiceStatusAllStor=" +ServiceStatusAllStor +"," + 
							"ServiceStatusStor=" +ServiceStatusStor +"," + 
							"ServiceStatusUpFlow=" +ServiceStatusUpFlow +"," + 
							"ServiceStatusDownFlow=" +ServiceStatusDownFlow +"," + 
							"ServiceStatusDate = '" + ServiceStatusDate.toString() + '\'' + 
							"}";
	}
}
