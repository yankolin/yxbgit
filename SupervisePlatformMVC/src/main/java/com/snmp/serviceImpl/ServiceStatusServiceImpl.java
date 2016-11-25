package com.snmp.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.ServiceStatus;
import com.snmp.dao.ServiceStatusDAOI;
import com.snmp.service.ServiceStatusServiceI;

@Service("servicelStatusService")
public class ServiceStatusServiceImpl implements ServiceStatusServiceI {
	
	@Resource
	private ServiceStatusDAOI  servicestatusDao;
	
	@Transactional
	public List<ServiceStatus> getServiceStatusInfo(String ip,String time1,String time2,String tName){
		
		return servicestatusDao.getServiceStatusInfoDAO(ip,time1,time2,tName);
	}
}
