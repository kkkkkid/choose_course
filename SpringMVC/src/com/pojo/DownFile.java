package com.pojo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class DownFile { //自定义一个文件下载的包装类
	
	private String filename;//文件名
	private String fileSize;//文件大小
	
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
