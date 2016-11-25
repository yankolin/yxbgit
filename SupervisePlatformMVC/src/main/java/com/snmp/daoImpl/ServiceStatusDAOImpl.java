package com.snmp.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.snmp.beans.DeviceManagemnt;
import com.snmp.beans.ServiceStatus;
import com.snmp.dao.ServiceStatusDAOI;


@Repository
public class ServiceStatusDAOImpl  extends BaseDAOImpl<ServiceStatus> implements ServiceStatusDAOI{
	public List<ServiceStatus> getServiceStatusInfoDAO(String ip,String time1,String time2,String tName){
	
		String[]  data=tName.split("-");
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < data.length; i++){
		 sb. append(data[i]);
		}
		String realName = sb.toString();
		
		String hql = " select   s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,"+
	"s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,"+
	"s.ServiceStatusDownFlowAvg,s.ServiceStatusDate from ESM_ServiceStatus_d"+realName+" s,ESM_DeviceManagemnt_d d  where d.DeviceId= s.DeviceId and d.DeviceIp ='"+ip+"' and ServiceStatusDate between '"+time1+"'  and '"+time2+"'  order by ServiceStatusId DESC" ;
		List<ServiceStatus> list = super.findSql(hql);
		return list;
	}
	/*public List<DeviceManagemnt> findIp(){
		String hql = " select  deviceIp from ESM_DeviceManagemnt_d order by deviceId limit 1";
					List<DeviceManagemnt> list = super.findSql(hql);
					return list;
	}*/
	
	
	
}

