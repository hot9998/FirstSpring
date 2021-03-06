<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<p class="h3">게시물 수 : ${count }</p>
<table class="table small table-bordered my-5">
	<thead>
		<tr>
			<th style="width: 10%">번호</th>
			<th style="width: 40%">제목</th>
			<th style="width: 20%">작성자</th>
			<th style="width: 20%">작성일</th>
			<th style="width: 10%">조회수</th>
		</tr>
	</thead>
	<c:forEach items="${list }" var="list" varStatus="st"> 
		<tr>
			<td>${rowNo-st.index }</td>
			<td><a href='boardView?num=${list.num }'>${list.title }</a></td>
			<td>${list.writer }</td>
			<td>${list.regdate }</td>
			<td>${list.hitcount }</td>
		</tr>
	</c:forEach>
</table>
<div>${pageHtml }</div>

