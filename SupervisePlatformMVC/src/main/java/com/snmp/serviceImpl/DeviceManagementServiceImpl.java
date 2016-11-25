package com.snmp.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.DeviceManagemnt;
import com.snmp.dao.BaseDAOI;
import com.snmp.dao.DeviceManageDAOI;
import com.snmp.service.DeviceManagementService;

@Service("deviceManageService")
public class DeviceManagementServiceImpl implements DeviceManagementService {

	@Resource
	private DeviceManageDAOI deviceManageDAO;

	public DeviceManageDAOI getDeviceManageDAO() {
		return deviceManageDAO;
	}

	public void setDeviceManageDAO(DeviceManageDAOI deviceManageDAO) {
		this.deviceManageDAO = deviceManageDAO;
	}

	@Transactional
	public boolean addDevice(String deviceIp, int deviceType, String deviceLoc, String deviceDesc, String deviceName) {
		DeviceManagemnt device = new DeviceManagemnt();

		device.setDeviceIp(deviceIp);
		device.setDeviceType(deviceType);
		device.setDeviceDesc(deviceDesc);
		device.setDeviceName(deviceName);
		device.setDeviceDate(new Date());
		device.setDeviceLoc(deviceLoc);

		deviceManageDAO.saveOrUpdate(device);
		return true;
	}

	@Transactional
	public boolean isExistDeviceIp(String deviceIp) {
		return deviceManageDAO.findDeiveByIp(deviceIp);
	}

	@Transactional
	public Long countDevice() {
		
		return deviceManageDAO.getCountDeviceDao();
	}

	@Transactional
	public List<DeviceManagemnt> getDeviceByPage(int page, int row) {

		List<DeviceManagemnt> list = deviceManageDAO.getDeviceListDao(page, row);
		return list;
	}

	@Transactional
	public boolean deleteDevice(Integer deviceId) {
		System.out.println("service 删除设备");
		return deviceManageDAO.deleteDeviceByID(deviceId);
	}

	@Transactional
	public boolean update(int id, String ip, int type, String name, String loc, String desc) {

		deviceManageDAO.updateDeviceMessage(id, ip, type, name, loc, desc);

		return true;
	}
}
