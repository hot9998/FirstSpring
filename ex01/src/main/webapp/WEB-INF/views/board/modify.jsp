<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="includes/header.jsp"%>
<div id="page-wrapper">
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
					<form action="/board/modify" id="frm" role="form" method="post">
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
								name="writer" id="writer" value="${board.writer }">
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
						
						
						<button type="submit" data-oper="modify" class="btn btn-default">수정하기</button>
						<button type="submit" data-oper="remove" class="btn btn-default">삭제하기</button>
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
				self.location = "/";
				return;
			}
			formObj.submit();
		})
	})
</script>

</body>
<%@include file="includes/footer.jsp"%>
