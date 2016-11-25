package com.snmp.dao;

import java.util.List;

public interface ServiceStatusQueryDAOI {

	List<String> getServiceStatusTempList(int page,int rows);
	List<String> getServiceStatusListByIp(String ip,int page,int rows);
	public List<String> getServiceStatusList(int page,int rows);
	public long getServiceStatusListCount();
	public long getServiceStatusListCountByIp(String deviceip);
	public long getServiceStatusListCountByDateRange(String date_begin,String date_end);
	public long getServiceStatusListCountByMultiple(String deviceip,String date_begin,String date_end);
	public List<String> getServiceStatusListByMultiple(String deviceip,String date_begin,String date_end,int page,int rows);
}
