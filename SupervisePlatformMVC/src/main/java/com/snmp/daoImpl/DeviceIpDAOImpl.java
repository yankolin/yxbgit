package com.snmp.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.snmp.beans.DeviceManagemnt;
import com.snmp.dao.DeviceIpDAOI;

@Repository
public class DeviceIpDAOImpl extends BaseDAOImpl<DeviceManagemnt> implements DeviceIpDAOI  {

	public List<DeviceManagemnt> getDeviceIpInfoDAO(){
		String hql = " select  DeviceIp from ESM_DeviceManagemnt_d order by DeviceId limit 1";
		List<DeviceManagemnt> list = super.findSql(hql);
		return list;
	}
	
}
