package com.snmp.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.snmp.dao.SeekMemStatusDAOI;

@Repository("seekmemstatusdaoimpl")
public class SeekMemStatusDAOImpl extends BaseDAOImpl<String> implements SeekMemStatusDAOI  {
	
	public List<String> getDefaultIp() {
		String hql="SELECT SystemIp,NetDeviceId FROM ESM_NetDeviceSystemInformation_d";
		List<String> list = super.find(hql, 1, 1);  
		return list;
	}
	
	
	public long getMemStatusListCount(String deviceip) {
		String hql="SELECT count(dds.DriveId) "+
				 "FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceDriveInformation_d as ddi,ESM_NetDeviceDriveStatus_dTemp as dds "+
				 "where dm.DeviceIp='" + deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=ddi.NetDeviceId and ddi.DriveId=dds.DriveId";
		long count =super.count(hql);
		return count;
	}
	
	public long getDrivePastListCount(String deviceip,String date) {
		String sql="SELECT count(dds.DriveId) "+
				 "FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceDriveInformation_d as ddi,ESM_NetDeviceDriveStatus_d"+date+ " as dds "+
				 "where dm.DeviceIp='" + deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=ddi.NetDeviceId and ddi.DriveId=dds.DriveId ";
		long count =super.countSql(sql).longValue();
		return count;
	}
	
	public List<String> getMemDrivePastStatusList(String deviceip,String date,int page,int rows) {
		String sql="SELECT ddi.DriveId,ddi.DriveCapacity,dds.DriveStatus,ddi.MdiskId,ddi.EnclosureId,ddi.SlotId,dds.DriveStatusDate,dm.DeviceLoc "+
 "FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceDriveInformation_d as ddi,ESM_NetDeviceDriveStatus_d"+date+"  as dds "+
"where dm.DeviceIp='" + deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=ddi.NetDeviceId and ddi.DriveId=dds.DriveId "; 
		List<String> list = super.findSql(sql, page, rows,(page-1)*rows);  
		return list;
	}
	
	public List<String> getMemStatusList(String deviceip,int page,int rows) {
		String hql="SELECT ddi.DriveId,ddi.DriveCapacity,dds.DriveStatus,ddi.MdiskId,ddi.EnclosureId,ddi.SlotId,dds.DriveStatusDate,dm.DeviceLoc "+
 "FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceDriveInformation_d as ddi,ESM_NetDeviceDriveStatus_dTemp as dds "+
"where dm.DeviceIp='" + deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=ddi.NetDeviceId and ddi.DriveId=dds.DriveId"; 
		List<String> list = super.find(hql, page, rows);  
		return list;
	}
	
	
	public long getMemMdiskTempListCount(String deviceip) {
		String hql="SELECT count(dms.MdiskId)"+
 " FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceMdiskInformation_d as dmi,ESM_NetDeviceMdiskStatus_dTemp as dms"+
" where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dmi.NetDeviceId and dmi.MdiskId=dms.MdiskId";
		long count =super.count(hql);
		return count;
	}
	
	public List<String> getMemMdiskTempStatusList(String deviceip,int page,int rows) {
		String hql="SELECT dmi.MdiskId,dmi.MdiskCapacity,dms.MdiskStatus,dmi.PoolName,dms.MdiskStatusDate,dm.DeviceLoc"+
 " FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceMdiskInformation_d as dmi,ESM_NetDeviceMdiskStatus_dTemp as dms"+
" where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dmi.NetDeviceId and dmi.MdiskId=dms.MdiskId"; 
		List<String> list = super.find(hql, page, rows);  
		return list;
	}
	
	public long getMdiskPastListCount(String deviceip,String date) {
		String sql="SELECT count(dms.MdiskId)"+
				 " FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceMdiskInformation_d as dmi,ESM_NetDeviceMdiskStatus_d"+date+ "  as dms"+
				 " where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dmi.NetDeviceId and dmi.MdiskId=dms.MdiskId";
		long count =super.countSql(sql).longValue();
		return count;
	}
	
