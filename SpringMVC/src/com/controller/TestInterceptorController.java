package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestInterceptorController {
	//创建的一个控制器
	@RequestMapping("InterceptorDemo")
	public String testInterceptor(Model model){
		
		System.out.println("控制器的执行");
		model.addAttribute("word", "测试的语句");
		//map方式的
		//出现一个错误
		//int num = 45/0;
		
		return "index1.jsp";
		
	}

}
