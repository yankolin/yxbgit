package com.snmp.service;
import java.util.List;


import com.snmp.beans.ServiceStatus;

public interface ServiceStatusServiceI {
	List<ServiceStatus> getServiceStatusInfo(String ip,String time1,String time2,String tName);
}
