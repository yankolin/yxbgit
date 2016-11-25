package com.snmp.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.User;
import com.snmp.dao.UserDAOI;
import com.snmp.service.UserServiceI;

//启用事务机制

@Service("userService")
public class UserServiceImpl implements UserServiceI {

/*
 * 	@Resource
	private UserDAOI userDAOI;//UserDAOImpl userDaoImpl;

	@Transactional
	public User registerUser(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userDAOI.saveUser(user);
		return user;
	}
		private static final Log logger = LogFactory.getLog(UserServiceImpl.class);

	
	@Transactional
	public User doLogin(String username, String passwrod) throws Exception{
	//	log.warn("begin this time ");
		
		if (username == null || "".equals(username)) {
			throw new Exception("用户名不能为空");
		}
		if (passwrod == null || "".equals(passwrod)) {
			throw new Exception("密码不能为空");
		}				
		User userPara = new User();
		userPara.setUsername(username);
		User user = userDAOI.findByUsername(userPara);
		if (user == null) {
			throw new Exception("用户名不存在");
		}		
		if (!user.getPassword().equals(passwrod)) {
			//result = "密码错误";//
			throw new Exception("密码错误");
		}		
		logger.info(user+"test it");
		
		return user;		
	}

	
	public User deleteByusername(String username) {
		User user = new User();
		user.setUsername(username);
		User userId = userDAOI.findByUsername(user);
		userDAOI.deleteByID(userId);
		return user;
	}
	
	public User updatePass(String username,String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userDAOI.update(user);
		return user;
	}
	
	public User selectByusername(String username) {
		User user = new User();
		user.setUsername(username);
		userDAOI.listUserByusername(user);
		return user;
	}
	
	public List<User> listUserByUsername(String username) {
		
		User user = new User();
		user.setUsername(username);
		List<User> list = userDAOI.listUserByusername(user);
		return list;
	}*/
}
	