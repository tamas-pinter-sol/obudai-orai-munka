<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<head>
<title></title>
</head>
<body>
	<form action="book_edit" method="post">
		<table border="1">
			<tr>
				<td>Könyv azonosítója</td>
				<td>${book.id}<input type="hidden" name="id" value="${book.id}"/></td>
			</tr>
			<tr>
				<td>A könyv címe</td>
				<td><input type="text" name="name" value="${book.name}" /></td>
			</tr>
			<tr>
				<td>Leírás</td>
				<td><input type="text" name="description" value="${book.description}" /></td>
			</tr>
			<tr>
				<td>Szerző</td>
				<td><input type="text" name="author" value="${book.author}" /></td>
			</tr>
			<tr>
				<td>Kiadás éve</td>
				<td><input type="text" name="pubYear" value="${book.pubYear}" /></td>
			</tr>
		</table>
		<input type="submit">
	</form>
</body>
</html>