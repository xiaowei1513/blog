package com.blog.entity;



import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "T_USER")
public class Users implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Users() {
		super();
	}

	@Id
	@Column(name = "id")
	private Integer id;

	@Column(name = "user_name", length = 32)
	private String username;

	@Column(name = "pass_word")
	private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}