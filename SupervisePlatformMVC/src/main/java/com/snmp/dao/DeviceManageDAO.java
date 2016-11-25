package com.snmp.dao;

import com.snmp.beans.DeviceManagemnt;

public interface DeviceManageDAO extends BaseDAOI<DeviceManagemnt>{
	//根据IP查找设备
	boolean findDeiveByIp(String ipAddress);
	
	//根据设备Id删除设备
	boolean deleteDeviceByID(Integer deviceId);
	
	//更新设备信息
	boolean updateDeviceMessage(int id, String ip, int type, String name, String loc, String desc);
	
}