	public List<String> getMemMdiskPastStatusList(String deviceip,String date,int page,int rows) {
		String sql="SELECT dmi.MdiskId,dmi.MdiskCapacity,dms.MdiskStatus,dmi.PoolName,dms.MdiskStatusDate,dm.DeviceLoc"+
				"  FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceMdiskInformation_d as dmi,ESM_NetDeviceMdiskStatus_d"+date+ "  as dms"+
				 " where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dmi.NetDeviceId and dmi.MdiskId=dms.MdiskId";
		List<String> list = super.findSql(sql, page, rows,(page-1)*rows);  
		return list;
	}

	public long getMemVdiskTempListCount(String deviceip) {
		String hql="SELECT count(dvi.VdiskName) "+
				" FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceVdiskInformation_d as dvi,ESM_NetDeviceVdiskStatus_dTemp as dvs "+
				"  where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dvi.NetDeviceId and dvi.VdiskName=dvs.VdiskName ";
		long count =super.count(hql);
		return count;
	}
	
	public List<String> getMemVdiskTempStatusList(String deviceip,int page,int rows) {
		String hql="SELECT dvi.VdiskName,dvi.VdiskCapacity,dvs.VdiskStatus,dvs.VdiskDate,dm.DeviceLoc "+
				" FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceVdiskInformation_d as dvi,ESM_NetDeviceVdiskStatus_dTemp as dvs "+
				"  where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dvi.NetDeviceId and dvi.VdiskName=dvs.VdiskName";
		List<String> list = super.find(hql, page, rows);  
		return list;
	}

	public long getVdiskPastListCount(String deviceip,String date) {
		String sql="SELECT count(dvi.VdiskName) "+
				" FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceVdiskInformation_d as dvi,ESM_NetDeviceVdiskStatus_d"+date+"  as dvs "+
				"  where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dvi.NetDeviceId and dvi.VdiskName=dvs.VdiskName";
		long count =super.countSql(sql).longValue();
		return count;
	}

	public List<String> getMemVdiskPastStatusList(String deviceip,String date,int page,int rows) {
		String sql="SELECT dvi.VdiskName,dvi.VdiskCapacity,dvs.VdiskStatus,dvs.VdiskDate,dm.DeviceLoc "+
				" FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceVdiskInformation_d as dvi,ESM_NetDeviceVdiskStatus_d"+date+"  as dvs "+
				"  where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dvi.NetDeviceId and dvi.VdiskName=dvs.VdiskName";
		List<String> list = super.findSql(sql, page, rows,(page-1)*rows);  
		return list;
	}
	
	public long getMemHostTempListCount(String deviceip) {
		String hql="SELECT count(dhi.HostName) "+
 " FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceHostInformation_d as dhi,ESM_NetDeviceHostStatus_dTemp as dhs "+
" where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dhi.NetDeviceId and dhi.HostName=dhs.HostName";
		long count =super.count(hql);
		return count;
	}
	
	public List<String> getMemHostTempStatusList(String deviceip,int page,int rows) {
		String hql="SELECT dhi.HostName,dhs.HostStatus,dhi.HostPortCount,dhs.HostStatusDate,dm.DeviceLoc "+
				 " FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceHostInformation_d as dhi,ESM_NetDeviceHostStatus_dTemp as dhs "+
				 " where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dhi.NetDeviceId and dhi.HostName=dhs.HostName";
		List<String> list = super.find(hql, page, rows);  
		return list;
	}
	
	
	public long getHostPastListCount(String deviceip,String date) {
		String sql="SELECT count(dhi.HostName) "+
				" FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceHostInformation_d as dhi,ESM_NetDeviceHostStatus_d"+date+"  as dhs "+
				 " where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dhi.NetDeviceId and dhi.HostName=dhs.HostName";
		long count =super.countSql(sql).longValue();
		return count;
	}
	
