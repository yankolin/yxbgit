package com.snmp.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.snmp.beans.UserManagement;
import com.snmp.common.TokenProcess;
import com.snmp.serviceImpl.SystemLogServiceImpl;
import com.snmp.serviceImpl.UserManagementServiceImpl;

@Controller
@SessionAttributes("usermanagement")//存放对象配合modelmap使用
public class UsermanagementController {

	private static final Log logger = LogFactory.getLog(UsermanagementController.class);
	@Resource
	UserManagementServiceImpl service;
	SystemLogServiceImpl logServiceImpl = new SystemLogServiceImpl();
	int rows = 2;
	
	/**
     * 判断客户端提交上来的令牌和服务器端生成的令牌是否一致
     * @param request
     * @return 
     *         true 用户重复提交了表单 
     *         false 用户没有重复提交表单
     */
    private boolean isRepeatSubmit(HttpServletRequest request,String token) {
        String client_token = request.getParameter(token);
        System.out.println("token"+client_token);
        //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
        if(client_token==null){
            return true;
        }
        //取出存储在Session中的token
        String server_token = (String) request.getSession().getAttribute(token);
        //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
        if(server_token==null){
            return true;
        }
        //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
        if(!client_token.equals(server_token)){
            return true;
        }
        
        return false;
    }

    private boolean isRepeatSubmits(HttpServletRequest request,String token,String client_token) {
        // String client_token = request.getParameter(token);
         System.out.println("token"+client_token);
         //1、如果用户提交的表单数据中没有token，则用户是重复提交了表单
         if(client_token==null){
             return true;
         }
         //取出存储在Session中的token
         String server_token = (String) request.getSession().getAttribute(token);
         System.out.println("servcietoken:"+server_token);
         //2、如果当前用户的Session中不存在Token(令牌)，则用户是重复提交了表单
         if(server_token==null){
             return true;
         }
         //3、存储在Session中的Token(令牌)与表单提交的Token(令牌)不同，则用户是重复提交了表单
         if(!client_token.equals(server_token)){
             return true;
         }
         
         return false;
     }

	
@RequestMapping(value = "doLogin",method = RequestMethod.POST)
public String doUMLogin(@RequestParam String admin_name,@RequestParam String admin_pwd,
		HttpServletRequest request, ModelMap map,HttpSession httpSession ) {
    
    boolean b = isRepeatSubmit(request,"login_token");//判断用户是否是重复提交
    if(b==true){
        System.out.println("请不要重复提交");
        String token = TokenProcess.getInstance().makeToken();//创建令牌
//        System.out.println("在FormServlet中生成的token4545："+token);
        request.getSession().setAttribute("login_token", token); 
        return "login";
    }else {
       
        System.out.println("处理用户提交请求！！");
        boolean login  = service.doLogin(admin_name, admin_pwd);
        Integer usrId = service.getUserIdByName(admin_name);
        logger.warn("login"+login + "userId :" + usrId);
        if(!login){
            request.setAttribute("error_login", "用户名或者密码有误，请重新输入！");
            return "login";
        }else {
            httpSession.setAttribute("name", admin_name);
            httpSession.setAttribute("userId", usrId);
            httpSession.setAttribute("date", new Date());
            logServiceImpl.getSysLog(usrId, admin_name + " login the system ");
            request.getSession().removeAttribute("login_token");//移除session中的token
            map.put("user_name", admin_name);
           // request.getRequestDispatcher("/form.jsp").forward();
            return "main";
                        }
           }
  
    
	//try {
		//User user = service.doLogin(admin_name, admin_pwd); 
		//map.put("user", user);
	//	logger.warn("adminname:"+admin_name);
		
//	} catch (Exception e) {
//		request.setAttribute("error_login", e.getMessage());
//		return "login";
//	}		

}
	
@RequestMapping("inituserman")
public String showInitTabUser(ModelMap map,HttpSession httpSession,HttpServletRequest request) {
	String name = (String)httpSession.getAttribute("name");
	Integer userid = (Integer)httpSession.getAttribute("userId");
	System.out.println(name+"*****");
	if(name == null || name.length() == 0  ) {
		return "login";
	}else { 
		List<UserManagement> list  = service.getUserManagementList(1,rows,userid);
		map.addAttribute("user_data", list);
		map.put("user_name", name);
		return "userman";
	}

}


