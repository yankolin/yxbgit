package com.snmp.dao;

import java.util.List;

import com.snmp.beans.NetDeviceGlobalStatus;

public interface NetDeviceGlobalStatusDAOI {
	List<NetDeviceGlobalStatus> getNetDeviceGlobalStatusInfoDAO(String ip,String time1,String time2,String tName);
}
