package com.blog.common.tools; 

import java.util.List;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.blog.entity.TableContent;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * 文件名称:HomePageMain.java
 * 项目名称:blog  
 * 创建时间: 2015/06/27 21:05
 * 类说明: 数据库操作简单封装.
 **/
@Component
public class DataSourseTool {
	
	@Resource
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("all")
	public <T> List<T> queryAll(Class clazz){
        Session session = sessionFactory.getCurrentSession();
        Criteria criteria=session.createCriteria(clazz);
        List<T> list = criteria.list();
		return list;
	}
}
