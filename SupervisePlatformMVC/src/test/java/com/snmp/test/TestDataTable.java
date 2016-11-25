package com.snmp.test;

import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.snmp.beans.NetDeviceEnclosureStatus;
import com.snmp.beans.NetDeviceHostInformation;
import com.snmp.beans.NetDeviceHostStatus;
import com.snmp.beans.NetDeviceMdiskInformation;
import com.snmp.beans.NetDeviceMdiskStatus;
import com.snmp.beans.NetDeviceSystemInformation;
import com.snmp.beans.NetDeviceVdiskInformation;
import com.snmp.beans.NetDeviceVdiskStatus;
import com.snmp.beans.PrewarningInformation;
import com.snmp.beans.ServiceStatus;
import com.snmp.beans.SystemLog;
import com.snmp.beans.SystemSetParam;
import com.snmp.beans.DeviceManagemnt;
import com.snmp.beans.DeviceThreholdValue;
import com.snmp.beans.NetDeviceAbnormalInformation;
import com.snmp.beans.NetDeviceDriveInformation;
import com.snmp.beans.NetDeviceDriveStatus;
import com.snmp.beans.NetDeviceEnclosureInformation;
import com.snmp.beans.UserManagement;
import com.snmp.dao.BaseDAOI;
import com.snmp.serviceImpl.SystemLogServiceImpl;

import sun.util.logging.resources.logging;

public class TestDataTable{
	@Test
	public void test() {
		fail("Not yet implemented");
	}
	private BaseDAOI<UserManagement> baseDao;
	private BaseDAOI<DeviceThreholdValue> baseDaos;
	
	private ApplicationContext ctx = null;
	@Test
	public void logging() {
	    SystemLogServiceImpl logServiceImpl = new SystemLogServiceImpl();
	    logServiceImpl.getSysLog(9, "jjjjjsdfsdf");
	}
	@Test
	public void testDao() {
	    String hql = "select a.ThreholdValueId,a.ThreholdValueCPU,a.ThreholdValueMem,a.ThreholdValueStor,a.ThreholdValueUpFlow,a.ThreholdValueDownFlow from ESM_DeviceThreholdValue_d a order by a.ThreholdValueId desc";
        List<DeviceThreholdValue> list = baseDaos.find(hql, 1, 3);
        System.out.println(list);
	}
	@Test
	public void testDataSource() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
//		UserManagement userman = new UserManagement();
//		userman.setUserManName("水电费水电费收到");
//		userman.setUserManPwd("superman超人");
//		userman.setUserManEmail("qweqewq@qq.com");
//		userman.setUserManTag(0);
//		userman.setUserManType(2);
//		userman.setUserManDate(new Date());
//		session.save(userman);
		
		String hql = "select count(UserManId) from ESM_UserManagement_d ";//where UserManName = ? and UserManPwd = ?
		List<Object> param = new ArrayList<Object>();
		param.add("sdfsa");
		param.add("sdfsaf");
		long count = baseDao.count(hql);
		if(count == 0) {
			System.out.print(count);
		}else {
			System.out.println(true);
		}
		
		/*String hql = "from ESM_UserManagement_d ";//where UserManName=?
		List<Object> param = new ArrayList<Object>();
		UserManagement usr = new UserManagement();
		usr.setUserManName("1212");*/
		//Object[] params = new Object[];
		
