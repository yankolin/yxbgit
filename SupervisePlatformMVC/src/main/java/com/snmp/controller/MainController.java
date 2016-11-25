package com.snmp.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snmp.beans.GlobalStatus;
import com.snmp.serviceImpl.MainServiceImpl;

@Controller
public class MainController {
	
	@Resource
	private MainServiceImpl service;
	
	@ResponseBody
	@RequestMapping("getMainJson")
	public List<GlobalStatus>  getMainJson() {
		List<GlobalStatus> list  = service.getMainInfo();
		
		return list;
	}
}
