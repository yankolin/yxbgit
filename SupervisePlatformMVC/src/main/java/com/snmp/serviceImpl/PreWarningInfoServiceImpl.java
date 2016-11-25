
package com.snmp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.PrewarningInformation;

import com.snmp.dao.BaseDAOI;
import com.snmp.daoImpl.BaseDAOImpl;
import com.snmp.service.PrewarningInfoServiceI;


@Service("PrewarningInformation")
public class PreWarningInfoServiceImpl implements PrewarningInfoServiceI {

	@Resource(name="BaseDAOI")
	private BaseDAOImpl<String> baseDao;

	
	//@Transactional
	/*public void (Integer id, Integer did,Integer cpu,long memo,long stor,long up,long down,Date date) {
		PrewarningInformation pinfo = new PrewarningInformation();
		
		//String pwds = CreateMD5.getMd5(CreateMD5.getMd5(pwd));
		pinfo.setPrewarningInfoId(id);
		pinfo.setDeviceId(did);
		pinfo.setPrewarningInfoCPU(cpu);
		pinfo.setPrewarningInfoMem(memo);
		pinfo.setPrewarningInfoStor(stor);
		pinfo.setPrewarningInfoUpFlow(up);
		pinfo.setPrewarningInfoDownFlow(down);
		pinfo.setPrewarningInfoDate(new Date());
		baseDao.saveOrUpdate(new String());
		//return pinfo;
	}*/
	
	
	
	
	@Transactional
	public List<String> getPrewarningInfoList(int page,int rows) {
		
		String hql = "select p.PrewarningInfoId,p.DeviceId,p.PrewarningInfoCPU,p.PrewarningInfoMem,p.PrewarningInfoStor,p.PrewarningInfoUpFlow,p.PrewarningInfoDownFlow,p.PrewarningInfoDate,d.DeviceIp,d.DeviceName,d.DeviceType,d.DeviceLoc,d.DeviceDesc,d.DeviceDate from ESM_PrewarningInformation_d p , ESM_DeviceManagemnt_d d where p.DeviceId=d.DeviceId order by p.PrewarningInfoDate DESC ";
		List<String> list = baseDao.findSql(hql, page, rows);
		return list;
	}
	@Transactional
	public long getPrewarningInfoListCount() {
		String hql = "select count(PrewarningInfoId) from ESM_PrewarningInformation_d";
		long count = baseDao.count(hql);
		return count;
	}
	@Transactional
	public List<String> getPrewarningInfoList(int page,int rows,String ip,String date) {
		
		String hql = "select p.PrewarningInfoId,p.DeviceId,p.PrewarningInfoCPU,p.PrewarningInfoMem,p.PrewarningInfoStor,p.PrewarningInfoUpFlow,p.PrewarningInfoDownFlow,p.PrewarningInfoDate,d.DeviceIp,d.DeviceName,d.DeviceType,d.DeviceLoc,d.DeviceDesc,d.DeviceDate from ESM_PrewarningInformation_d p , ESM_DeviceManagemnt_d d where p.DeviceId=d.DeviceId and d.DeviceIp='"+ip+"' and DATE_FORMAT(PrewarningInfoDate,'%Y%m%d')='"+date+"' order by p.PrewarningInfoDate DESC ";
		List<String> list = baseDao.findSql(hql, page, rows);
		return list;
	}
	@Transactional
	public long getPrewarningInfoListCount(String ip,String date) {
		String hql = "select count(p.PrewarningInfoId) from ESM_PrewarningInformation_d p , ESM_DeviceManagemnt_d d where p.DeviceId=d.DeviceId and d.DeviceIp='"+ip+"' and DATE_FORMAT(p.PrewarningInfoDate,'%Y%m%d')='"+date+"'";
		long count = baseDao.count(hql);
		return count;
	}
	@Transactional
	public List<String> getPrewarningInfoList_ip(int page,int rows,String ip) {
		
		String hql = "select p.PrewarningInfoId,p.DeviceId,p.PrewarningInfoCPU,p.PrewarningInfoMem,p.PrewarningInfoStor,p.PrewarningInfoUpFlow,p.PrewarningInfoDownFlow,p.PrewarningInfoDate,d.DeviceIp,d.DeviceName,d.DeviceType,d.DeviceLoc,d.DeviceDesc,d.DeviceDate from ESM_PrewarningInformation_d p , ESM_DeviceManagemnt_d d where p.DeviceId=d.DeviceId and d.DeviceIp='"+ip+"'  order by p.PrewarningInfoDate DESC ";
		List<String> list = baseDao.findSql(hql, page, rows);
		return list;
	}
	@Transactional
	public long getPrewarningInfoListCount_ip(String ip) {
		String hql = "select count(p.PrewarningInfoId) from ESM_PrewarningInformation_d p , ESM_DeviceManagemnt_d d where p.DeviceId=d.DeviceId and d.DeviceIp='"+ip+"'";
		long count = baseDao.count(hql);
		return count;
	}
	@Transactional
	public List<String> getPrewarningInfoList_date(int page,int rows,String date) {
		
		String hql = "select p.PrewarningInfoId,p.DeviceId,p.PrewarningInfoCPU,p.PrewarningInfoMem,p.PrewarningInfoStor,p.PrewarningInfoUpFlow,p.PrewarningInfoDownFlow,p.PrewarningInfoDate,d.DeviceIp,d.DeviceName,d.DeviceType,d.DeviceLoc,d.DeviceDesc,d.DeviceDate from ESM_PrewarningInformation_d p , ESM_DeviceManagemnt_d d where p.DeviceId=d.DeviceId and  DATE_FORMAT(PrewarningInfoDate,'%Y%m%d')='"+date+"' order by p.PrewarningInfoDate DESC ";
		List<String> list = baseDao.findSql(hql, page, rows);
		return list;
	}
	@Transactional
	public long getPrewarningInfoListCount_date(String date) {
		String hql = "select count(p.PrewarningInfoId) from ESM_PrewarningInformation_d p , ESM_DeviceManagemnt_d d where p.DeviceId=d.DeviceId  and DATE_FORMAT(p.PrewarningInfoDate,'%Y%m%d')='"+date+"'";
		long count = baseDao.count(hql);
		return count;
	}
	@Transactional
	public List<String> getPrewarningInfoList_pid(int pid) {
		
		String hql = "select p.PrewarningInfoId,p.DeviceId,p.PrewarningInfoCPU,p.PrewarningInfoMem,p.PrewarningInfoStor,p.PrewarningInfoUpFlow,p.PrewarningInfoDownFlow,p.PrewarningInfoDate,d.DeviceIp,d.DeviceName,d.DeviceType,d.DeviceLoc,d.DeviceDesc,d.DeviceDate from ESM_PrewarningInformation_d p , ESM_DeviceManagemnt_d d where p.DeviceId=d.DeviceId and p.PrewarningInfoId="+pid;
		List<String> list = baseDao.findSql(hql);
		return list;
	}
	@Override
	public PrewarningInformation registerPrewarningInfo(int pid, int did, Date pdate) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
