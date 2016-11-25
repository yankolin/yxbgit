package com.snmp.dao;
import java.util.List;

public interface SeekMemStatusDAOI {
	public List<String> getDefaultIp() ;
	public long getMemStatusListCount(String deviceip);
	public List<String> getMemStatusList(String deviceip,int page,int rows);
	public long getDrivePastListCount(String deviceip,String date);
	public long getMemMdiskTempListCount(String deviceip) ;
	public List<String> getMemMdiskTempStatusList(String deviceip,int page,int rows);
	public long getMdiskPastListCount(String deviceip,String date) ;
	public long getMemVdiskTempListCount(String deviceip);
	public List<String> getMemVdiskTempStatusList(String deviceip,int page,int rows) ;
	public long getVdiskPastListCount(String deviceip,String date);
	public List<String> getMemVdiskPastStatusList(String deviceip,String date,int page,int rows);
	public long getMemHostTempListCount(String deviceip) ;
	public List<String> getMemHostTempStatusList(String deviceip,int page,int rows) ;
	public long getHostPastListCount(String deviceip,String date) ;
	public List<String> getMemHostPastStatusList(String deviceip,String date,int page,int rows);
	public long getMemEnclosureTempListCount(String deviceip);
	public List<String> getMemEnclosureTempStatusList(String deviceip,int page,int rows) ;
	public long getEnclosurePastListCount(String deviceip,String date);
	public List<String> getMemEnclosurePastStatusList(String deviceip,String date,int page,int rows);
	public long getMemSystemInfoTempListCount(String deviceip);
	public List<String> getMemSystemInfoTempStatusList(String deviceip,int page,int rows) ;
}
