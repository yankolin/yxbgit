package com.snmp.beans;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")//实现虚拟化的接口
public class Users implements Serializable {
	
	private static final long serialVersionUID = 2323873459032234232L;


	public Users(){
		super();
	}
	
	public Users(String user_name, Integer age, String nice_name) {
		super();
		this.user_name = user_name;
		this.age = age;
		this.nice_name = nice_name;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)//自增
	@Column(name="id")
	private Integer id;
	
	@Column(name="user_name",length=32)
	private String user_name;
	
	@Column(name="age")
	private Integer age;
	
	@Column(name="nice_name",length=32)
	private String nice_name;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getNice_name() {
		return nice_name;
	}

	public void setNice_name(String nice_name) {
		this.nice_name = nice_name;
	}
	

}
