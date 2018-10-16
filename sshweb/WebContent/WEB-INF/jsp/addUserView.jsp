<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>添加新用户</h4>
	<form:form action="${pageContext.request.contextPath}/user" method="post" modelAttribute="user">
		<!-- path 相当于普通 form 标签里 name 和 id 的结合体 -->
		用户名：<form:input path="username" /><form:errors path="username"/><br><br>
		密码：<form:input path="password"/><form:errors path="password"/><br><br>
		生日：<form:input path="birthday" /><form:errors path="birthday"/><br><br>
		身高：<form:input path="height" /><form:errors path="height"/><br><br>
		邮箱：<form:input path="email" /><form:errors path="email"/><br><br>
		所属部门：<form:select path="dpt.id" itemValue="id" itemLabel="dptName" items="${dpts}"/>
				<form:errors path="dpt"/><br><br>
		<input type="submit" value="确认添加"><br><br>
	</form:form>

 	
 	<form action="${pageContext.request.contextPath }/users">
 		<input type="submit" value="返回">
 	</form>
 	<br><br>
</body>
</html>