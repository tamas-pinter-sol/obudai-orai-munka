<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="head.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Könyvek listája</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Azonosító</th>
			<th>Könyv címe</th>
			<th>Szerző</th>
			<th>leírás</th>
			<th>kiadás éve</th>
			<th></th>
		</tr>
		<c:forEach items="${books}" var="book">
			<tr>
				<td><c:out value="${book.id}" /></td>
				<td><c:out value="${book.name}" /></td>
				<td><c:out value="${book.author}" /></td>
				<td><c:out value="${book.desc}" /></td>
				<td><c:out value="${book.pubYear}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>