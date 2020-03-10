package com.controller;

import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestSpringMVC {	//该类是一个普通的Java类 与J2ee的框架不具有耦合性
	@RequestMapping("testSpringMVC")
	//@ResponseBody --使用此标签表示已JSon的方式响应
	//1.SpringMVC中的第一种使用内置对象的方法
	public String test(HttpServletRequest req ,HttpSession sessionParam ){
		System.out.println("测试");
		req.setAttribute("requestKey", "使用request");
		HttpSession session=req.getSession();
	 	session.setAttribute("sessionKey1", "获取session数据");
		sessionParam.setAttribute("sessionKey", "通过注入直接获取session数据");
		ServletContext app=req.getServletContext();
		app.setAttribute("app", "全局变量");
		return "index.jsp";
		
	}
	//2.使用内置对象 携带参数 map方式
	@RequestMapping("testSpringMVC1")
	public String test01(Map<String, Object> map){//map方式的自动注入
		System.out.println("使用Map方式");
		map.put("map", "map携带的参数"); //在默认的情况下 map保存在request中
		return "index.jsp"; //默认情况下 SpringMVC采用的是转发机制
	}
	//3.使用SpringMVC的特有方法 Model接口
	@RequestMapping("testSpringMVC2")
	public String test02( Model model){ //使用SpringMVC的Model接口
		System.out.println("使用Map方式");
		model.addAttribute("model", "model接口的参数的传递");
		return "index.jsp"; 
	}
	//4.使用SpringMVC的ModelAndView
	@RequestMapping("testSpringMVC3")
	public ModelAndView  test03(){
		//创建的一个跳转的视图
		ModelAndView mav=new ModelAndView("/index.jsp");//需要跳转的视图
		//携带参数
		mav.addObject("mav", "ModelView的参数");
		return mav;
		
	}
	}









