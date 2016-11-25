package com.snmp.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.NetDeviceGlobalStatus;
import com.snmp.dao.NetDeviceGlobalStatusDAOI;
import com.snmp.service.NetDeviceGlobalStatusServiceI;

@Service("NetDeviceStatusService")
public class NetDeviceGlobalStatusServiceImpl  implements NetDeviceGlobalStatusServiceI {
	
	@Resource
	private NetDeviceGlobalStatusDAOI  netdeviceglobalstatusDao;
	
	
	@Transactional
	public List<NetDeviceGlobalStatus> getNetDeviceGlobalStatusInfo(String ip,String time1,String time2,String tName){
		
		return netdeviceglobalstatusDao.getNetDeviceGlobalStatusInfoDAO(ip,time1,time2,tName);
	}

	
}
