package com.snmp.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.snmp.beans.UserManagement;
import com.snmp.common.CreateMD5;
import com.snmp.dao.UserManagementDAOI;
import com.snmp.service.UserManagementServiceI;

@Service("usermanService")
public class UserManagementServiceImpl implements UserManagementServiceI {

	@Resource
	private UserManagementDAOI userDao;
	private Logger logger = Logger.getLogger(UserManagementServiceImpl.class);

	@Transactional
	public boolean doLogin(String username, String password) {
		logger.warn(username + "()()");

		if (username.replaceAll("[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() != 0) {
			return false;
		}

		String pwd = CreateMD5.getMd5(CreateMD5.getMd5(password));

		List<Object> param = new ArrayList<Object>();
		param.add(username);
		param.add(pwd);
		logger.warn(param.get(0) + "*****");
		long count = userDao.doLoginDao(param);
		logger.warn(count + "&&&&&");
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public boolean checkUser(String name) {

		List<Object> param = new ArrayList<Object>();
		param.add(name);
		long count = userDao.checkUserDao(param);
		if (count == 0) {
			return false;
		} else {
			return true;
		}
	}

	@Transactional
	public UserManagement registerUser(String name, String pwd, String email, int type, int tag) {
		UserManagement user = new UserManagement();

		String pwds = CreateMD5.getMd5(CreateMD5.getMd5(CreateMD5.getMd5(pwd)));
		user.setUserManName(name);
		user.setUserManPwd(pwds);
		user.setUserManEmail(email);
		user.setUserManType(type);
		user.setUserManTag(tag);
		user.setUserManDate(new Date());
		userDao.saveOrUpdate(user);
		return user;
	}

	@Transactional
	public int alterUser(String name, String email, int tag, int id) {
		UserManagement user = new UserManagement();
		user.setUserManId(id);
		user.setUserManEmail(email);
		user.setUserManName(name);
		user.setUserManTag(tag);
		int num = userDao.alterUserDao(user);
		return num;
	}

	@Transactional
	public int delUser(int id) {

		UserManagement user = new UserManagement();
		user.setUserManId(id);
		int num = userDao.delUserDao(user);
		return num;
	}

	@Transactional
	public List<UserManagement> getUserManagementList(int page, int rows,int userid) {

		return userDao.getUsermanagementListDao(page, rows,userid);
	}

	@Transactional
	public long getUserManagementListCount(int userid) {

		return userDao.getUserCountDao( userid);
	}

	@Transactional
	public List<UserManagement> getUserListByName(String loginName) {
		return userDao.getUserListDaoByname(loginName);
	}

   @Transactional
    public Integer getUserIdByName(String loginName) {
        List<UserManagement> list =  userDao.getUserIdByname(loginName);
        Integer userId =  list.get(0).getUserManId();
        return userId;
    }

	@Transactional
	public int updatePwd(String name, String oldpwd, String newpwd) {
		String oldpwdmd5 = CreateMD5.getMd5(CreateMD5.getMd5(oldpwd));
		String newpwdmd5 = CreateMD5.getMd5(CreateMD5.getMd5(newpwd));
		List<Object> param = new ArrayList<Object>();
		param.add(name);
		param.add(oldpwdmd5);
		long check = userDao.doLoginDao(param);
		System.out.println(check + "********");
		if (check > 0) {
			int num = userDao.updatePwdDao(name, newpwdmd5);
			if (num > 0) {
				return 1;
			} else {
				return 2;
			}
		} else {
			return 0;
		}
	}

}
