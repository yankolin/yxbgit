package com.snmp.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.procedure.internal.Util.ResultClassesResolutionContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.snmp.beans.SystemSetParam;
import com.snmp.common.TokenProcess;
import com.snmp.serviceImpl.DataCollectionConfigServiceImpl;

@Controller
public class DataCollectionConfigController {
    
    @Resource
    DataCollectionConfigServiceImpl service;
    
   // @ResponseBody
    @RequestMapping("dataconfig")
    public String getCollectionConfig(HttpSession httpSession,ModelMap map,HttpServletRequest request) {
        String name = (String)httpSession.getAttribute("name");
        System.out.println(name+"*****");
        if(name == null || name.length() == 0  ) {
            String token = TokenProcess.getInstance().makeToken();//创建令牌
            request.getSession().setAttribute("login_token", token);  //在服务器使用session保存token(令牌)
            return "login";
        }else { 
            List<SystemSetParam> list  = service.getCollectionConfigService();
            map.put("service_data", list.get(0).getSystemSetCollectPeriod());
            map.put("switch_data", list.get(1).getSystemSetCollectPeriod());
            map.put("stor_data", list.get(2).getSystemSetCollectPeriod());
            map.put("user_name", name);
            return "datacollectman";
        }
    }
    
    @ResponseBody
    @RequestMapping(value="updateCollectionConfig",method = RequestMethod.POST)
    public boolean updateCollectionConfig(@RequestParam int servicedata,@RequestParam int netdevice,@RequestParam int stordevice) {
          boolean falg =  service.updateCollectionConfigService(servicedata, netdevice, stordevice);
          return falg;
    }
}
