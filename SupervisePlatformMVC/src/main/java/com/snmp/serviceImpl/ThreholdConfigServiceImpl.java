package com.snmp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.DeviceThreholdValue;
import com.snmp.dao.ThreholdValueDAOI;
import com.snmp.service.ThreholdConfigServiceI;

@Service("threholdService")
public class ThreholdConfigServiceImpl implements ThreholdConfigServiceI {

    @Resource
   // private BaseDAOI<DeviceThreholdValue> baseDao;
    private ThreholdValueDAOI threholdDao;
    private Logger logger = Logger.getLogger(ThreholdConfigServiceImpl.class);
    public boolean checkAddip(String ip) {
        //String hql = "select count()"
        return true;
    }
    
    @Transactional
    public List<DeviceThreholdValue> getThreholdList(int page,int rows) {
        
        return threholdDao.getThreholdListDao(page, rows);
    }
    
    @Transactional
    public long getThreholdCount() {
        //wenti device ip
       return threholdDao.getCountDao();
    }
    
    //@Transactional
    public DeviceThreholdValue addThreholdValue(int id,int cpu,long mem,long stor,long upflow,long downflow) {
       DeviceThreholdValue dtv = new DeviceThreholdValue();
       dtv.setDeviceId(id);
       dtv.setThreholdValueCPU(cpu);
       dtv.setThreholdValueMem(mem);
       dtv.setThreholdValueStor(stor);
       dtv.setThreholdValueUpFlow(upflow);
       dtv.setThreholdValueDownFlow(downflow);
       dtv.setThreholdValueDate(new Date());
       
       threholdDao.saveOrUpdate(dtv);
        
       return dtv;
    }
    
    @Transactional
    public int alterThreholdValue(int id,int cpu,long mem,long stor,long upflow,long downflow) {
        
        DeviceThreholdValue dtv = new DeviceThreholdValue();
        dtv.setThreholdValueId(id);
        dtv.setThreholdValueCPU(cpu);
        dtv.setThreholdValueMem(mem);
        dtv.setThreholdValueStor(stor);
        dtv.setThreholdValueUpFlow(upflow);
        dtv.setThreholdValueDownFlow(downflow);
        int num = threholdDao.alterThreholdDao(dtv);
        return num;
    }
    
    @Transactional
    public boolean checkIP(String ip) {
      
        List<Object> param = new ArrayList<Object>();
        param.add(ip);
        long count =  threholdDao.checkIPDao(param);
        if(count == 0) {
         return false;
        }else {
          return true;      
              }
    }
}
