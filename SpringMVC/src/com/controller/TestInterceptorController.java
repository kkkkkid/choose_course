package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestInterceptorController {
	//������һ��������
	@RequestMapping("InterceptorDemo")
	public String testInterceptor(Model model){
		
		System.out.println("��������ִ��");
		model.addAttribute("word", "���Ե����");
		//map��ʽ��
		//����һ������
		//int num = 45/0;
		
		return "index1.jsp";
		
	}

}
