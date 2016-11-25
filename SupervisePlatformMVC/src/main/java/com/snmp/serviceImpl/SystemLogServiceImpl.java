package com.snmp.serviceImpl;



import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.SystemLog;
import com.snmp.common.GetLoginIP;
import com.snmp.dao.BaseDAOI;

@Service("Systemlogserviceimpl")
public class SystemLogServiceImpl {

    @Resource(name="BaseDAOI")
    private BaseDAOI<String> baseDao;
    
    private ApplicationContext ctx = null;
    public void getSysLog(Integer userId ,String content) {
        
       /*SystemLog systemLog = new SystemLog();
        
        systemLog.setUserId(userId);
        GetLoginIP getLoginIP = new GetLoginIP();
        String ipString = "";
        ipString = getLoginIP.reRealIP();
        systemLog.setSystemLogIp(ipString);
        systemLog.setSystemLogDesc("This account " + content +" by ip : " + ipString);
        systemLog.setSystemLogDate(new Date());
        systemLogDAOI.saveLog(systemLog);*/
        
       // systemLogDAOI.saveOrUpdate(systemLog);
        
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");      
        DataSource dataSource = ctx.getBean(DataSource.class);
        try {
            System.out.println(dataSource.getConnection().toString());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SessionFactory sessionFactory = ctx.getBean(SessionFactory.class);
        
        Session session =  sessionFactory.openSession();//.getCurrentSession();
        Transaction tx = session.beginTransaction();
        
        SystemLog systemLog = new SystemLog();
        
        systemLog.setUserId(userId);
        GetLoginIP getLoginIP = new GetLoginIP();
        String ipString = "";
        ipString = getLoginIP.reRealIP();
        systemLog.setSystemLogIp(ipString);
        systemLog.setSystemLogDesc("This account " + content +" by ip : " + ipString);
        systemLog.setSystemLogDate(new Date());
        session.save(systemLog);
        
        tx.commit();
        session.close();
       // return systemLog;
        
//        UserManagement user = new UserManagement();
//
//        String pwds = CreateMD5.getMd5(CreateMD5.getMd5(CreateMD5.getMd5("asdasdas")));
//        user.setUserManName("asda");
//        user.setUserManPwd(pwds);
//        user.setUserManEmail("sdfsad");
//        user.setUserManType(0);
//        user.setUserManTag(1);
//        user.setUserManDate(new Date());
//        
//        userDao.saveOrUpdate(user);
    }
    
    
    @Transactional
    public List<String> getSystemLogList(int page, int rows) {
        // TODO Auto-generated method stub
        
        String hql = "select p.SystemLogId,p.UserId,p.SystemLogIp,p.SystemLogDesc,p.SystemLogDate,d.UserManName,d.UserManType,d.UserManEmail from ESM_SystemLog_l p , ESM_UserManagement_d d where p.UserId=d.UserManId order by p.SystemLogDate DESC ";
        List<String> list = baseDao.findSql(hql, page, rows);
        return list;
        
    }

     @Transactional
    public long getSystemLogCount() {
        // TODO Auto-generated method stub
        String hql = "select count(SystemLogId) from ESM_SystemLog_l";
        long count = baseDao.count(hql);
        return count;
    }
    
    @Transactional
    public List<String> getSystemLogList(int page,int rows,String name,String date) {
        
        String hql = "select p.SystemLogId,p.UserId,p.SystemLogIp,p.SystemLogDesc,p.SystemLogDate,d.UserManName,d.UserManType,d.UserManEmail from ESM_SystemLog_l p , ESM_UserManagement_d d where p.UserId=d.UserManId and d.UserManName='"+name+"' and DATE_FORMAT(p.SystemLogDate,'%Y%m%d')='"+date+"'  order by p.SystemLogDate DESC  ";
        List<String> list = baseDao.findSql(hql, page, rows);
        return list;
    }
    @Transactional
    public long getSystemLogListCount(String name,String date) {
        String hql = "select count(p.SystemLogId) from ESM_SystemLog_l p , ESM_UserManagement_d d where p.UserId=d.UserManId and d.UserManName='"+name+"' and DATE_FORMAT(p.SystemLogDate,'%Y%m%d')='"+date+"'";
        long count = baseDao.count(hql);
        return count;
    }
    @Transactional
    public List<String> getSystemLogList_name(int page,int rows,String name) {
        
        String hql = "select p.SystemLogId,p.UserId,p.SystemLogIp,p.SystemLogDesc,p.SystemLogDate,d.UserManName,d.UserManType,d.UserManEmail from ESM_SystemLog_l p , ESM_UserManagement_d d where p.UserId=d.UserManId and d.UserManName='"+name+"'   order by p.SystemLogDate DESC ";
        List<String> list = baseDao.findSql(hql, page, rows);
        return list;
    }
    @Transactional
    public long getSystemLogListCount_name(String name) {
        String hql = "select count(p.SystemLogId) from ESM_SystemLog_l p , ESM_UserManagement_d d where p.UserId=d.UserManId and d.UserManName='"+name+"'";
        long count = baseDao.count(hql);
        return count;
    }
    @Transactional
    public List<String> getSystemLogList_date(int page,int rows,String date) {
        
        String hql = "select p.SystemLogId,p.UserId,p.SystemLogIp,p.SystemLogDesc,p.SystemLogDate,d.UserManName,d.UserManType,d.UserManEmail from ESM_SystemLog_l p , ESM_UserManagement_d d where p.UserId=d.UserManId  and DATE_FORMAT(p.SystemLogDate,'%Y%m%d')='"+date+"'  order by p.SystemLogDate DESC ";
        List<String> list = baseDao.findSql(hql, page, rows);
        return list;
    }
    @Transactional
    public long getSystemLogListCount_date(String date) {
        String hql = "select count(p.SystemLogId) from ESM_SystemLog_l p , ESM_UserManagement_d d where p.UserId=d.UserManId  and DATE_FORMAT(p.SystemLogDate,'%Y%m%d')='"+date+"'";
        long count = baseDao.count(hql);
        return count;
    }
    @Transactional
    public List<String> getSystemLogList_sid(int sid) {
        
        String hql = "select p.SystemLogId,p.UserId,p.SystemLogIp,p.SystemLogDesc,p.SystemLogDate,d.UserManName,d.UserManType,d.UserManEmail from ESM_SystemLog_l p , ESM_UserManagement_d d where p.UserId=d.UserManId and p.SystemLogId="+sid;
        List<String> list = baseDao.findSql(hql);
        return list;
    }
}
