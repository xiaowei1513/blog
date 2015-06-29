package com.blog.service.classification;

import java.util.List;

import com.blog.entity.TableContent;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * 文件名称:HomePageMain.java
 * 项目名称:blog  
 * 创建时间:  
 * 类说明:  
 **/
public interface ClassificationService {

	/**
	 * 根据首页条件展示页面
	 * @param classification
	 * @return
	 */
	public abstract List<TableContent> queryContentByClassification(String classification);

}