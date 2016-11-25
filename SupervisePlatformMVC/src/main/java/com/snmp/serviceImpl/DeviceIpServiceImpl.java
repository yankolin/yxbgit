package com.snmp.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.DeviceManagemnt;
import com.snmp.dao.DeviceIpDAOI;
import com.snmp.service.DeviceIpServiceI;

@Service("deviceManagemntService")
public class DeviceIpServiceImpl implements DeviceIpServiceI {
	
	@Resource
	private DeviceIpDAOI  deviceIpDao;
	
	@Transactional
	public List<DeviceManagemnt> getDeviceIpInfo(){
		
		return deviceIpDao.getDeviceIpInfoDAO();
	}
}
