package com.blog.entity; 

import java.io.Serializable;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * �ļ�����:HomePageMain.java
 * ��Ŀ����:blog  
 * ����ʱ��:2015��6��18�� ����10:00:01    
 * ��˵��: ��ҳ������������Դ
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
