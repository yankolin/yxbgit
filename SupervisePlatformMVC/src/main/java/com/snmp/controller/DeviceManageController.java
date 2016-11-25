package com.snmp.controller;

import java.util.ArrayList;
import java.util.Iterator;
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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.snmp.beans.DeviceManagemnt;
import com.snmp.common.TokenProcess;
import com.snmp.service.DeviceManagementService;

@Controller
@SessionAttributes("devicemanagemnt")
public class DeviceManageController {
	
	int rows=2;
	
	@Resource
	private DeviceManagementService deviceManageService;
	
	public DeviceManagementService getDeviceManageService() {
		return deviceManageService;
	}

	public void setDeviceManageService(DeviceManagementService deviceManageService) {
		this.deviceManageService = deviceManageService;
	}

	   @ResponseBody
	    @RequestMapping(value="checkDMDevice",method = RequestMethod.POST)
	    public boolean doAddDevice(@RequestParam String deviceIp){
	        System.out.println("ajax成功");
	        if (deviceManageService.isExistDeviceIp(deviceIp)==true) {
	            System.out.println("该IP已经存在，不能插入");
	            return true;
	        }else {	          
	            return false;
	        }
	    }
	
	@ResponseBody
	@RequestMapping(value="addDMDevice",method = RequestMethod.POST)
	public boolean doAddDevice(@RequestParam String deviceIp,@RequestParam int deviceType,
			@RequestParam String deviceLoc,@RequestParam String deviceDesc,@RequestParam String deviceName){
		System.out.println("ajax成功");
		if (deviceManageService.isExistDeviceIp(deviceIp)==true) {
			System.out.println("该IP已经存在，不能插入");
			return false;
		}else {
			deviceManageService.addDevice(deviceIp, deviceType, deviceLoc, deviceDesc, deviceName);
			System.out.println("添加用户成功");
			return true;
		}
	}
	
	
	
	//获取数量
	@ResponseBody
	@RequestMapping(value="getDMDeviceCount",method = RequestMethod.GET)
	public ArrayList<Integer> showDeviceCount(){
		//自动装包拆包
		long count=deviceManageService.countDevice();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		System.out.println("数据能否返回？");
		System.out.println(list.toString());
		return list;
		
	}
	
	@RequestMapping(value="deviceman",method=RequestMethod.GET)
	public String showTableMessage(HttpServletRequest request,ModelMap map,HttpSession httpSession){
	    String name = (String)httpSession.getAttribute("name");
        if(name == null || name.length() == 0) {
           String token = TokenProcess.getInstance().makeToken();//创建令牌
           request.getSession().setAttribute("login_token", token);  //在服务器使用session保存token(令牌)
            return "login";
        }else {
          map.put("user_name", name);
          List<DeviceManagemnt> list=deviceManageService.getDeviceByPage(1, rows);
          map.addAttribute("device_data", list);
          System.out.println("分页查询初始化成功");
          System.out.println(list.toString());
          return "deviceman";
        }
		
	}
	
	@ResponseBody
	@RequestMapping(value="showDMTabDeviceJson",method=RequestMethod.GET)
	public List<DeviceManagemnt> showUMTabUserJson(@RequestParam int page,HttpServletRequest request,ModelMap map){
		List<DeviceManagemnt> list=deviceManageService.getDeviceByPage(page, rows);
		map.addAttribute("device_data", list);
		System.out.println("分页查询成功");
		System.out.println(list.toString());
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="doDMDelDevice",method=RequestMethod.POST)
	public boolean deleteDMDevice(@RequestParam int deviceid,HttpServletRequest request){
		//这里并不需要判断，设备ID是肯定存在的
		System.out.println("controller:删除设备");
		return deviceManageService.deleteDevice(deviceid);
	}
	
	@ResponseBody
	@RequestMapping(value="doDMAlterDevice",method=RequestMethod.POST)
	public boolean updateDeviceMessage(@RequestParam int id,@RequestParam String ip,@RequestParam int type,@RequestParam String name,@RequestParam String loc,@RequestParam String desc){
		return deviceManageService.update(id, ip, type, name, loc, desc);
	}
	
}
