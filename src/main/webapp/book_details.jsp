<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<head>
<title></title>
</head>
<body>
	<jsp:useBean id="book" scope="request"
		class="hu.sol.kvki.book.bean.Book" />
	<table border="1">
		<tr>
			<td>Könyv azonosítója</td>
			<td><jsp:getProperty property="id" name="book" /></td>
		</tr>
		<tr>
			<td>A könyv címe</td>
			<td><jsp:getProperty property="name" name="book" /></td>
		</tr>
		<tr>
			<td>Leírás</td>
			<td><jsp:getProperty property="desc" name="book" /></td>
		</tr>
		<tr>
			<td>Szerző</td>
			<td><jsp:getProperty property="author" name="book" /></td>
		</tr>
		<tr>
			<td>Kiadás éve</td>
			<td><jsp:getProperty property="pubYear" name="book" /></td>
		</tr>
	</table>
	<a href="book_list">Vissza a könyvekhez</a>
</body>
</html>