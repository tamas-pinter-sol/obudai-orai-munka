<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<head>
<title></title>
</head>
<body>
	<jsp:useBean id="book" scope="request"
		class="hu.sol.kvki.book.bean.Book" />
	<form action="book_edit" method="post">
		<table border="1">
			<tr>
				<td>Könyv azonosítója</td>
				<td><input type="text" name="id"
					value="<jsp:getProperty property="id" name="book" />" /></td>
			</tr>
			<tr>
				<td>A könyv címe</td>
				<td><input type="text" name="name"
					value="<jsp:getProperty property="name" name="book" />" /></td>
			</tr>
			<tr>
				<td>Leírás</td>
				<td><input type="text" name="desc"
					value="<jsp:getProperty property="desc" name="book" />" /></td>
			</tr>
			<tr>
				<td>Szerző</td>
				<td><input type="text" name="author"
					value="<jsp:getProperty property="author" name="book" /> " /></td>
			</tr>
			<tr>
				<td>Kiadás éve</td>
				<td><input type="text" name="pubYear"
					value="<jsp:getProperty property="pubYear" name="book" />" /></td>
			</tr>
		</table>
		<input type="submit">
	</form>
</body>
</html>