package com.blog.controller.homepage;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.entity.TableContent;
import com.blog.service.homepage.HomePageService;

/**
 * @author: huxiaowei183@126.com
 * @version: 1.0
 * @since: JDK 1.6.0_43 �ļ�����:HomePageMain.java ��Ŀ����:blog ����ʱ��:2015��6��18��*����10:00:01
 * ��˵��: ��ҳ������.
 **/
@Controller
public class HomePageController {

	@Autowired
	private HomePageService serviced;
	
	@RequestMapping(value = "home.summary.action")
	public @ResponseBody List<TableContent> hello(String parameter,HttpServletResponse response) {
		return serviced.getHomePageContent();
	}
}
