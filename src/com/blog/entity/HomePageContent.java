package com.blog.entity; 

import java.io.Serializable;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * 文件名称:HomePageMain.java
 * 项目名称:blog  
 * 创建时间:2015年6月18日 上午10:00:01    
 * 类说明: 显示主题内容主要，显示日志简介。
 **/
public class HomePageContent implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6370483870678383656L;
	
	/**
	 * 文章标题
	 */
	private String title;
	
	/**
	 * 位置作者
	 */
	private String author;
	
	/**
	 * 文章简介
	 */
	private String summary;
	
	/**
	 * 创作时间
	 */
	private String date;
	
	/**
	 * 图片位置
	 */
	private String imagePath;
	
	/**
	 * 阅读次数
	 */
	private Integer readCount;
	
	/**
	 * 分类
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
