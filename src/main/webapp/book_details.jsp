<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Könyv adatai</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>Könyv azonosítója</td>
			<td><c:out value="${book.id}"/></td>
		</tr>
		<tr>
			<td>A könyv címe</td>
			<td><c:out value="${book.name}"/></td>
		</tr>
		<tr>
			<td>Leírás</td>
			<td><c:out value="${book.desc}"/></td>
		</tr>
		<tr>
			<td>Szerző</td>
			<td><c:out value="${book.author}"/></td>
		</tr>
		<tr>
			<td>Kiadás éve</td>
			<td><c:out value="${book.pubYear}"/></td>
		</tr>
	</table>
</body>
</html>