		/*param.add(usr.getUserManName().toString());
		int page = 1;
		int rows = 2;
		Query q = session.createQuery(hql);*/
//		if (param != null && param.size() > 0) {
//			for (int i = 0; i < param.size(); i++) {
//				//System.out.println(param.get(i).toString());
//				q.setParameter(i, param.get(i));
//			}
//		}
		//q.setParameter(0,);
		 /*q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
		 List<UserManagement> list = q.list();
		 for(int i = 0; i < list.size(); i++) {
			 System.out.println(list.get(i));
		 }*/
		tx.commit();
		session.close();
		
	}
	
	@Test
	public void testDeviceManagement() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		DeviceManagemnt deviceman=new DeviceManagemnt();
		deviceman.setDeviceIp("192.168.1.1");
		deviceman.setDeviceType(1);
		deviceman.setDeviceDesc("正常");
		deviceman.setDeviceLoc("成都");
		deviceman.setDeviceName("superman");
		deviceman.setDeviceDate(new Date());
		session.save(deviceman);
		
		tx.commit();
		session.close();
		
	}
	
	@Test
	public void testDeviceThreholdValue() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		DeviceThreholdValue devth =new DeviceThreholdValue();
		devth.setThreholdValueCPU(1);
		devth.setThreholdValueDate(new Date());
		devth.setThreholdValueDownFlow(1);
		devth.setDeviceId(1);
		devth.setThreholdValueMem(2);
		devth.setThreholdValueStor(1);
		devth.setThreholdValueUpFlow(1);
		session.save(devth);
		
		tx.commit();
		session.close();
		
	}
	
	@Test
	public void testNetDevAbInfo() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceAbnormalInformation netdevabinfo=new NetDeviceAbnormalInformation();
		netdevabinfo.setAbnormalData(new Date());
		netdevabinfo.setAbnormalDriveId(3);
		netdevabinfo.setAbnormalEnclosureId(3);
		netdevabinfo.setAbnormalHostName("速配尔曼");
		netdevabinfo.setAbnormalMdiskId(3);
		netdevabinfo.setAbnormalVdiskId(3);
		session.save(netdevabinfo);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceDriveInformation() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceDriveInformation netdevdriinfo=new NetDeviceDriveInformation();
		netdevdriinfo.setDriveCapacity(5);
		netdevdriinfo.setDriveInfoDate(new Date());
		netdevdriinfo.setDriveId(2);
		netdevdriinfo.setEnclosureId(3);
		netdevdriinfo.setMdiskId(3);
		netdevdriinfo.setNetDeviceId(3);
		netdevdriinfo.setSlotId(33);
		session.save(netdevdriinfo);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceDriveStatus() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceDriveStatus netdevdrista=new NetDeviceDriveStatus();
		netdevdrista.setDriveId(3);
		netdevdrista.setDriveStatus("速配尔曼");
		netdevdrista.setDriveStatusDate(new Date());
		netdevdrista.setNetDeviceId(3);
		session.save(netdevdrista);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceEnclosureInformation() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceEnclosureInformation netdevenclosureinfo=new NetDeviceEnclosureInformation();
		netdevenclosureinfo.setEnclosureSerialNumber("超人不悔飞");
		netdevenclosureinfo.setEnclosureType("速配尔曼");
		netdevenclosureinfo.setIoGroupId(3);
		netdevenclosureinfo.setIsManaged(1);
		netdevenclosureinfo.setNetDeviceId(3);
		session.save(netdevenclosureinfo);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceEnclosureStatus() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceEnclosureStatus netdeviceenclosuresta=new NetDeviceEnclosureStatus();
		netdeviceenclosuresta.setEnclosureId(3);
		netdeviceenclosuresta.setEnclosureStatus("速配尔曼");
		netdeviceenclosuresta.setEnclosureStatusDate(new Date());
		netdeviceenclosuresta.setNetDeviceId(3);
		session.save(netdeviceenclosuresta);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceHostInformation() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceHostInformation netdevicehostinfo=new NetDeviceHostInformation();
		netdevicehostinfo.setHostInfoDate(new Date());
		netdevicehostinfo.setHostName("速配尔曼");
		netdevicehostinfo.setHostPortCount(1);
		netdevicehostinfo.setHostType("把球给我！我要回家！");
		netdevicehostinfo.setNetDeviceId(3);
		session.save(netdevicehostinfo);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceHostStatus() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceHostStatus hoststatus=new NetDeviceHostStatus();
		hoststatus.setHostName("把球给我");
		hoststatus.setHostStatus("我要回家");
		hoststatus.setHostStatusDate(new Date());
		hoststatus.setNetDeviceId(3);
		session.save(hoststatus);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceMdiskInformation() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceMdiskInformation mdiskinfo=new NetDeviceMdiskInformation();
		mdiskinfo.setMdiskCapacity(3);
		mdiskinfo.setMdiskGroup(33);
		mdiskinfo.setMdiskId(1);
		mdiskinfo.setMdiskInfoDate(new Date());
		mdiskinfo.setNetDeviceId(3);
		session.save(mdiskinfo);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceMdiskStatus() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceMdiskStatus mdiskstatus=new NetDeviceMdiskStatus();
		mdiskstatus.setMdiskId(3);
		mdiskstatus.setMdiskStatus("速配尔曼coming");
		mdiskstatus.setMdiskStatusDate(new Date());
		mdiskstatus.setNetDeviceId(3);
		session.save(mdiskstatus);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceSystemInformation() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceSystemInformation systeminfo=new NetDeviceSystemInformation();
		systeminfo.setDeviceName("速配尔曼");
		systeminfo.setNetDeviceId(3);
		systeminfo.setSystemIp("192.168.1.1");
		systeminfo.setSystemTotalCapacity("把球给我");
		systeminfo.setSystemTotalFreeSpace("我要回家");
		session.save(systeminfo);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testNetDeviceVdiskInformation() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceVdiskInformation vdiskinfo=new NetDeviceVdiskInformation();
		vdiskinfo.setMdiskGroupName("速配尔曼");
		vdiskinfo.setNetDeviceId(3);
		vdiskinfo.setVdiskCapacity("superman");
		vdiskinfo.setVdiskDate(new Date());
		vdiskinfo.setVdiskName("superfly");
		session.save(vdiskinfo);
		
		tx.commit();
		session.close();
		}
	 
	@Test
	public void testNetDeviceVdiskStatus() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		NetDeviceVdiskStatus vdiskstatus=new NetDeviceVdiskStatus();
		vdiskstatus.setNetDeviceId(3);
		vdiskstatus.setVdiskDate(new Date());
		vdiskstatus.setVdiskName("把球给我！我要回家！");
		vdiskstatus.setVdiskStatus("superfly");
		session.save(vdiskstatus);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testPrewarningInformation() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		PrewarningInformation prewarninginfo=new PrewarningInformation();
		prewarninginfo.setDeviceId(3);
		prewarninginfo.setPrewarningInfoCPU(3);
		prewarninginfo.setPrewarningInfoDate(new Date());
		prewarninginfo.setPrewarningInfoDownFlow(333l);
		prewarninginfo.setPrewarningInfoMem(333l);
		prewarninginfo.setPrewarningInfoStor(333l);
		prewarninginfo.setPrewarningInfoUpFlow(333l);
		session.save(prewarninginfo);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testServiceStatus() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		ServiceStatus servicestatus=new ServiceStatus();
		servicestatus.setDeviceId(3);
		servicestatus.setServiceStatusAllMem(333l);
		servicestatus.setServiceStatusAllStor(3333333l);
		servicestatus.setServiceStatusCPU(3);
		servicestatus.setServiceStatusDate(new Date());
		servicestatus.setServiceStatusDownFlow(33333333l);
		servicestatus.setServiceStatusMem(333l);
		servicestatus.setServiceStatusStor(333333333l);
		servicestatus.setServiceStatusUpFlow(333333333l);
		session.save(servicestatus);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testSystemLog() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		SystemLog systemlog=new SystemLog();
		systemlog.setSystemLogDate(new Date());
		systemlog.setSystemLogDesc("超人不会飞");
		systemlog.setSystemLogIp("192.168.1.1");
		systemlog.setUserId(3);
		session.save(systemlog);
		
		tx.commit();
		session.close();
		}
	
	@Test
	public void testSystemSetParam() throws SQLException {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println(ctx);
		DataSource dataSource = ctx.getBean(DataSource.class);
		System.out.println(dataSource.getConnection().toString());
		SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
		System.out.println(sessionFactory);
		
		Session session =  sessionFactory.openSession();//.getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		SystemSetParam systemsetparam=new SystemSetParam();
		systemsetparam.setDeviceType(1);
		systemsetparam.setSystemSetCleanTime(3);
		systemsetparam.setSystemSetCollectPeriod(4);
		systemsetparam.setSystemSetDate(new Date());
		systemsetparam.setSystemSetStorCapacity(3);
		session.save(systemsetparam);
		
		tx.commit();
		session.close();
		}
}
