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
import com.snmp.serviceImpl.SystemLogServiceImpl;
@Controller
@SessionAttributes("SystemLog")
public class SystemLogController {
	
	@Resource
	SystemLogServiceImpl service;
	
	int rows = 50;
	
	@RequestMapping(value="systemloginfo",method = RequestMethod.GET)
	public String showsystemlogInfo(@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getSystemLogList(page, rows);
		map.addAttribute("systemloginfo_data", list);
		return "systemlog";
	}
	
	@ResponseBody
	@RequestMapping(value="systemlogInfocount",method = RequestMethod.GET)
	public ArrayList<Integer> showsystemlogInfoCount() {
		long count = service.getSystemLogCount();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showsystemlogInfoJson",method = RequestMethod.GET)
	public List<String>  showsystemlogInfoJson(@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getSystemLogList(page, rows);
		
		
		
		map.addAttribute("systemlogInfo_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getsystemlogInfocount_both",method = RequestMethod.GET)
	public ArrayList<Integer> showsystemlogInfoCount(@RequestParam String name,@RequestParam String date) {
		long count = service.getSystemLogListCount(name, date);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showsystemlogInfoJson_both",method = RequestMethod.GET)
	public List<String>  showsystemlogInfoJson(@RequestParam int page,@RequestParam String name,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getSystemLogList(page, rows, name, date);
		
		
		
		map.addAttribute("systemlogInfo_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getsystemlogInfocount_name",method = RequestMethod.GET)
	public ArrayList<Integer> showsystemlogInfoCount_name(@RequestParam String name) {
		long count = service.getSystemLogListCount_name(name);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showsystemlogInfoJson_name",method = RequestMethod.GET)
	public List<String>  showsystemlogInfoJson_name(@RequestParam int page,@RequestParam String name,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getSystemLogList_name(page, rows, name);
		
		
		
		map.addAttribute("systemlogInfo_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getsystemlogInfocount_date",method = RequestMethod.GET)
	public ArrayList<Integer> showsystemlogInfoCount_date(@RequestParam String date) {
		long count = service.getSystemLogListCount_date(date);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="showsystemlogInfoJson_date",method = RequestMethod.GET)
	public List<String>  showsystemlogInfoJson_date(@RequestParam int page,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getSystemLogList_date(page, rows, date);
		
		
		
		map.addAttribute("systemlogInfo_data", list);
		return list;
	}
	@ResponseBody
	@RequestMapping(value="showsystemlogInfoJson_sid",method = RequestMethod.GET)
	public List<String>  showsystemlogInfoJson_sid(@RequestParam int sid,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getSystemLogList_sid(sid);
		
		
		
		map.addAttribute("systemlogInfo_data", list);
		return list;
	}

}
