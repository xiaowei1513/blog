package com.blog.service.classification; 

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
 * ����ʱ��:  
 * ��˵��:  
 **/
@Service
@Transactional
@SuppressWarnings("all")
public class ClassificationServiceImpl implements ClassificationService{

	@Resource
	private TableContentDao tableContentDao;
	
	@Resource
	private ReadFileTool readFileTool;
	
	/* (non-Javadoc)
	 * @see com.blog.service.classification.ClassificationService#queryContentByClassification(java.lang.String)
	 */
	@Override
	public  List<TableContent> queryContentByClassification(String classification){

		List<TableContent> contents = tableContentDao.queryContentByClassification(classification);
		List<TableContent> returnList = new ArrayList<TableContent>();
		try {
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
