package com.blog.common.tools; 

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Random;

import org.springframework.stereotype.Component;

/** 
 * @author: huxiaowei183@126.com  
 * @version: 1.0   
 * @since: JDK 1.6.0_43 
 * 文件名称:HomePageMain.java
 * 项目名称:blog  
 * 创建时间:2015年6月18日 上午10:00:01    
 * 类说明:  
 **/
@Component
public class ReadFileTool  {
	/**
	 * 缓冲区大小
	 */
	private static int BLOCK = 1024*10;
	
	/**缓冲区*/
	//private static ByteBuffer buffer = ByteBuffer.allocate(BLOCK);

	/**字符编码*/
	private static String GB2312 = "GB2312";

	/**系统文件分割符*/
	private static String FILESEPARATOR = File.separator;
	
	private static int MINLENGTH = 100;
	
	/**文件路径*/
	private static String CONTENTPATH = Thread.currentThread()
			.getContextClassLoader().getResource("").getPath()
			+ FILESEPARATOR
			+ "com"
			+ FILESEPARATOR
			+ "blog"
			+ FILESEPARATOR
			+ "entity"
			+ FILESEPARATOR
			+ "content"
			+ FILESEPARATOR
			+ "file"
			+ FILESEPARATOR;

	/**
	 * 读取文件简介
	 * @param filepath
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("all")
	public static String readSummary(String filepath) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(BLOCK);
		FileInputStream stream = new FileInputStream(CONTENTPATH+filepath);
		FileChannel channel = stream.getChannel();
		channel.read(buffer);
		byte[] bytes = buffer.array();
		Random random = new Random();
		String content = new String(bytes, GB2312).substring(0, random.nextInt(10) +MINLENGTH)+"......";
		channel.close();
		return content;
	}
	
	/**
	 * 读取全部内容
	 * @param filepath
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("all")
	public static String readContent(String filepath) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(BLOCK);
		FileInputStream stream = new FileInputStream(CONTENTPATH+filepath);
		FileChannel channel = stream.getChannel();
		channel.read(buffer);
		byte[] bytes = buffer.array();
		String content = new String(bytes, GB2312);
		channel.close();
		return content;
	}
}
