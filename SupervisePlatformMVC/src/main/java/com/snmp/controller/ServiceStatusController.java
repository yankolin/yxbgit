package com.snmp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snmp.beans.ServiceStatus;
import com.snmp.common.TokenProcess;
import com.snmp.serviceImpl.ServiceStatusServiceImpl;;

@Controller
public class ServiceStatusController {

	@Resource
	private ServiceStatusServiceImpl service;
	
	@RequestMapping("seekserver")
	public String toTopoPage(HttpSession httpSession,ModelMap map,HttpServletRequest request){
		String name = (String)httpSession.getAttribute("name");
		if(name == null || name.length() == 0) {
		  String token = TokenProcess.getInstance().makeToken();//创建令牌
	   request.getSession().setAttribute("login_token", token);  //在服务器使用session保存token(令牌)
			return "login";
		}else {
		   map.put("user_name", name);
			return "seekserver";
		}
	}
	
	
	@ResponseBody
	@RequestMapping(value="getServiceStatusJson",method = RequestMethod.POST)
	public List<ServiceStatus>  getServiceStatusJson(@RequestParam String ip,String time1,String time2,String tName) {
		
		List<ServiceStatus> list  = service.getServiceStatusInfo(ip,time1,time2,tName);
		
		return list;
	}
}
