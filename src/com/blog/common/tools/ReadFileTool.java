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
 * �ļ�����:HomePageMain.java
 * ��Ŀ����:blog  
 * ����ʱ��:2015��6��18�� ����10:00:01    
 * ��˵��:  
 **/
@Component
public class ReadFileTool  {
	/**
	 * ��������С
	 */
	private static int BLOCK = 1024;
	
	/**������*/
	private static ByteBuffer buffer = ByteBuffer.allocate(BLOCK);

	/**�ַ�����*/
	private static String GB2312 = "GB2312";

	/**ϵͳ�ļ��ָ��*/
	private static String FILESEPARATOR = File.separator;
	
	private static int MINLENGTH = 100;
	
	/**�ļ�·��*/
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
	 * ��ȡ�ļ����
	 * @param filepath
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("all")
	public static String readSummary(String filepath) throws IOException {
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
	 * ��ȡȫ������
	 * @param filepath
	 * @return
	 * @throws IOException 
	 */
	@SuppressWarnings("all")
	public static String readContent(String filepath) throws IOException {
		FileInputStream stream = new FileInputStream(CONTENTPATH+filepath);
		FileChannel channel = stream.getChannel();
		channel.read(buffer);
		byte[] bytes = buffer.array();
		String content = new String(bytes, GB2312);
		channel.close();
		return content;
	}
}
