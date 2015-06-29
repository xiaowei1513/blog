package com.blog.entity;

import java.io.Serializable;

/**
 * @author: huxiaowei183@126.com
 * @version: 1.0
 * @since: JDK 1.6.0_43 文件名称:HomePageMain.java 项目名称:blog 创建时间:2015年6月18日
 *         上午10:00:01 类说明:
 **/
public class Account implements Serializable {
	private static final long serialVersionUID = -7970848646314840509L;

	private Integer accountId;
	private Integer status;
	private String username;
	private String password;
	private String salt;
	private String email;
	private Integer roleId;

	// getter、setter
	
	
	

	@Override
	public String toString() {
		return this.accountId + "#" + this.status + "#" + this.username + "#"
				+ this.password + "#" + this.email + "#" + this.salt + "#"
				+ this.roleId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
