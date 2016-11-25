package com.snmp.daoImpl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snmp.beans.DeviceManagemnt;
import com.snmp.dao.DeviceManageDAOI;

@Repository("deviceManageDAO")
public class DeviceManageDAOImpl extends BaseDAOImpl<DeviceManagemnt> implements DeviceManageDAOI{

//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	public SessionFactory getSessionFactory() {
//		return sessionFactory;
//	}
//
//	public void setSessionFactory(SessionFactory sessionFactory) {
//		this.sessionFactory = sessionFactory;
//	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean findDeiveByIp(String ipAddress) {
		System.out.println("DeviceManageDAOImpl:"+ipAddress);
		String hql="from DeviceManagemnt d where d.DeviceIp=:deviceIp";
		
		List<DeviceManagemnt> list=this.getSessionFactory().getCurrentSession().createQuery(hql).setParameter("deviceIp", ipAddress).list();	
		//如果不存在，返回false
		if (list.size()==0) {
			return false;
		}
		System.out.println(list);
		return true;
	}

	@Override
	public boolean deleteDeviceByID(Integer deviceId) {
		System.out.println("dao 执行删除设备前    删除设备");
		String hql="delete from DeviceManagemnt d where d.DeviceId=:deviceId";
		this.getSessionFactory().getCurrentSession().createQuery(hql).setParameter("deviceId", deviceId).executeUpdate();
		System.out.println("dao 删除设备");
		return true;
	}

	@Override
	public boolean updateDeviceMessage(int id, String ip, int type, String name, String loc, String desc) {
		String hql="update DeviceManagemnt d set d.DeviceIp=:DeviceIp,d.DeviceName=:DeviceName,d.DeviceType=:DeviceType,d.DeviceLoc=:DeviceLoc,d.DeviceDesc=:DeviceDesc,d.DeviceDate=:DeviceDate where d.DeviceId=:DeviceId";
		Query queryUpdate = this.getSessionFactory().getCurrentSession().createQuery(hql);
		queryUpdate.setParameter("DeviceId",id);
		queryUpdate.setParameter("DeviceIp", ip);
		queryUpdate.setParameter("DeviceName", name);
		queryUpdate.setParameter("DeviceType", type);
		queryUpdate.setParameter("DeviceLoc", loc);
		queryUpdate.setParameter("DeviceDesc", desc);
		queryUpdate.setParameter("DeviceDate",new Date());
		queryUpdate.executeUpdate();
		
		return true;
	}

	public long getCountDeviceDao() {
	    String hql = "select count(DeviceId) from DeviceManagemnt";
	    return super.count(hql);
	}
	
	public List<DeviceManagemnt> getDeviceListDao(int page,int rows) {
	    
	   String hql = "select DeviceId,DeviceIp,DeviceName,DeviceType,DeviceLoc,DeviceDesc from DeviceManagemnt order by DeviceId desc";
	   return  super.find(hql, page, rows);
        
    }
}
