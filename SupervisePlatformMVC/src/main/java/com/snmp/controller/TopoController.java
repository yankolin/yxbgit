package com.snmp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.snmp.beans.ServiceStatus;
import com.snmp.serviceImpl.TopoImplService;

@Controller
@SessionAttributes("topo")
public class TopoController {
	
	@Resource
	private TopoImplService topoImplService;

	public TopoImplService getTopoImplService() {
		return topoImplService;
	}

	//提供注入的set方法
	public void setTopoImplService(TopoImplService topoImplService) {
		this.topoImplService = topoImplService;
	}
	
	@ResponseBody
	@RequestMapping(value="getServerInfo",method=RequestMethod.GET)
	public List<ServiceStatus> getServerInfo(@RequestParam String deviceLoc,HttpServletRequest request,ModelMap map){
		System.out.println("这里进入controller!"+"   参数情况："+deviceLoc);
		
		List<ServiceStatus> list=topoImplService.getService(deviceLoc);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getStorInfo",method=RequestMethod.GET)
	public List<String> getMemoInfo(@RequestParam String deviceLoc,HttpServletRequest request,ModelMap map){
		return null;
	}
	
	@RequestMapping(value="")
	public List<String> getSwitchInfo(@RequestParam String deviceLoc,HttpServletRequest request,ModelMap map){
		return null;
	}
	
	
}
