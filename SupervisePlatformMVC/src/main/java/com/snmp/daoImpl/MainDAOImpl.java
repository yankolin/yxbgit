package com.snmp.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.snmp.beans.GlobalStatus;
import com.snmp.dao.MainDAOI;

@Repository
public class MainDAOImpl extends BaseDAOImpl<GlobalStatus> implements MainDAOI  {

	public List<GlobalStatus> getMainInfoDAO(){
		String hql = " select  AverageCPURate,AverageMemoryRate,AverageStorRate,"+
	"AverageUpFlow,AverageDownFlow,TotalServiceNum,TotalNetDeviceNum,"+
	"TotalSwitchDeviceNum,TotalNormalDeviceNum,TotalPrewarningDeviceNum,"+
	"NormalServiceNum,NormalNetDeviceNum,NormalSwitchDeviceNum,"+
	"PrewarningServiceNum,PrewarningNetDeviceNum,PrewarningSwitchDeviceNum from ESM_GlobalStatus_d where GlobalId=1" ;
		List<GlobalStatus> list = super.find(hql);
		return list;
	}
	
}
