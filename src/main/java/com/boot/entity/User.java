package com.boot.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.boot.enumerated.Sex;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7362767290640773824L;
	
	private int id;
	private String name;
	private Sex sex;
	private String mobile;
	private LocalDateTime createTime;
	private LocalDateTime updateTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public LocalDateTime getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
