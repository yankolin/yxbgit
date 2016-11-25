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


import com.snmp.serviceImpl.PreWarningInfoServiceImpl;


@Controller
@SessionAttributes("PreWarningInfo")//存放对象配合modelmap使用
public class PreWarningInfoController {

	@Resource
	PreWarningInfoServiceImpl service;
	
	int rows = 50;

	//@RequestMapping("prewarninginfo")
	//public String toPrewarningInfoPage(){
	//	return "prewarninginfo";
	//}
	
	@RequestMapping(value="prewarninginfo",method = RequestMethod.GET)
	public String showPreWarningInfo(@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getPrewarningInfoList(page, rows);
		map.addAttribute("PrewarningInfo_data", list);
		return "prewarninginfo";
	}
	
	@ResponseBody
	@RequestMapping(value="getPreWarningInfocount",method = RequestMethod.GET)
	public ArrayList<Integer> showPreWarningInfoCount() {
		long count = service.getPrewarningInfoListCount();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showPreWarningInfoJson",method = RequestMethod.GET)
	public List<String>  showPrewarningInfoJson(@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getPrewarningInfoList(page,rows);
		
		
		
		map.addAttribute("PrewarningInfo_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getPreWarningSearchInfocount",method = RequestMethod.GET)
	public ArrayList<Integer> showPreWarningSearchInfoCount(@RequestParam String ip,@RequestParam String date) {
		long count = service.getPrewarningInfoListCount(ip, date);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showPreWarningSearchInfoJson",method = RequestMethod.GET)
	public List<String>  showPrewarningSearchInfoJson(@RequestParam int page,@RequestParam String ip,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getPrewarningInfoList(page, rows, ip, date);
		
		
		
		map.addAttribute("PrewarningInfo_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getPreWarningSearchInfocount_ip",method = RequestMethod.GET)
	public ArrayList<Integer> showPreWarningSearchInfoCount_ip(@RequestParam String ip) {
		long count = service.getPrewarningInfoListCount_ip(ip);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showPreWarningSearchInfoJson_ip",method = RequestMethod.GET)
	public List<String>  showPrewarningSearchInfoJson_ip(@RequestParam int page,@RequestParam String ip,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getPrewarningInfoList_ip(page, rows, ip);
		
		
		
		map.addAttribute("PrewarningInfo_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getPreWarningSearchInfocount_date",method = RequestMethod.GET)
	public ArrayList<Integer> showPreWarningSearchInfoCount_date(@RequestParam String date) {
		long count = service.getPrewarningInfoListCount_date(date);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showPreWarningSearchInfoJson_date",method = RequestMethod.GET)
	public List<String>  showPrewarningSearchInfoJson_date(@RequestParam int page,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getPrewarningInfoList_date(page, rows, date);
		
		
		
		map.addAttribute("PrewarningInfo_data", list);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showPreWarningInfoJson_pid",method = RequestMethod.GET)
	public List<String>  showPreWarningInfoJson_pid(@RequestParam int pid,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getPrewarningInfoList_pid(pid);
		
		
		
		map.addAttribute("PrewarningInfo_data", list);
		return list;
	}
	
	/*@RequestMapping("test")
	public String test(HttpServletRequest request, ModelMap map) {
		List<String> test_data = new ArrayList<String>();
		System.out.println("hello word");
		test_data.add("Hello world\n");
		test_data.add("hello world again \n");
		map.addAttribute("test_data", test_data);
		//request.setAttribute("test_data", test_data);
		return "PreWarningInfo"; 
	}*/
}
