package com.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//����һ���Զ����������
public class TestInterceptor2 implements  HandlerInterceptor{
	//������������ִ��ִ��֮ǰ
	/*
	 * true:���ز������,����ִ��
	 * false:������ִ�е�����,����ض���ʹ��res.sendRedirect("");//�ض���
	 * ��Ҫ�����������Ȩ�޵���֤
	 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandle2 ǰ������ִ��");

	
		return true;
	}
	
	//������������ִ��ִ��֮��,returnִ��֮��
	//һ�����������ݵ��滻����
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("postHandle2 ������ִ��֮��");

		
		
	}
	
	@Override

	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("��������afterCompletion2");
	
	}

}
