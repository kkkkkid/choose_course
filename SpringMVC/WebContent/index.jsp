<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
显示request中的数据 ： ${requestScope.requestKey }<br>
显示session中的数据 ： ${sessionScope.sessionKey1}<br>
显示session中的数据 ： ${sessionScope.sessionKey}<br>
显示application中的数据 ： ${applicationScope.app}<br>
<hr>
显示Map中的数据:<br>
显示request中的map数据 ： ${requestScope.map }<br>
显示session中的map数据 ： ${sessionScope.map}<br>
显示application中的map数据 ： ${applicationScope.map}<br>
<hr>
显示model中的数据:<br>
显示request中的model数据 ： ${requestScope.model}<br>
显示session中的model数据 ： ${sessionScope.model}<br>
显示application中的model数据 ： ${applicationScope.model}<br>
<hr>
显示modelAndView中的数据:<br>
显示request中的modelAndView数据 ： ${requestScope.mav}<br>
显示session中的modelAndView数据 ： ${sessionScope.mav}<br>
显示application中的modelAndView数据 ： ${applicationScope.mav}<br>
</body>
</html>
