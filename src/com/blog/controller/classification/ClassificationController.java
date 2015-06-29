package com.blog.controller.classification; 

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.TableContent;
import com.blog.service.classification.ClassificationService;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * �ļ�����:HomePageMain.java
 * ��Ŀ����:blog  
 * ����ʱ��:2015��6��27�� 21:00 
 * ��˵��: �����������
 **/
@Controller
public class ClassificationController {
	@Autowired
	private ClassificationService classificationService ;
	
	@RequestMapping(value = "classification.action")
	public @ResponseBody List<TableContent> hello(String classification,HttpServletResponse response) {
		
		return classificationService.queryContentByClassification(classification);
	}
}
