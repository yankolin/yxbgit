package com.snmp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snmp.beans.Users;

@Controller
public class PathvariableController {
		
	@ResponseBody
	@RequestMapping("/pathvariable/{username}")
	public Users test(@PathVariable String username) {
			Users user = new Users();
			user.setUser_name(username);
			return user;
		}
}
