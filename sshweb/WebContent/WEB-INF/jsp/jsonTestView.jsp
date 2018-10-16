<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/resouces/js/jq/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#jsonid1").click(function() {
			var href = this.href;
			var args = {};
			//ajax, url:目标地址; args:带出去的参数; data:目标方法的返回值
			$.post(href,args,function(data){
				for(var i=0;i<data.length;i++){
					var userid = data[i].id;
					var username = data[i].username;
					alert(userid+"==="+username);
				} 
			});
			return false;
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		$("#jsonid2").click(function() {
			var href = this.href;
			var args = {};
			//ajax, url:目标地址; args:带出去的参数; data:目标方法的返回值
			$.post(href,args,function(data){
				for(var i=0;i<data.length;i++){
					var userid = data[i].id;
					var username = data[i].username;
					alert(userid+"==="+username);
				} 
			});
			return false;
		});
	});
</script>
</head>
<body>

	<a id="jsonid1" href="${pageContext.request.contextPath }/testjson1">json的数据格式，来获取所有用户信息(老土法)</a>
	<br><br>
	<a id="jsonid2" href="${pageContext.request.contextPath }/testjson2">json的数据格式，来获取所有用户信息(傻瓜法)</a>
	<br><br>
	<form action="${pageContext.request.contextPath }/users">
 		<input type="submit" value="返回">
 	</form>

</body>
</html>