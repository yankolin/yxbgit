package com.snmp.service;

import java.util.Date;
import java.util.List;

import com.snmp.beans.PrewarningInformation;


public interface PrewarningInfoServiceI {
	PrewarningInformation registerPrewarningInfo(int pid,int did,Date pdate);
	List<String> getPrewarningInfoList(int page,int rows);
	
	long getPrewarningInfoListCount();
}
