package com.blog.service.classification;

import java.util.List;

import com.blog.entity.TableContent;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * �ļ�����:HomePageMain.java
 * ��Ŀ����:blog  
 * ����ʱ��:  
 * ��˵��:  
 **/
public interface ClassificationService {

	/**
	 * ������ҳ����չʾҳ��
	 * @param classification
	 * @return
	 */
	public abstract List<TableContent> queryContentByClassification(String classification);

	public abstract TableContent readByIdAction(Integer id);

}