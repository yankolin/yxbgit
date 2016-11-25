package com.snmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snmp.beans.NetDeviceGlobalStatus;
import com.snmp.serviceImpl.NetDeviceGlobalStatusServiceImpl;

@Controller
public class StorStatusController {
	@Resource
	private NetDeviceGlobalStatusServiceImpl service;
	
	@RequestMapping("seekstor")
	public String  getStorStatusJson() {
		
		
		return "seekstor";
	}
	@ResponseBody
	@RequestMapping(value="getStorStatusJson",method = RequestMethod.POST)
	public List<NetDeviceGlobalStatus>  getNetDeviceGlobalStatusJson(@RequestParam String ip,String time1,String time2,String tName) {
		
		List<NetDeviceGlobalStatus> list  = service.getNetDeviceGlobalStatusInfo(ip,time1,time2,tName);
		
		return list;
	}
}
