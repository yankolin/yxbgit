package com.snmp.dao;


import java.util.List;

import com.snmp.beans.User;


public interface UserDAOI extends BaseDAOI<User>{
			
				/**
				 * User
				 * @param user
				 */
				public void saveUser(User user);
				
				/**
				 * 
				 *按照username删除
				 */
				public void deleteByID(User user);
				
				
				/**
				 * 更新数据
				 * @param username
				 */
				public void update(User user);
				
				/**
				 * 
				 * @param username
				 * @return
				 */
				public User findByUsername(User user);
				
				/**
				 * 
				 * @param username
				 * @return
				 */
				public List<User> listUserByusername(User user);
}
