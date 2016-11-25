package com.snmp.service;

import java.util.List;

import com.snmp.beans.NetDeviceGlobalStatus;

public interface NetDeviceGlobalStatusServiceI {
	List<NetDeviceGlobalStatus> getNetDeviceGlobalStatusInfo(String ip,String time1,String time2,String tName);
}
