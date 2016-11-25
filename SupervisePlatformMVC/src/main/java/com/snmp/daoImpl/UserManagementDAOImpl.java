package com.snmp.daoImpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.snmp.beans.UserManagement;
import com.snmp.dao.UserManagementDAOI;

@Repository("UserManagementDAOI")
public class UserManagementDAOImpl extends BaseDAOImpl<UserManagement> implements UserManagementDAOI {
    
    public long getUserCountDao(int userid) {
        String hql = "select count(UserManId) from ESM_UserManagement_d where UserManId <>" + userid;
        return super.count(hql);
    }

    public long doLoginDao(List<Object> param) {
        String hql = "select count(UserManId) from ESM_UserManagement_d where UserManName = ? and UserManPwd = ?";
        return super.count(hql, param);
    }
    
    
    public long checkUserDao(List<Object> param) {
        String hql = "select count(UserManId) from ESM_UserManagement_d where UserManName = ?";
        return super.count(hql, param);
    }
    
    public int alterUserDao(UserManagement user) {
        String hql = "update  ESM_UserManagement_d set UserManName='"+user.getUserManName()+"',UserManEmail='"+user.getUserManEmail()
        +"',UserManTag="+user.getUserManTag()+" where UserManId="+user.getUserManId();
        return super.executeHql(hql);
        
    }
    
    public int delUserDao(UserManagement user) {
        String hql = "delete from  ESM_UserManagement_d where UserManId="+user.getUserManId();
        return super.executeHql(hql);
    }
    
    public List<UserManagement> getUsermanagementListDao(int page, int rows,int userid) {
        String hql = "select UserManId,UserManName,UserManType,UserManEmail,UserManTag from ESM_UserManagement_d where UserManId <> "+userid+" order by UserManId desc";
        List<UserManagement> list = super.find(hql, page, rows);
        return list;
    }
    public List<UserManagement> getUserListDaoByname(String name) {
        String hql = "select UserManId,UserManName,UserManEmail,UserManTag from ESM_UserManagement_d where UserManName = '" + name +"'";
        return super.find(hql);
        
    }
    
    public List<UserManagement> getUserIdByname(String name) {
        String hql = "from ESM_UserManagement_d where UserManName = '" + name +"'";
        return super.find(hql);
        
    }
    public int updatePwdDao(String name,String pwd)  {
        String hql = "update ESM_UserManagement_d set UserManPwd = '" +  pwd +"'where UserManName = '" + name + "'";
        return super.executeHql(hql);
    }
    
    
    
    }
