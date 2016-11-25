package com.snmp.dao;

import java.util.List;

import org.apache.log4j.lf5.viewer.TrackingAdjustmentListener;

import com.snmp.beans.UserManagement;

public interface UserManagementDAOI extends BaseDAOI<UserManagement>{
        long getUserCountDao(int userid);
        long doLoginDao(List<Object> param);
        long checkUserDao(List<Object> param );
        int alterUserDao(UserManagement user);
        int delUserDao(UserManagement user);
        List<UserManagement> getUsermanagementListDao(int page, int rows,int userid);
        List<UserManagement> getUserListDaoByname(String name);
        List<UserManagement> getUserIdByname(String name); 
        int updatePwdDao(String name,String pwd);
}
