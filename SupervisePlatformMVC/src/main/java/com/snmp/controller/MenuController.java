package com.snmp.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.snmp.common.TokenProcess;
import com.snmp.serviceImpl.SystemLogServiceImpl;
import com.snmp.serviceImpl.UserManagementServiceImpl;
import com.snmp.serviceImpl.UserServiceImpl;
import com.sun.javafx.collections.MappingChange.Map;


@Controller
@SessionAttributes("user")//存放对象配合modelmap使用
public class MenuController {
			private SystemLogServiceImpl systemLogServiceImpl = new SystemLogServiceImpl();

	@Resource
	UserServiceImpl service;
	@Resource
	UserManagementServiceImpl serviceman;
	
	@RequestMapping("login")
	public String toLoginPage(HttpServletRequest request){
	       String token = TokenProcess.getInstance().makeToken();//创建令牌
        System.out.println("在FormServlet中生成的token："+token);
        request.getSession().setAttribute("login_token", token);  //在服务器使用session保存token(令牌)
       // request.getRequestDispatcher("/form.jsp").forward(request, response);//跳转到form.jsp页面
		return "login";
	}
	
	@RequestMapping("main")
	public String toMainPage(HttpSession httpSession,ModelMap map,HttpServletRequest request){
		String name = (String)httpSession.getAttribute("name");
	 Integer id = (Integer)httpSession.getAttribute("userId");
		if(httpSession.getAttribute("name") == null || name.length() == 0) {
		  //systemLogServiceImpl.getSysLog(id, name + " timeout logout the system ");
		  String token = TokenProcess.getInstance().makeToken();//创建令牌
	    request.getSession().setAttribute("login_token", token);  //在服务器使用session保存token(令牌)
			return "login";
		}else {
		  map.put("user_name", name);
			return "main";
		}
	}


	@RequestMapping("servicetopo")
	public String toTopoPage(HttpSession httpSession,ModelMap map,HttpServletRequest request){
//		String name = (String)httpSession.getAttribute("name");
//		if(name == null || name.length() == 0) {
//		  String token = TokenProcess.getInstance().makeToken();//创建令牌
//	   request.getSession().setAttribute("login_token", token);  //在服务器使用session保存token(令牌)
//			return "login";
//		}else {
//		   map.put("user_name", name);
			return "topo";
//		}
	}



	@RequestMapping("doLoginout")
	public String doLogout(SessionStatus status,HttpSession httpSession,HttpServletRequest request){
	    String name = (String) httpSession.getAttribute("name");
	    Integer id = (Integer)httpSession.getAttribute("userId");
	 httpSession.removeAttribute("name");
	 httpSession.removeAttribute("userId");
		status.setComplete();
	 String token = TokenProcess.getInstance().makeToken();//创建令牌
	 request.getSession().setAttribute("login_token", token);  //在服务器使用session保存token(令牌)
	 systemLogServiceImpl.getSysLog(id, name + " logout the system ");
		return "login";
	}
}
