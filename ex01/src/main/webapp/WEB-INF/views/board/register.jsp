<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="includes/header.jsp"%>
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">글쓰기</h1>
		</div>
		<!-- col-lg-12  -->
	</div>
	<!-- /.row  -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">글쓰기</div>
				<!-- /.panel-heading  -->
				<div class="panel-body">
					<form action="/board/register" id="frm" role="form" method="post">
					<input type="hidden" name="writer" id="writer" value="${member.name }">
					<input type="hidden" name="id" id="id" value="${member.id }">
						<div class="form-group">
							<label>제목</label> <input class="form-control" type="text"
								name="title" id="title">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea class="form-control" rows="3" name="content"
								id="content"></textarea>
						</div>

						<div class="form-group">
							<label>작성자</label> <input class="form-control" type="text"
								id="writerView" disabled="disabled" value="${member.name }">
						</div>
						<button type="button" id="submitBtn" class="btn btn-default">입력</button>
						<button type="reset" class="btn btn-default">리셋</button>
						<a href="/" class="btn btn-default">리스트</a>
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
		$("#submitBtn").click(function() {
			if ($("#title").val() == "") {
				alert("제목을 입력해주세요");
				return false;
			}
			if ($("#content").val() == "") {
				alert("내용을 입력해주세요");
				return false;
			}
			$("#frm").submit();
		})
	})
</script>
</body>
<%@include file="includes/footer.jsp"%>
