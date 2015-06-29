package com.blog.entity; 

import java.io.Serializable;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * 文件名称:HomePageMain.java
 * 项目名称:blog  
 * 创建时间:2015年6月18日 上午10:00:01    
 * 类说明: 首页各部分数据来源
 **/
public class HomePage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8014033590587145383L;
	
	private String user;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
