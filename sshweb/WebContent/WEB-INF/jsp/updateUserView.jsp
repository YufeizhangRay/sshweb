<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改用户信息</title>
</head>
<body>

	<h4>修改用户信息</h4>
	<from:form action="${pageContext.request.contextPath}/user" method="put" modelAttribute="user">
		<!-- path 相当于普通 form 标签里 name 和 id 的结合体 -->
		<from:hidden path="id" /><br><br>
		密码：<from:input path="password"/><br><br>
		生日：<from:input path="birthday"/><br><br>
		身高：<from:input path="height"/><br><br>
		邮箱：<from:input path="email"/><br><br>
		部门：<from:select path="dpt.id" itemValue="id" itemLabel="dptName" items="${dpts}"></from:select><br><br>
		<input type="submit" value="修改用户"><br><br>
	</from:form>
	<form action="${pageContext.request.contextPath }/users">
 		<input type="submit" value="返回">
 	</form>
</body>
</html>