<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath %>" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${staff.getStaffName()}
<form action="upload/uploadpicture" method="POST" enctype="multipart/form-data">
	图片:<input type="file" name="photo"/><br>
	<input type="submit" value="上传">
</form>
</body>
</html>