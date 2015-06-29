package com.blog.service.homepage; 

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.blog.common.tools.ReadFileTool;
import com.blog.entity.TableContent;
import com.blog.entity.dao.TableContentDao;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * �ļ�����:HomePageMain.java
 * ��Ŀ����:blog  
 * ����ʱ��:2015��6��18�� ����10:00:01    
 * ��˵��:��ҳ������ʵ��,����������ҳ����.
 **/
@Transactional
@Service("homePageService")
public class HomePageServiceImp implements HomePageService {
		
	@Resource
	private TableContentDao tableContentDao;
	
	@Resource
	private ReadFileTool readFileTool;
	/* (non-Javadoc)
	 * @see com.blog.service.homepage.HomePageService#getHomePageContent()
	 */
	@Override
	@SuppressWarnings("all")
	public List<TableContent> getHomePageContent() {
		List<TableContent> contents = tableContentDao.queryAll();
		List<TableContent> returnList = new ArrayList<TableContent>();
		try {
			readFileTool.readSummary("10111.txt");
			for (TableContent content : contents) {
				content.setContent(readFileTool.readSummary(content	.getFileName()));
				returnList.add(content);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return returnList;
	}
}
