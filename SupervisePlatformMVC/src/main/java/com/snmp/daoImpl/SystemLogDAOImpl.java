package com.snmp.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snmp.beans.SystemLog;
import com.snmp.beans.User;
import com.snmp.dao.SystemLogDAOI;

@Repository
public class SystemLogDAOImpl extends BaseDAOImpl<SystemLog> implements SystemLogDAOI {

   
  
    /**
     * 进行持久化的方法需要使用@Transcational进行事务管理
     */
    //@Transactional(readOnly = false,rollbackFor = RuntimeException.class)
    public void saveLog(SystemLog systemLog) {
       super.save(systemLog);
        
    }

   
}
