package com.snmp.service;

import java.util.List;

import com.snmp.beans.DeviceManagemnt;

public interface DeviceManagementService {
	//添加设备
	boolean addDevice(String deviceIp,int deviceType,String deviceLoc,String deviceDesc,String deviceName);

	//ip是否存在
	boolean isExistDeviceIp(String deviceIp);
	
	//查找设备总数
	Long countDevice();
	
	//分页查找
	List<DeviceManagemnt> getDeviceByPage(int page,int row);
	
	//删除设备，这里可以选择只是在数据库中做标记或者是彻底删除数据库
	boolean deleteDevice(Integer deviceId);
	
	//更新设备信息
	boolean update(int id,String ip,int type,String name,String loc,String desc);
}
