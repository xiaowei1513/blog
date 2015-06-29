package com.blog.service.homepage;

import java.util.List;

import com.blog.entity.TableContent;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * �ļ�����:HomePageMain.java
 * ��Ŀ����:blog  
 * ����ʱ��:2015��6��18�� ����10:00:01    
 * ��˵��:��ҳ������,����������ҳ����.
 **/
public interface HomePageService {

	public  List<TableContent> getHomePageContent();

	public TableContent readByIdAction(Integer id);

}