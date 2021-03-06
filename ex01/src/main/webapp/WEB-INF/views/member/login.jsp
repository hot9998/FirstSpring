<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../board/includes/header.jsp"%>
<script type="text/javascript">
	$(function() {
		$("#loginBtn").click(function() {
			if ($("#id").val() == "") {
				alert("아이디를 입력하세요");
				return false;
			}
			if ($("#password").val() == "") {
				alert("패스워드를 입력하세요");
				return false;
			}
			$.get("/member/loginCheck", {
				"id" : $("#id").val(),
				"password" : $("#password").val()
			}, function(data) {
				if (data == "no") {
					alert("가입되지 않은 아이디 입니다");
					$("#id").val("");
					$("#password").val("");
					return false;
				}
				if (data == "fail") {
					alert("패스워드가 틀렸습니다");
					$("#id").val("");
					$("#password").val("");
					return false;
				}
				if (data == "success") {
					alert("로그인 되었습니다");
					location.href = "/member/login?id="+$("#id").val();
				}
			})

		})

	})
</script>

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">로그인</h1>
		</div>
		<!-- col-lg-12  -->
	</div>
	<!-- /.row  -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">로그인</div>
				<!-- /.panel-heading  -->
				<div class="panel-body">
					<form action="/member/login" id="frm" role="form" method="post">

						<div class="form-group">
							<label>ID</label> <input class="form-control" type="text"
								name="id" id="id">
						</div>

						<div class="form-group">
							<label>PASSWORD</label> <input type="password" name="password"
								id="password" class="form-control">
						</div>
						<button type="button" id="loginBtn" class="btn btn-default">입력</button>
						<button type="reset" class="btn btn-default">리셋</button>
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


<%@include file="../board/includes/footer.jsp"%>