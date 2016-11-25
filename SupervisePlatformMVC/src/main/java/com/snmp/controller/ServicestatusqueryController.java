package com.snmp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.snmp.beans.UserManagement;
import com.snmp.daoImpl.ServiceStatusQueryDAOImpl;



@Controller
@SessionAttributes("servicestatus")
public class ServicestatusqueryController {

	@Resource(name="ServiceStatusQueryDAOImpl")
	ServiceStatusQueryDAOImpl service;
	int rows = 50;
	
	@ResponseBody
	@RequestMapping(value="getSSQQuerycount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableCount() {
		long count = service.getServiceStatusListCount();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSSQQuery",method = RequestMethod.GET)
	public List<String>  QueryServiceStatus(@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getServiceStatusList(page,rows);
		map.addAttribute("user_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSSQQueryByIPcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableCountByIP(@RequestParam String deviceip) {
		long count = service.getServiceStatusListCountByIp(deviceip);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSSQQueryByDateRangecount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableCountByDateRange(@RequestParam String date_begin,@RequestParam String date_end) {
		long count = service.getServiceStatusListCountByDateRange(date_begin,date_end);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSSQQueryByMultiplecount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableCountByMultiple(@RequestParam String date_begin,@RequestParam String date_end,@RequestParam String deviceip) {
		long count = service.getServiceStatusListCountByMultiple(deviceip,date_begin,date_end);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSSQQueryByIP",method = RequestMethod.GET)
	public List<String> QueryServiceStatusByIP(@RequestParam String deviceip,@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getServiceStatusListByIp(deviceip,page,rows);
		map.addAttribute("servicestatus_data", list);
		return list;
	}
	
	
	@RequestMapping(value="servicestatusquery",method = RequestMethod.GET)
	public String showTabServiceStatus(@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getServiceStatusTempList(page,rows);
		map.addAttribute("servicestatus_data", list);
	return "servicestatusquery";
	}
	
	@ResponseBody
	@RequestMapping(value="getSSQQueryByDateRange",method = RequestMethod.GET)
	public List<String> QueryServiceStatusByDateRange(@RequestParam String date_begin,@RequestParam String date_end,@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getServiceStatusListByDateRange(date_begin,date_end,page,rows);
		map.addAttribute("servicestatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSSQQueryByMultiple",method = RequestMethod.GET)
	public List<String> QueryServiceStatusByMultiple(@RequestParam String deviceip,@RequestParam String date_begin,@RequestParam String date_end,@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getServiceStatusListByMultiple(deviceip,date_begin,date_end,page,rows);
		map.addAttribute("servicestatus_data", list);
		return list;
	}
}
