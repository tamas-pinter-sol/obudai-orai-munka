<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello �budai!<br/>
	Adja meg a nevet
	<input type="text" id="name">
	<a onclick="navigate()">Hello Servlet megnyit�sa</a>
	<script>
		function navigate(){
			var value = document.getElementById('name').value;
			window.location.href = "helloServlet?name=" + value;
		}
	</script>
</body>
</html>