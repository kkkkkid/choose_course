package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//创建一个自定义的拦截器
public class TestInterceptor2 implements  HandlerInterceptor{
	//拦截器控制器执行执行之前
	/*
	 * true:拦截操作完成,继续执行
	 * false:不符合执行的条件,配合重定向使用res.sendRedirect("");//重定向
	 * 主要的作用是完成权限的验证
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle2 前置拦截执行");

	
		return true;
	}
	
	//拦截器控制器执行执行之后,return执行之后
	//一般可以完成内容的替换操作
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle2 控制器执行之后");

		
		
	}
	
	@Override

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("最终拦截afterCompletion2");
	
	}

}
