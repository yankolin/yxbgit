package com.snmp.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.snmp.beans.DeviceThreholdValue;
import com.snmp.dao.ThreholdValueDAOI;

@Repository("ThreholdValueDAOI")
public class ThreholdValueDAOImpl extends BaseDAOImpl<DeviceThreholdValue> implements ThreholdValueDAOI{
  
   public long checkIPDao(List<Object> param) {
       String hql = "select count(ThreholdValueId) from ESM_DeviceThreholdValue_d where ThreholdValueId = ?";
      return  super.count(hql, param);
       
   }
    
    public long getCountDao() {
        String hql = "select count(ThreholdValueId) from ESM_DeviceThreholdValue_d ";
        long count = super.count(hql);
       
        return count;
    }
    
    public List<DeviceThreholdValue> getThreholdListDao(int page,int rows) {
        //wenti device ip
        String hql = "select a.ThreholdValueId,a.ThreholdValueCPU,a.ThreholdValueMem,a.ThreholdValueStor,a.ThreholdValueUpFlow,a.ThreholdValueDownFlow from ESM_DeviceThreholdValue_d a order by a.ThreholdValueId desc";
        List<DeviceThreholdValue> list = super.find(hql, page, rows);
        return list;
    }
    
    public int alterThreholdDao(DeviceThreholdValue dtv) {
        String hql = "update ESM_DeviceThreholdValue_d set ThreholdValueCPU =" + dtv.getThreholdValueCPU() +",ThreholdValueMem=" + dtv.getThreholdValueMem() +
                ",ThreholdValueStor=" + dtv.getThreholdValueStor() + ",ThreholdValueUpFlow=" + dtv.getThreholdValueUpFlow() + ",ThreholdValueDownFlow=" + dtv.getThreholdValueDownFlow() +
                " where ThreholdValueId = "+dtv.getThreholdValueId();
        //System.out.println(hql);
        Integer num = this.getCurrentSession().createQuery(hql).executeUpdate();
        return num;
    }
}
