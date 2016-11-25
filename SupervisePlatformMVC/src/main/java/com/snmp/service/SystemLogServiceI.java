package com.snmp.service;

import java.util.List;

import com.snmp.beans.SystemLog;


public interface SystemLogServiceI {

	List<String> getSystemLogList(int page,int rows);
	
	long getSystemLogCount();
}
