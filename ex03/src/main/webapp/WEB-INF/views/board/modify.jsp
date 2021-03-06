<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@include file="includes/header.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">글 수정</h1>
		</div>
		<!-- col-lg-12  -->
	</div>
	<!-- /.row  -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">글 수정</div>
				<!-- /.panel-heading  -->
				<div class="panel-body">
					<form action="/board/modify" role="form" method="post">
						<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
						<input type="hidden" name="writer" id="writer" value=${board.writer } >
						<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>' >
						<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>' >
						<input type="hidden" name="type" value='<c:out value="${cri.type }"/>' >
						<input type="hidden" name="keyword" value='<c:out value="${cri.keyword }"/>' >
						<input type="hidden" name="bno" value="${board.bno }">
						
						
						<div class="form-group">
							<label>제목</label> <input class="form-control" type="text"
								name="title" id="title" value="${board.title }">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3" name="content"
								id="content">${board.content }</textarea>
						</div>

						<div class="form-group">
							<label>작성자</label> <input class="form-control" type="text"
								id="writerView" value="${board.writer }" disabled="disabled" readonly="readonly">
						</div>
						
						<div class="form-group hidden">
							<label>RegDate</label>
							<input class="form-control" name='regDate'
							value='<fmt:formatDate pattern = "yyyy/MM/dd" value= "${board.regdate }" />' readonly="readonly">
						</div>
						
						<div class="form-group hidden">
							<label>Update Date</label>
							<input class="form-control" name='updateDate'
							value='<fmt:formatDate pattern = "yyyy/MM/dd" value= "${board.updateDate}" />' readonly="readonly">
						</div>
						
						<sec:authentication property="principal" var="pinfo"/>
						<sec:authorize access="isAuthenticated()">
						<c:if test="${pinfo.username eq board.writer }">
						<button type="submit" data-oper="modify" class="btn btn-default">수정하기</button>
						<button type="submit" data-oper="remove" class="btn btn-default">삭제하기</button>
						</c:if>
						</sec:authorize>						
						<button type="submit" data-oper="list" class="btn btn-default">리스트</button>
					</form>

				</div>
				<!-- end panel-body  -->
			</div>
			<!-- end panel  -->
		</div>
	</div>
	<!-- ./row  -->
</div>
<!-- ./page-wrapper  -->
<script type="text/javascript">
	$(function() {
		var formObj = $("form");

		$('button').on("click", function(e) {
			e.preventDefault();

			var operation = $(this).data("oper");

			console.log(operation);			

			if (operation === 'remove') {
				formObj.attr("action", "/board/remove");
			} else if (operation === 'list') {
				formObj.attr("action", "/board/list").attr("method","get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				var keywordTag = $("input[name='keyword']").clone();
				var typeTag = $("input[name='type']").clone();

				formObj.empty();
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				formObj.append(keywordTag);
				formObj.append(typeTag);
			}
			formObj.submit();
		})
	})
</script>

</body>
<%@include file="includes/footer.jsp"%>
