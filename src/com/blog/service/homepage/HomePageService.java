package com.blog.service.homepage;

import java.util.List;

import com.blog.entity.TableContent;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * 文件名称:HomePageMain.java
 * 项目名称:blog  
 * 创建时间:2015年6月18日 上午10:00:01    
 * 类说明:首页服务类,用于生成首页数据.
 **/
public interface HomePageService {

	public  List<TableContent> getHomePageContent();

	public TableContent readByIdAction(Integer id);

}