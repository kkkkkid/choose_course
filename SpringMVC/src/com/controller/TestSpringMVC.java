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
public class TestSpringMVC {	//������һ����ͨ��Java�� ��J2ee�Ŀ�ܲ����������
	@RequestMapping("testSpringMVC")
	//@ResponseBody --ʹ�ô˱�ǩ��ʾ��JSon�ķ�ʽ��Ӧ
	//1.SpringMVC�еĵ�һ��ʹ�����ö���ķ���
	public String test(HttpServletRequest req ,HttpSession sessionParam ){
		System.out.println("����");
		req.setAttribute("requestKey", "ʹ��request");
		HttpSession session=req.getSession();
	 	session.setAttribute("sessionKey1", "��ȡsession����");
		sessionParam.setAttribute("sessionKey", "ͨ��ע��ֱ�ӻ�ȡsession����");
		ServletContext app=req.getServletContext();
		app.setAttribute("app", "ȫ�ֱ���");
		return "index.jsp";
		
	}
	//2.ʹ�����ö��� Я������ map��ʽ
	@RequestMapping("testSpringMVC1")
	public String test01(Map<String, Object> map){//map��ʽ���Զ�ע��
		System.out.println("ʹ��Map��ʽ");
		map.put("map", "mapЯ���Ĳ���"); //��Ĭ�ϵ������ map������request��
		return "index.jsp"; //Ĭ������� SpringMVC���õ���ת������
	}
	//3.ʹ��SpringMVC�����з��� Model�ӿ�
	@RequestMapping("testSpringMVC2")
	public String test02( Model model){ //ʹ��SpringMVC��Model�ӿ�
		System.out.println("ʹ��Map��ʽ");
		model.addAttribute("model", "model�ӿڵĲ����Ĵ���");
		return "index.jsp"; 
	}
	//4.ʹ��SpringMVC��ModelAndView
	@RequestMapping("testSpringMVC3")
	public ModelAndView  test03(){
		//������һ����ת����ͼ
		ModelAndView mav=new ModelAndView("/index.jsp");//��Ҫ��ת����ͼ
		//Я������
		mav.addObject("mav", "ModelView�Ĳ���");
		return mav;
		
	}
	}