	@ResponseBody
	@RequestMapping(value = "doUMAddUser",method = RequestMethod.POST)
	public boolean doUMAddUser(@RequestParam String name, @RequestParam String pwd,
			@RequestParam String email,@RequestParam int type,@RequestParam int tag,HttpServletRequest request) {
//	    boolean b = isRepeatSubmits(request,"adduser_id",adduser_id);
//	    if(b == true) {
//	     System.out.println("repeat submit add user");  
//	     return false;
//	    }else {
	        if(!service.checkUser(name)) {
	         try {
	                UserManagement user = service.registerUser(name, pwd, email, type, tag);
	                
	                if(user == null) {
	                    return false;
	                }else {
	                   // request.getSession().removeAttribute("adduser_id");//移除session中的token
	                    return true;
	                                              }
	             }catch(Exception e) {
	                    return false;
	                                 }
	         
	            }else {
	                  return false;
	                    }
	        //   }
	   
	}
	
	@ResponseBody
	@RequestMapping(value="doUMCheckuser",method = RequestMethod.POST)
	public boolean doUMCheckuser(@RequestParam String name) {
	   
	    return service.checkUser(name);
	    
	}
	
	@ResponseBody
	@RequestMapping(value = "doUMAlterUser",method = RequestMethod.POST)
	public boolean doUMAlterUser(@RequestParam String name,@RequestParam String email,
			@RequestParam int tag,@RequestParam int id) {
			try {
			int user = service.alterUser(name, email, tag,id);
			if(user == 0)
				return false;
		 }catch(Exception e) {
			 	return false;
		}
		return true;
	}

	  @ResponseBody
	    @RequestMapping(value = "doUMAlterprofileUser",method = RequestMethod.POST)
	    public boolean doUMAlterprofileUser(@RequestParam String name,@RequestParam String email,
	            @RequestParam int tag,@RequestParam int id) {
	            try {
	            int user = service.alterUser(name, email, tag,id);
	            if(user == 0)
	                return false;
	         }catch(Exception e) {
	                return false;
	        }
	        return true;
	    }

	  @ResponseBody
	    @RequestMapping(value="getProfileName",method = RequestMethod.POST)
	    public List<UserManagement> getProfileName(@RequestParam String name) {
	       
	            List<UserManagement> list  = service.getUserListByName(name);
	            return list;
	    }
	    
	  @ResponseBody
	  @RequestMapping(value = "doUMAlterpwd",method = RequestMethod.POST)
	  public int doUMAlterprofileUser(@RequestParam String name,@RequestParam String oldpwd,@RequestParam String newpwd) {
	          try {
	             return service.updatePwd(name, oldpwd, newpwd);
	       }catch(Exception e) {
	              return 0;
	      }

	  }
	
	@ResponseBody
	@RequestMapping(value = "doUMDelUser",method = RequestMethod.POST)
	public boolean doUMDelUser(@RequestParam int id) {
			try {
			int user = service.delUser(id);
					if(user == 0)
				return false;
		 }catch(Exception e) {
			 	return false;
		}
		return true;
	}

	
	@ResponseBody
	@RequestMapping(value="getUMUsercount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableCount(HttpSession httpSession) {
	    Integer userid = (Integer)httpSession.getAttribute("userId");
		long count = service.getUserManagementListCount(userid);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showUMTabUserJson",method = RequestMethod.GET)
	public List<UserManagement>  showTabUserJson(@RequestParam int page,HttpServletRequest request,ModelMap map,HttpSession httpSession) {
	Integer userid = (Integer)httpSession.getAttribute("userId");
	    List<UserManagement> list  = service.getUserManagementList(page,rows,userid);
		map.addAttribute("user_data", list);
		return list;
	}
	
	
	@RequestMapping("test")
	public String test(HttpServletRequest request, ModelMap map) {
		List<String> test_data = new ArrayList<String>();
		System.out.println("hello word");
		test_data.add("Hello world\n");
		test_data.add("hello world again \n");
		map.addAttribute("test_data", test_data);
		//request.setAttribute("test_data", test_data);
		return "userman"; 
	}
}
