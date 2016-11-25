package com.snmp.service;

import java.util.List;

import com.snmp.beans.UserManagement;

public interface UserManagementServiceI {
			UserManagement registerUser(String name,String pwd,String email,int type,int tag);
			List<UserManagement> getUserManagementList(int page,int rows,int userid);
			int alterUser(String name,String email,int tag,int id);
			int delUser(int id);
			long getUserManagementListCount(int userid);
}
