package com.snmp.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.snmp.beans.NetDeviceGlobalStatus;
import com.snmp.dao.NetDeviceGlobalStatusDAOI;
@Repository
public class NetDeviceGlobalStatusDAOImpl extends BaseDAOImpl<NetDeviceGlobalStatus> implements NetDeviceGlobalStatusDAOI {
	public List<NetDeviceGlobalStatus> getNetDeviceGlobalStatusInfoDAO(String ip,String time1,String time2,String tName){
		
		String[]  data=tName.split("-");
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < data.length; i++){
		 sb. append(data[i]);
		}
		String realName = sb.toString();//2016-04-20转换20160420
		
		String hql = " select   TotalDriveNum,OfflineDriveNum,TotalMdiskNum,"+
	"OfflineMdiskNum,TotalVdiskNum,OfflineVdiskNum,"+
	"TotalHostNum,OfflineHostNum ,SystemTotalCapacity,SystemTotalFreeSpace,NetDeviceGlobalStatusDate from ESM_NetDeviceGlobalStatus_d"+realName+"  where NetDeviceIp ='"+ip+"' and NetDeviceGlobalStatusDate between '"+time1+"'  and '"+time2+"'  order by NetDeviceGlobalId DESC" ;
		List<NetDeviceGlobalStatus> list = super.findSql(hql);
		return list;
	}
}
