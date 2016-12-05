<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<head>
<title></title>
</head>
<body>
	<form:form action="book_edit" method="post" acceptCharset="UTF-8" modelAttribute="book">
		<table border="1">
			<tr>
				<td>Könyv azonosítója</td>
				<td>${book.id}<form:hidden path="id"/></td>
			</tr>
			<tr>
				<td>A könyv címe</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Leírás</td>
				<td><form:input path="description" /></td>
			</tr>
			<tr>
				<td>Szerző</td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td>Kiadás éve</td>
				<td><form:input path="pubYear"/></td>
			</tr>
		</table>
		<input type="submit">
	</form:form>
</body>
</html>