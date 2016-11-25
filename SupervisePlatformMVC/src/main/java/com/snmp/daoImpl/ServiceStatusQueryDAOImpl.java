package com.snmp.daoImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.snmp.dao.ServiceStatusQueryDAOI;

@Repository("ServiceStatusQueryDAOImpl")
public class ServiceStatusQueryDAOImpl  extends BaseDAOImpl<String> implements ServiceStatusQueryDAOI {
	 List<Integer> CountByDateRange=new ArrayList<Integer>();//记录每个表中项目条数
	 List<Integer> CountByMultiple=new ArrayList<Integer>();
	 
	public List<String> getServiceStatusTempList(int page,int rows) {
		String hql = "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_dTemp as s,ESM_DeviceManagemnt_d as d where s.DeviceId=d.DeviceId";
		List<String> list = super.find(hql, page, rows); 
		return list;
	}
	
	public List<String> getServiceStatusList(int page,int rows) {
		String hql = "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_dTemp as s,ESM_DeviceManagemnt_d as d where s.DeviceId=d.DeviceId";	
		List<String> list = super.find(hql, page, rows);  
		return list;
	}
	
	public List<String> getServiceStatusListByIp(String deviceip,int page,int rows) {
		String hql = "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_dTemp as s,ESM_DeviceManagemnt_d as d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
		List<String> list = super.find(hql, page, rows);  
		return list;
	}
	
