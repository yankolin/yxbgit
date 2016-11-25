package com.snmp.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.snmp.beans.SystemSetParam;
import com.snmp.dao.DataCollectionConfigDAOI;

@Repository("DataCollectionConfigDAOI")
public class DataCollectionConfigDAOImpl extends BaseDAOImpl<SystemSetParam> implements DataCollectionConfigDAOI{
     
  public  List<SystemSetParam> getInitConfig() {
        
        String hql =" from ESM_SystemSetParam_c ";
        List<SystemSetParam> list = super.find(hql);
        return list;
    }
  
  public int updateCollectionConfigDao(int type, int val) {
      String hql = "update ESM_SystemSetParam_c set SystemSetCollectPeriod = " + val+ " where SystemSetId =" + type;
      return super.executeHql(hql);
  }
}
