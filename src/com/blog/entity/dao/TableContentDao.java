package com.blog.entity.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.blog.entity.TableContent;

/**
 * @author: huxiaowei183@126.com
 * @version: 1.0
 * @since: JDK 1.6.0_43 文件名称:HomePageMain.java 项目名称:blog 创建时间: 类说明:
 *         数据表TABLE_CONTENT操作类.
 **/
@Component
@SuppressWarnings("all")
public class TableContentDao {

	@Resource
	private SessionFactory sessionFactory;

	private Session session;

	/**
	 * 查询全部的内容
	 * @return
	 */
	public List<TableContent> queryAll() {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TableContent.class);
		return criteria.list();
	}
	
	/**
	 * 根据类型查询内容
	 * @return
	 */
	public List<TableContent> queryContentByClassification(String classification) {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TableContent.class);
		criteria.add(Restrictions.eq("classification", classification));
		return criteria.list();
	}

	public TableContent queryContentById(Integer id) {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TableContent.class);
		criteria.add(Restrictions.eq("id", id));
		return (TableContent) criteria.list().get(0);
	}
}
