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
 * @since: JDK 1.6.0_43 �ļ�����:HomePageMain.java ��Ŀ����:blog ����ʱ��: ��˵��:
 *         ���ݱ�TABLE_CONTENT������.
 **/
@Component
@SuppressWarnings("all")
public class TableContentDao {

	@Resource
	private SessionFactory sessionFactory;

	private Session session;

	/**
	 * ��ѯȫ��������
	 * @return
	 */
	public List<TableContent> queryAll() {
		session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(TableContent.class);
		return criteria.list();
	}
	
	/**
	 * �������Ͳ�ѯ����
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
		if (!criteria.list().isEmpty()){
			return (TableContent) criteria.list().get(0);
		} else {
			return null;
		}
	}
}
