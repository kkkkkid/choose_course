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


//����һ���ļ����ϴ������ؿ�����
@Controller
public class FileController {
	
	//����һ���ļ����ϴ�������
	@RequestMapping("upload")
	public String upload(String upname,MultipartFile file,HttpServletRequest req
			) throws IOException{
		//ʹ��SpringMVC���ṩ��һ������ MultipartResovler
		String filename=file.getOriginalFilename();//��ȡ�ļ���
		System.out.println(filename);
		//����ϴ����ļ��� (�ļ��� ,�ļ��ĺ�׺)
		//��ȡ��׺
		String suffix=filename.substring(filename.lastIndexOf("."));
		System.out.println(suffix);
		
		//�ϴ�����ļ�
		String path = req.getServletContext().getRealPath("file");
		File saveFile=new File(path+"/"+filename);
		System.out.println(path+"\\"+filename);
		FileUtils.copyInputStreamToFile
			(file.getInputStream(), saveFile);
		
		return "file.jsp";
		
	}
	
	
	
	
	
	
	
	
	
	//����һ���ļ����ص��б�
	@RequestMapping("listfile")
	public String listFile(HttpServletRequest req){
		ArrayList<DownFile> list=new ArrayList<DownFile>();
		//��λ�������ļ��Ĵ洢λ�� 
		String path = req.getServletContext().getRealPath("file");
		//�ռ����ļ����µ��ļ���Ϣ
		File dir=new File(path);
		File[] f = dir.listFiles();
		//�����Ļ�ȡ���ļ��µ�����
		for (File file : f) {
			//��ȡ����ĸ��ļ���Ϣ
		DownFile df=new DownFile(file);	
		list.add(df);
		}
		req.setAttribute("list", list);
		return "file.jsp";
		
	}
	
	//������һ���ļ���������
	@RequestMapping("download")
	/**
	 * ����ڱ�д�ļ����ز���ʱ,���ܽ��п���������ת,��Ϊ���ز�������2���Ƶ�����ʽ
	 */
	public void download(String filename ,HttpServletResponse res,HttpServletRequest req) throws IOException{
		//��response�������������Ӧͷ
		/**
		 * attachment:�Ը����ķ�ʽ��������
		 * filename:����ʱĬ�ϵ��ļ���
		 */
		res.setHeader("Content-Disposition", "attachment;filename="+filename);//�ӷ���������ͻ��˷����ļ���Ĭ���ļ���
		//�ļ������� ����2����
		ServletOutputStream os = res.getOutputStream();
		//��λ�ļ���λ�� ��ȡ����˵�λ��
		String path = req.getServletContext().getRealPath("file");
		System.out.println(path);
		//��Ҫ���ص��ļ���λ
		File file=new File(path, filename);
		//��ȡ������Ĳ���
		byte bytes[]=FileUtils.readFileToByteArray(file);
		os.write(bytes);
		os.flush();
		os.close();
		
	}

}
