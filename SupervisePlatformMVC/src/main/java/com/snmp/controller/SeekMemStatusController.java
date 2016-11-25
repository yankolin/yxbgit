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

import com.snmp.daoImpl.SeekMemStatusDAOImpl;


@Controller
@SessionAttributes("memstatus")
public class SeekMemStatusController {
	@Resource(name="seekmemstatusdaoimpl")
	SeekMemStatusDAOImpl service;
	int rows = 50;
	
	@ResponseBody
	@RequestMapping(value="getSMSQuerycount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableCount(@RequestParam String deviceip) {
		long count = service.getMemStatusListCount(deviceip);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryDrivePastcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableDrivePastCount(@RequestParam String deviceip,@RequestParam String date) {
		long count=0;
		try{
			count = service.getDrivePastListCount(deviceip,date);
		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryDrivePastList",method = RequestMethod.GET)
	public List<String> QueryDrivePastStatus(@RequestParam int page,@RequestParam String deviceip,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemDrivePastStatusList(deviceip,date,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQuery",method = RequestMethod.GET)
	public List<String> QueryMemStatus(@RequestParam String deviceip,@RequestParam int page,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemStatusList(deviceip,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryMdiskTempcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableMdiskTempCount(@RequestParam String deviceip) {
		long count = service.getMemMdiskTempListCount(deviceip);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryMdiskTemp",method = RequestMethod.GET)
	public List<String> QueryMemMdiskTempList(@RequestParam int page,@RequestParam String deviceip,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemMdiskTempStatusList(deviceip,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryMdiskPastcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableMdiskPastCount(@RequestParam String deviceip,@RequestParam String date) {
		long count=0;
		try{
			count = service.getMdiskPastListCount(deviceip,date);
		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryMdiskPastList",method = RequestMethod.GET)
	public List<String> QueryMdiskPastStatus(@RequestParam int page,@RequestParam String deviceip,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemMdiskPastStatusList(deviceip,date,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryVdiskTempcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableVdiskTempCount(@RequestParam String deviceip) {
		long count = service.getMemVdiskTempListCount(deviceip);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryVdiskTemp",method = RequestMethod.GET)
	public List<String> QueryMemVdiskTempList(@RequestParam int page,@RequestParam String deviceip,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemVdiskTempStatusList(deviceip,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryVdiskPastcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableVdiskPastCount(@RequestParam String deviceip,@RequestParam String date) {
		long count=0;
		try{
			count = service.getVdiskPastListCount(deviceip,date);
		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryVdiskPastList",method = RequestMethod.GET)
	public List<String> QueryVdiskPastStatus(@RequestParam int page,@RequestParam String deviceip,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemVdiskPastStatusList(deviceip,date,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryHostTempcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableHostTempCount(@RequestParam String deviceip) {
		long count = service.getMemHostTempListCount(deviceip);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryHostTemp",method = RequestMethod.GET)
	public List<String> QueryMemHostTempList(@RequestParam int page,@RequestParam String deviceip,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemHostTempStatusList(deviceip,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryHostPastcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableHostPastCount(@RequestParam String deviceip,@RequestParam String date) {
		long count=0;
		try{
			count = service.getHostPastListCount(deviceip,date);
		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryHostPastList",method = RequestMethod.GET)
	public List<String> QueryHostPastStatus(@RequestParam int page,@RequestParam String deviceip,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemHostPastStatusList(deviceip,date,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryEnclosureTempcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableEnclosureTempCount(@RequestParam String deviceip) {
		long count = service.getMemEnclosureTempListCount(deviceip);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryEnclosureTemp",method = RequestMethod.GET)
	public List<String> QueryMemEnclosureTempList(@RequestParam int page,@RequestParam String deviceip,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemEnclosureTempStatusList(deviceip,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryEnclosurePastcount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableEnclosurePastCount(@RequestParam String deviceip,@RequestParam String date) {
		long count=0;
		try{
			count = service.getEnclosurePastListCount(deviceip,date);
		}
		catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQueryEnclosurePastList",method = RequestMethod.GET)
	public List<String> QueryEnclosurePastStatus(@RequestParam int page,@RequestParam String deviceip,@RequestParam String date,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemEnclosurePastStatusList(deviceip,date,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	

	@ResponseBody
	@RequestMapping(value="getSMSQuerySystemInfocount",method = RequestMethod.GET)
	public ArrayList<Integer> showTableSystemInfoTempCount(@RequestParam String deviceip) {
		long count = service.getMemSystemInfoTempListCount(deviceip);
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add((int)count);
		list.add(rows);
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value="getSMSQuerySystemInfo",method = RequestMethod.GET)
	public List<String> QueryMemSystemInfoTempList(@RequestParam int page,@RequestParam String deviceip,HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getMemSystemInfoTempStatusList(deviceip,page,rows);
		map.addAttribute("memstatus_data", list);
		return list;
	}
	
	
	@RequestMapping(value="seekmemstatus",method = RequestMethod.GET)
	public String toDeviceManPage(HttpServletRequest request,ModelMap map) {
		List<String> list  = service.getDefaultIp();
		map.addAttribute("DefaultIp", list);
	return "seekmemstatus";
	}
	/*
	@RequestMapping("seekmemstatus")
	public String toDeviceManPage(HttpServletRequest request,ModelMap map){
		List<String>  defaultip=service.getDefaultIp();
		map.addAttribute("DefaultIp",defaultip);
		return "seekmemstatus";
	}*/
	
}
