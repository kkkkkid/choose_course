<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

	<form action="upload" enctype="multipart/form-data"  method="post"> 
	上传人:<input type="text" name="upname">
	文件:<input type="file" name="file"><br>
	<input type="submit" value="文件上传">
	</form>




	<a href="listfile">查询可下载的文件</a>
	<br>
	<c:forEach items="${requestScope.list}" var="df" >
		  ${df.filename }                 ${df.fileSize } 
		   <a href="download?filename=${df.filename }"> 下载</a>
		  <br>
		  
	</c:forEach>
	
	
</body>
</html>
