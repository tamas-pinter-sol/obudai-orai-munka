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
	<button onclick="navigate()">Hello Servlet megnyit�sa</button>
	<script>
		function navigate(){
			var value = document.getElementById('name').value;
			window.location.href = "helloServlet?name=" + value;
		}
	</script>
	<br/>
	<%if(request.isUserInRole("Administrator") || request.isUserInRole("Manager")){ %>
		<a href="helloNames">Nevek List�z�sa</a>
		<br/>
	<%} %>
	<a href="book_list">K�nyv alkalmaz�s</a>
	<br/>
	<a href="logout">Kijelentkez�s</a>
</body>
</html>