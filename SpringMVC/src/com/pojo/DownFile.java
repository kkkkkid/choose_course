package com.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DownFile { //�Զ���һ���ļ����صİ�װ��
	
	private String filename;//�ļ���
	private String fileSize;//�ļ���С
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public DownFile() {
		// TODO Auto-generated constructor stub
	}
	public DownFile(File f)  {
		this.filename=f.getName();
		FileInputStream in;
		try {
			in = new FileInputStream(f);
			this.fileSize=in.available()/1024+"k";
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	
}
