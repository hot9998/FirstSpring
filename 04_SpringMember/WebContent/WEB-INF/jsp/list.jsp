<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<table>
	<tr align="center">
		<th>ID</th>
		<th>Name</th>
		<th>Addr</th>
		<th>Memo</th>
		<th>삭제</th>
	</tr>
	<c:forEach items="${userlist }" var="user">
		<tr>
			<td>${user.id }</td>
			<td><a href="member_detail.go?id=${user.id }">${user.name }</a></td>
			<td>${user.addr}</td>
			<td>${user.memo}</td>
			<td><a href="member_delete.go?id=${user.id}">삭제</a></td>
		</tr>
	</c:forEach>
</table>
<a href="member_insert.go">추가하기</a>
</div>

</body>
</html>