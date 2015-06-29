package com.blog.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * @author: huxiaowei183@126.com
 * @version: 1.0
 * @since: JDK 1.6.0_43 文件名称:HomePageMain.java 项目名称:blog
 *         创建时间:2015年6月18日*上午10:00:01 
 *         类说明: The persistent class for the table_content database table..
 **/

@Entity
@Table(name = "TABLE_CONTENT")
public class TableContent implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "AUTHOR")
	private String author;

	@Column(name = "CLASSIFICATION")
	private String classification;

	@Column(name = "FILE_NAME")
	private String fileName;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATE_DATE")
	private Date createDate;

	@Column(name = "IMAGE")
	private String image;

	@Column(name = "READ")
	private int read;

	@Column(name = "TITLE")
	private String title;
	
	@Transient
	private String content;

	public TableContent() {

	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getClassification() {
		return this.classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getRead() {
		return this.read;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setRead(int read) {
		this.read = read;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
}