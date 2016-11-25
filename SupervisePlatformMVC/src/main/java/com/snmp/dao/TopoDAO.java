package com.snmp.dao;

import java.util.List;

import com.snmp.beans.NetDeviceEnclosureStatus;
import com.snmp.beans.ServiceStatus;

public interface TopoDAO extends BaseDAOI<ServiceStatus>{
	//通过位置信息获取服务器当前状态
	List<ServiceStatus> getServerInfoByLoc(String deviceLoc);
	
	//通过位置信息获取存储设备的当前状态
	List<NetDeviceEnclosureStatus> getMemoInfoByLoc(String deviceLoc);
	
	//通过某些信息获取交换机当前状态
}