	public List<String> getServiceStatusListByDateRange(String date_begin,String date_end,int page,int rows) {

		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        String nowstring=format.format(now.getTime());
        try {
            start.setTime(format.parse(date_begin));
            end.setTime(format.parse(date_end));
            now.setTime(format.parse(nowstring));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sql="";
        List<String> list=new ArrayList<String>();
        List<String> list_pre=new ArrayList<String>();
        List<String> list_next=new ArrayList<String>();
		int i=0;
		int count=CountByDateRange.get(i);
		int count_pre=0;
		while(count<=(page-1)*rows){  //定位到当前位置
			count_pre=count;
			count+=CountByDateRange.get(++i);
			 start.add(Calendar.DAY_OF_MONTH,1);
		}
		if(count>=page*rows || start.equals(end)){  //只需在当前位置查询
			if(start.before(now)){
				sql= "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId ";
				list=super.findSql(sql, page, rows,rows*(page-1)-count_pre);  
			}else{  //查询当天表
				  sql = "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_dTemp  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId";
				  list=super.findSql(sql, page, rows,rows*(page-1)-count_pre);  
			}
		}else{// 需要多天拼接
			sql= "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId";
			 list_pre=super.findSql(sql, page, rows,rows*(page-1)-count_pre);  //当前表末尾剩余
			 list.addAll(list_pre);
			while(count<page*rows){
				count_pre=count;
				count+=CountByDateRange.get(++i);
				int rows_temp=rows*page-count_pre;//不能改变原来的rows
				start.add(Calendar.DAY_OF_MONTH,1);
				if(start.equals(end)){//到达最后一天
					 if(start.before(now)){
							sql= "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId";
							list_next=super.findSql(sql, page, rows_temp,0);  
							list.addAll(list_next);
						  }
						  else{
							  sql = "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_dTemp  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId";
								list_next=super.findSql(sql, page, rows_temp,0);  
								list.addAll(list_next);
						  }
					 break;
				}
				else{
					sql= "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId";
					list_next=super.findSql(sql, page, rows_temp,0);  
					list.addAll(list_next);
				}				
			}
		}
			
		return list;
	}
	
	public List<String> getServiceStatusListByMultiple(String deviceip,String date_begin,String date_end,int page,int rows) {

		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        String nowstring=format.format(now.getTime());
        try {
            start.setTime(format.parse(date_begin));
            end.setTime(format.parse(date_end));
            now.setTime(format.parse(nowstring));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String sql="";
        List<String> list=new ArrayList<String>();
        List<String> list_pre=new ArrayList<String>();
        List<String> list_next=new ArrayList<String>();
		int i=0;
		int count=CountByMultiple.get(i);
		int count_pre=0;
		while(count<=(page-1)*rows){  //定位到当前位置
			count_pre=count;
			count+=CountByMultiple.get(++i);
			 start.add(Calendar.DAY_OF_MONTH,1);
		}
		if(count>=page*rows || start.equals(end)){
			if(start.before(now)){
				sql= "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
				list=super.findSql(sql, page, rows,rows*(page-1)-count_pre);  
			}else{  //查询当天表
				  sql = "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_dTemp  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
				  list=super.findSql(sql, page, rows,rows*(page-1)-count_pre);  
			}
		}
		else{// 需要多天拼接
			sql= "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
			 list_pre=super.findSql(sql, page, rows,rows*(page-1)-count_pre);  //当前表末尾剩余
			 list.addAll(list_pre);
			while(count<page*rows){
				count_pre=count;
				count+=CountByMultiple.get(++i);
				int rows_temp=rows*page-count_pre;//不能改变原来的rows
				start.add(Calendar.DAY_OF_MONTH,1);
				if(start.equals(end)){//到达最后一天
					 if(start.before(now)){
							sql= "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
							list_next=super.findSql(sql, page, rows_temp,0);  
							list.addAll(list_next);
						  }
						  else{
							  sql = "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_dTemp  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
								list_next=super.findSql(sql, page, rows_temp,0);  
								list.addAll(list_next);
						  }
					 break;
				}
				else{
					sql= "SELECT s.ServiceStatusId,d.DeviceIp,s.ServiceStatusCPU,s.ServiceStatusAllMem,s.ServiceStatusMem,s.ServiceStatusAllStor,s.ServiceStatusStor,s.ServiceStatusUpFlowAvg,s.ServiceStatusDownFlowAvg,d.DeviceName,d.DeviceDesc,s.ServiceStatusDate FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
					list_next=super.findSql(sql, page, rows_temp,0);  
					list.addAll(list_next);
				}				
			}
		}
		
		return list;
	}
	
	
	
	
	public long getServiceStatusListCount() {
		String hql = "SELECT count(s.ServiceStatusId) FROM ESM_ServiceStatus_dTemp as s,ESM_DeviceManagemnt_d as d where s.DeviceId=d.DeviceId";	
		long count =super.count(hql);
		return count;
	}
	
	public long getServiceStatusListCountByIp(String deviceip) {
		String hql = "SELECT count(s.ServiceStatusId) FROM ESM_ServiceStatus_dTemp as s,ESM_DeviceManagemnt_d as d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
		long count =super.count(hql);
		return count;
	}

	public long getServiceStatusListCountByDateRange(String date_begin,String date_end) {
		CountByDateRange.clear();
		String sql="";
		long totalcount=0;
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        String nowstring=format.format(now.getTime());
        try {
            start.setTime(format.parse(date_begin));
            end.setTime(format.parse(date_end));
            now.setTime(format.parse(nowstring));
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while(start.before(end)&&start.before(now))//小于当前日期并小于结束日期
        {
        	sql = "SELECT count(s.ServiceStatusId) FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId";	
        	CountByDateRange.add(super.countSql(sql).intValue());
        	totalcount +=super.countSql(sql).longValue();
            start.add(Calendar.DAY_OF_MONTH,1);
        }
        if(end.equals(now)){ 
        	sql= "SELECT count(s.ServiceStatusId) FROM ESM_ServiceStatus_dTemp  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId";	
        	CountByDateRange.add(super.countSql(sql).intValue());
        	totalcount +=super.countSql(sql).longValue();
        }
        else{
        	sql = "SELECT count(s.ServiceStatusId) FROM ESM_ServiceStatus_d"+format.format(end.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId";	
        	CountByDateRange.add(super.countSql(sql).intValue());
        	totalcount +=super.countSql(sql).longValue();
        }		
		return totalcount;
	}

	public long getServiceStatusListCountByMultiple(String deviceip,String date_begin,String date_end) {
	CountByMultiple.clear();
	String sql="";
	long totalcount=0;
	SimpleDateFormat format=new SimpleDateFormat("yyyyMMdd");
    Calendar start = Calendar.getInstance();
    Calendar end = Calendar.getInstance();
    Calendar now = Calendar.getInstance();
    String nowstring=format.format(now.getTime());
    try {
        start.setTime(format.parse(date_begin));
        end.setTime(format.parse(date_end));
        now.setTime(format.parse(nowstring));
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    while(start.before(end)&&start.before(now))//小于当前日期并小于结束日期
    {
    	sql = "SELECT count(s.ServiceStatusId) FROM ESM_ServiceStatus_d"+format.format(start.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";
    	CountByMultiple.add(super.countSql(sql).intValue());
    	totalcount +=super.countSql(sql).longValue();
        start.add(Calendar.DAY_OF_MONTH,1);
    }
    if(end.equals(now)){ 
    	sql= "SELECT count(s.ServiceStatusId) FROM ESM_ServiceStatus_dTemp  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";	
    	CountByMultiple.add(super.countSql(sql).intValue());
    	totalcount +=super.countSql(sql).longValue();
    }
    else{
    	sql = "SELECT count(s.ServiceStatusId) FROM ESM_ServiceStatus_d"+format.format(end.getTime())+"  s,ESM_DeviceManagemnt_d  d where s.DeviceId=d.DeviceId and d.DeviceIp='"+deviceip+"'";
    	CountByMultiple.add(super.countSql(sql).intValue());
    	totalcount +=super.countSql(sql).longValue();
    }		
	return totalcount;
}
}
