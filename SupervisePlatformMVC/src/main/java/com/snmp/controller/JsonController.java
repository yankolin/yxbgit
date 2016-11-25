package com.snmp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snmp.beans.User;
import com.snmp.beans.Users;

@Controller
public class JsonController {
	
	@ResponseBody
	@RequestMapping("getJson")//返回json
		public 	 User getUserInfo() {
			User user = new User();
			user.setUsername("sfsdf");
			user.setPassword("sdsdf");
			
			return user;
		}
	
	@ResponseBody
	@RequestMapping("doAlterJson")
	public boolean doJson(@RequestParam String username){
		if(username == ""||username.length() == 0)
			return false;
		else 
			return true;
	
	}
}
