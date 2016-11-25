package com.snmp.daoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.snmp.beans.User;
import com.snmp.dao.UserDAOI;


@Repository("UserDAOI")
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAOI {
	
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		return this.sessionFactory.getCurrentSession();
	}
	private String tableName = "user";
	/**
	 * 进行持久化的方法需要使用@Transcational进行事务管理
	 */
	//@Transactional(readOnly = false,rollbackFor = RuntimeException.class)
	public void saveUser(User user) {
		this.getCurrentSession().save(user);
		
	}


	public void delete(User user) {
		this.getCurrentSession().delete(user);
		
	}
	
	public void deleteByID(User user) {
		  String hqlDelete = "delete from "+tableName+" where id=:id";
	   Query queryDelete = this.getCurrentSession().createQuery(hqlDelete);
	   queryDelete.setParameter("id", user.getId());
	   queryDelete.executeUpdate();
	   
	}
	
	public void update(User user) {
					String hqlUpdate = "update "+tableName+" set password=:password where username=:username";
        Query queryUpdate = this.getCurrentSession().createQuery(hqlUpdate);
        queryUpdate.setParameter("password", user.getPassword());
        queryUpdate.setParameter("username", user.getUsername());
        queryUpdate.executeUpdate();
					
	}
	
	public final User findByUsername(User user) {
		
		 String hql = "from "+tableName+" where username=:username";  
	  Query query = this.getCurrentSession().createQuery(hql);  
	  query.setParameter("username", user.getUsername());
	  query.setMaxResults(1);// 必须在查询之前指定，使其返回单个对象  ,指定返回多少
	  User users = (User) query.uniqueResult();
	  
		return users;
	}
	public List<User> listUserByusername(User user) {
					String hqlUpdate = "select id,username,password from "+tableName+" where username=:username";
        Query querySelect = this.getCurrentSession().createQuery(hqlUpdate);
        querySelect.setParameter("username", user.getUsername());
        //@SuppressWarnings("unchecked")
					List<User> list = (List<User>)querySelect.list();
        return list; 					  
	}
}
