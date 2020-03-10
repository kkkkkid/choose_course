package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.pojo.DownFile;


//创建一个文件的上传和下载控制类
@Controller
public class FileController {
	
	//创建一个文件的上传控制类
	@RequestMapping("upload")
	public String upload(String upname,MultipartFile file,HttpServletRequest req
			) throws IOException{
		//使用SpringMVC中提供的一个机制 MultipartResovler
		String filename=file.getOriginalFilename();//获取文件名
		System.out.println(filename);
		//拆分上传的文件名 (文件名 ,文件的后缀)
		//获取后缀
		String suffix=filename.substring(filename.lastIndexOf("."));
		System.out.println(suffix);
		
		//上传另存文件
		String path = req.getServletContext().getRealPath("file");
		File saveFile=new File(path+"/"+filename);
		System.out.println(path+"\\"+filename);
		FileUtils.copyInputStreamToFile
			(file.getInputStream(), saveFile);
		
		return "file.jsp";
		
	}
	
	
	
	
	
	
	
	
	
	//创建一个文件下载的列表
	@RequestMapping("listfile")
	public String listFile(HttpServletRequest req){
		ArrayList<DownFile> list=new ArrayList<DownFile>();
		//定位到下载文件的存储位置 
		String path = req.getServletContext().getRealPath("file");
		//收集该文件夹下的文件信息
		File dir=new File(path);
		File[] f = dir.listFiles();
		//迭代的获取该文件下的内容
		for (File file : f) {
			//获取具体的改文件信息
		DownFile df=new DownFile(file);	
		list.add(df);
		}
		req.setAttribute("list", list);
		return "file.jsp";
		
	}
	
	//创建的一个文件的下载类
	@RequestMapping("download")
	/**
	 * 如果在编写文件下载操作时,则不能进行控制器的跳转,因为下载操作采用2进制的流方式
	 */
	public void download(String filename ,HttpServletResponse res,HttpServletRequest req) throws IOException{
		//在response中设置请求的响应头
		/**
		 * attachment:以附件的方式进行下载
		 * filename:下载时默认的文件名
		 */
		res.setHeader("Content-Disposition", "attachment;filename="+filename);//从服务器端向客户端发送文件的默认文件名
		//文件的下载 采用2进制
		ServletOutputStream os = res.getOutputStream();
		//定位文件的位置 获取服务端的位置
		String path = req.getServletContext().getRealPath("file");
		System.out.println(path);
		//把要下载的文件定位
		File file=new File(path, filename);
		//读取和输出的操作
		byte bytes[]=FileUtils.readFileToByteArray(file);
		os.write(bytes);
		os.flush();
		os.close();
		
	}

}
