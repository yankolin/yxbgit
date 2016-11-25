package com.snmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snmp.beans.DeviceManagemnt;
import com.snmp.serviceImpl.DeviceIpServiceImpl;

@Controller
public class DeviceIpController {
	
	@Resource
	private DeviceIpServiceImpl service;
	
	@ResponseBody
	@RequestMapping("getIpJson")
	public List<DeviceManagemnt>  getIpJson() {
		List<DeviceManagemnt> list  = service.getDeviceIpInfo();
		
		return list;
	}
}
