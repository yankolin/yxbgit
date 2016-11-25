package com.snmp.service;

import java.util.List;

import com.snmp.beans.NetDeviceEnclosureStatus;
import com.snmp.beans.ServiceStatus;

public interface TopoService {
	
	//根据设备位置信息，获取设备当前状态
	List<ServiceStatus> getService(String imgID);
	
	//根据设备位置信息，获取设备当前状态
	List<NetDeviceEnclosureStatus> getMemoInfo(String imgID);
}
