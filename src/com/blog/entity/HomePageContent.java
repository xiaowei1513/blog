package com.blog.entity; 

import java.io.Serializable;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * �ļ�����:HomePageMain.java
 * ��Ŀ����:blog  
 * ����ʱ��:2015��6��18�� ����10:00:01    
 * ��˵��: ��ʾ����������Ҫ����ʾ��־��顣
 **/
public class HomePageContent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6370483870678383656L;
	
	/**
	 * ���±���
	 */
	private String title;
	
	/**
	 * λ������
	 */
	private String author;
	
	/**
	 * ���¼��
	 */
	private String summary;
	
	/**
	 * ����ʱ��
	 */
	private String date;
	
	/**
	 * ͼƬλ��
	 */
	private String imagePath;
	
	/**
	 * �Ķ�����
	 */
	private Integer readCount;
	
	/**
	 * ����
	 */
	private String  assortment;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getAssortment() {
		return assortment;
	}

	public void setAssortment(String assortment) {
		this.assortment = assortment;
	}

	public Integer getReadCount() {
		return readCount;
	}

	public void setReadCount(Integer readCount) {
		this.readCount = readCount;
	}
	
}
