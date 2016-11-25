package com.snmp.serviceImpl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.NetDeviceEnclosureStatus;
import com.snmp.beans.ServiceStatus;
import com.snmp.daoImpl.TopoDAOImpl;
import com.snmp.service.TopoService;

@Service("topoImplService")
public class TopoImplService implements TopoService{
	
	@Resource
	private TopoDAOImpl topoDAO;

	public TopoDAOImpl getTopoDAO() {
		return topoDAO;
	}

	public void setTopoDAO(TopoDAOImpl topoDAO) {
		this.topoDAO = topoDAO;
	}

	@Transactional
	public List<ServiceStatus> getService(String deviceLoc) {
		return topoDAO.getServerInfoByLoc(deviceLoc);
	}

	@Transactional
	public List<NetDeviceEnclosureStatus> getMemoInfo(String imgID) {
		return null;
	}
	
}
