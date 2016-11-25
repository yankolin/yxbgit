package com.snmp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mysql.jdbc.log.LogFactory;
import com.snmp.beans.DeviceThreholdValue;
import com.snmp.common.TokenProcess;
import com.snmp.serviceImpl.ThreholdConfigServiceImpl;

@Controller
public class ThreholdConfigController {

    Logger logger = Logger.getLogger(ThreholdConfigController.class);
    @Resource
   ThreholdConfigServiceImpl service;
    
    int rows = 3;

    @RequestMapping("initthrehold")
    public String showInitTabThrehold(ModelMap map,HttpSession httpSession,HttpServletRequest request) {
        String name = (String)httpSession.getAttribute("name");
        System.out.println(name+"*****");
        if(name == null || name.length() == 0  ) {
            String token = TokenProcess.getInstance().makeToken();//创建令牌
          request.getSession().setAttribute("login_token", token); 
            return "login";
        }else { 
            List<DeviceThreholdValue> list  = service.getThreholdList(1, rows);
            map.addAttribute("threhold_data", list);
            map.put("user_name", name);
            return "threholdvalueman";
        }

    }
    @ResponseBody
    @RequestMapping("getTVMCount")
    public ArrayList<Integer> getTVMCount() {
        long count = service.getThreholdCount();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add((int)count);
        list.add(rows);
        return list;
    }
    
    @ResponseBody
    @RequestMapping("getTVMTableJson")
    public List<DeviceThreholdValue> getTVMTableJson(@RequestParam int page) {
        List<DeviceThreholdValue> list = service.getThreholdList(page, rows);
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value = "doTVAddthrehold",method = RequestMethod.POST)
    public boolean doTVAddthrehold(@RequestParam int id,@RequestParam int cpu,@RequestParam long mem,@RequestParam long stor,
               @RequestParam long upflow,@RequestParam long downflow) {
        logger.warn(id+"****");
        try {
              
            DeviceThreholdValue dtv = service.addThreholdValue(id, cpu, mem, stor, upflow, downflow);
            if(dtv == null)
                return false;
         }catch(Exception e) {
                return false;
         }
        return true;
        }
    
    @ResponseBody
    @RequestMapping(value = "doTVAlterthrehold",method = RequestMethod.POST)
    public boolean doTVAlterthrehold(@RequestParam int id,@RequestParam int cpu,@RequestParam long mem,@RequestParam long stor,
               @RequestParam long upflow,@RequestParam long downflow) {
        logger.warn(id+"****");
        try {
              
            int num = service.alterThreholdValue(id, cpu, mem, stor, upflow, downflow);
            if(num == 0)
                return false;
         }catch(Exception e) {
             logger.warn(e.getMessage());
                return false;
        }
        return true;
    }
    
    
    @ResponseBody
    @RequestMapping(value="getTVCheckip",method = RequestMethod.POST)
    public boolean getTVCheckip(@RequestParam String ip) {
        return service.checkIP(ip);
    }
}
