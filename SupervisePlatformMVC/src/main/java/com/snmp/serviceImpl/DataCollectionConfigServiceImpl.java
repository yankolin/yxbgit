package com.snmp.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.SystemSetParam;
import com.snmp.dao.DataCollectionConfigDAOI;
import com.snmp.service.DataCollectionConfigServiceI;

@Service("DataCollectionConfigServiceI")
public class DataCollectionConfigServiceImpl implements DataCollectionConfigServiceI{
    
    @Resource
    private DataCollectionConfigDAOI dataDao;
    
    @Transactional
    public List<SystemSetParam> getCollectionConfigService() {
        List<SystemSetParam> list = dataDao.getInitConfig();
        return list;
    }
    
    @Transactional
    public boolean updateCollectionConfigService(int service,int netdevice,int stordevice) {
         
        try {
            dataDao.updateCollectionConfigDao(0, service);
            dataDao.updateCollectionConfigDao(1,netdevice);
            dataDao.updateCollectionConfigDao(2,stordevice);
           
            return true;
            
        } catch (Exception e) {
            // TODO: handle exception
            return false;
        }
        
    }
}
