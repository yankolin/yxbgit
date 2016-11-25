package com.snmp.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.GlobalStatus;
import com.snmp.dao.MainDAOI;
import com.snmp.service.MainServiceI;

@Service("globalStatusService")
public class MainServiceImpl implements MainServiceI {
	
	@Resource
	private MainDAOI  mainDao;
	
	@Transactional
	public List<GlobalStatus> getMainInfo(){
		
		return mainDao.getMainInfoDAO();
	}
}
