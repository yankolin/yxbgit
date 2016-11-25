package com.snmp.dao;

import java.util.List;

import com.snmp.beans.SystemSetParam;

public interface DataCollectionConfigDAOI {
    
    List<SystemSetParam> getInitConfig();
    int updateCollectionConfigDao(int type, int val);
}
