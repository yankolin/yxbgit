package com.snmp.dao;

import java.util.List;

import com.snmp.beans.ServiceStatus;

public interface ServiceStatusDAOI {
	
	List<ServiceStatus> getServiceStatusInfoDAO(String ip,String time1,String time2,String tName);
}
