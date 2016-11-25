package com.snmp.dao;

import java.util.List;

import com.snmp.beans.DeviceThreholdValue;

public interface ThreholdValueDAOI extends BaseDAOI<DeviceThreholdValue> {
    long checkIPDao(List<Object> param);
    long getCountDao();
    int alterThreholdDao(DeviceThreholdValue dtv);
    List<DeviceThreholdValue> getThreholdListDao(int page,int rows);
}
