package com.snmp.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snmp.beans.NetDeviceEnclosureStatus;
import com.snmp.beans.ServiceStatus;
import com.snmp.dao.TopoDAO;

@Repository("topoDAO")
public class TopoDAOImpl extends BaseDAOImpl<ServiceStatus> implements TopoDAO{

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<ServiceStatus> getServerInfoByLoc(String deviceLoc) {
		System.out.println("进入dao层："+deviceLoc);
		String hql="from ServiceStatus s,DeviceManagemnt d where s.DeviceId=d.DeviceId and d.DeviceLoc=:deviceLoc order by s.ServiceStatusDate desc";
		Query query=this.getSessionFactory().getCurrentSession().createQuery(hql);
		query.setParameter("deviceLoc", deviceLoc);
		query.setMaxResults(1);
		List<ServiceStatus> list=query.list();
		
		System.out.println(list.toString());
		return list;
	}

	@Override
	public List<NetDeviceEnclosureStatus> getMemoInfoByLoc(String deviceLoc) {
		return null;
	}
	
	
}