	public List<String> getMemHostPastStatusList(String deviceip,String date,int page,int rows) {
		String sql="SELECT dhi.HostName,dhs.HostStatus,dhi.HostPortCount,dhs.HostStatusDate,dm.DeviceLoc "+
				" FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceHostInformation_d as dhi,ESM_NetDeviceHostStatus_d"+date+"  as dhs "+
				 " where dm.DeviceIp='"+deviceip +"' and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dhi.NetDeviceId and dhi.HostName=dhs.HostName";
		List<String> list = super.findSql(sql, page, rows,(page-1)*rows);  
		return list;
	}
	

	
	public long getMemEnclosureTempListCount(String deviceip) {
		String hql="SELECT count(dei.EnclosureSerialNumber) "+
				"  FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceEnclosureInformation_d as dei, ESM_NetDeviceEnclosureStatus_dTemp as des"+
				 "  where dm.DeviceIp='"+deviceip +"'  and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dei.NetDeviceId and dei.EnclosureId=des.EnclosureId ";
		long count =super.count(hql);
		return count;
	}
	
	public List<String> getMemEnclosureTempStatusList(String deviceip,int page,int rows) {
		String hql="SELECT dei.EnclosureSerialNumber,des.EnclosureStatus,dei.EnclosureType,dei.Managed,dei.IoGroupId,des.EnclosureStatusDate,dm.DeviceLoc "+
				"  FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceEnclosureInformation_d as dei, ESM_NetDeviceEnclosureStatus_dTemp as des"+
				 "  where dm.DeviceIp='"+deviceip +"'  and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dei.NetDeviceId and dei.EnclosureId=des.EnclosureId";
		List<String> list = super.find(hql, page, rows);  
		return list;
	}
	

	public long getEnclosurePastListCount(String deviceip,String date) {
		String sql="SELECT count(dei.EnclosureSerialNumber) "+
				"  FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceEnclosureInformation_d as dei, ESM_NetDeviceEnclosureStatus_d"+date+"  as des"+
				 "  where dm.DeviceIp='"+deviceip +"'  and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dei.NetDeviceId and dei.EnclosureId=des.EnclosureId";
		long count =super.countSql(sql).longValue();
		return count;
	}
	
	public List<String> getMemEnclosurePastStatusList(String deviceip,String date,int page,int rows) {
		String sql="SELECT dei.EnclosureSerialNumber,des.EnclosureStatus,dei.EnclosureType,dei.Managed,dei.IoGroupId,des.EnclosureStatusDate,dm.DeviceLoc "+
				"  FROM ESM_DeviceManagemnt_d as dm,ESM_NetDeviceSystemInformation_d as dsi,ESM_NetDeviceEnclosureInformation_d as dei, ESM_NetDeviceEnclosureStatus_d"+date+"  as des"+
				 "  where dm.DeviceIp='"+deviceip +"'  and dm.DeviceIp=dsi.SystemIp and dsi.NetDeviceId=dei.NetDeviceId and dei.EnclosureId=des.EnclosureId";
		List<String> list = super.findSql(sql, page, rows,(page-1)*rows);  
		return list;
	}
	
	public long getMemSystemInfoTempListCount(String deviceip) {
		String hql="SELECT count(dsi.DeviceName)  "+
				" FROM ESM_NetDeviceSystemInformation_d as dsi,ESM_DeviceManagemnt_d as dm "+
				"where dm.DeviceIp='"+deviceip +"'   and dm.DeviceIp=dsi.SystemIp";
		long count =super.count(hql);
		return count;
	}
	
	public List<String> getMemSystemInfoTempStatusList(String deviceip,int page,int rows) {
		String hql="SELECT dsi.DeviceName,dsi.SystemTotalCapacity,dsi.SystemTotalFreeSpace,dsi.SystemIp,dsi.SystemInfoDate,dm.DeviceLoc  "+
				" FROM ESM_NetDeviceSystemInformation_d as dsi,ESM_DeviceManagemnt_d as dm "+
				"where dm.DeviceIp='"+deviceip +"'   and dm.DeviceIp=dsi.SystemIp";
		List<String> list = super.find(hql, page, rows);  
		return list;
	}
	
}
