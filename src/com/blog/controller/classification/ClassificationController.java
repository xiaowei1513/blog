package com.blog.controller.classification; 

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.TableContent;
import com.blog.service.classification.ClassificationService;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * 文件名称:HomePageMain.java
 * 项目名称:blog  
 * 创建时间:2015年6月27日 21:00 
 * 类说明: 点击导航分类
 **/
@Controller
public class ClassificationController {
	@Autowired
	private ClassificationService classificationService ;
	

	
	@RequestMapping(value = "classification.summary.action")
	public @ResponseBody List<TableContent> summaryAction(String classification,HttpServletResponse response) {
		
		return classificationService.queryContentByClassification(classification);
	}

	@RequestMapping(value = "classification.readById.action")
	public @ResponseBody TableContent readByIdAction(@RequestParam("id" ) Integer id,HttpServletResponse response) {
		return classificationService.readByIdAction(id);
	}
}
