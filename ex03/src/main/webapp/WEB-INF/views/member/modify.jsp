<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@include file="../board/includes/header.jsp"%>

	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">회원 정보 수정</h1>
		</div>
		<!-- col-lg-12  -->
	</div>
	<!-- /.row  -->

	<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">회원 정보 수정</div>
				<!-- /.panel-heading  -->
				<div class="panel-body">
					<form action="/member/modify" id="frm" role="form" method="post">
					<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }">
						<input type="hidden" name="addr" id="addr" value="${member.addr }">
						<input type="hidden" name="zipNo" id="zipNo" value="${member.zipNo }">
						<input type="hidden" name="userid" id="userid" value="${member.userid }">
						 
						<div class="form-group">
							<label>ID</label> <input class="form-control" type="text"
								id="idView" disabled="disabled" value="${member.userid }">
						</div>
						<div class="form-group">
							<label>PASSWORD</label> <input type="password" name="userpw"
								id="userpw" class="form-control">
						</div>
						<div class="form-group">
							<label>PASSWORD 확인</label> <input type="password" id="pwdcheck"
								class="form-control">
						</div>
						<div class="form-group">
							<label>이름</label> <input class="form-control" type="text"
								name="username" id="username" value="${member.username }">
						</div>
						<div class="form-group">
							<label>우편번호</label> <input
								class="input-group-prepend form-control" type="text"
								id="zipNoView" disabled="disabled" value="${member.zipNo }">
						</div>
						<div class="form-group">
							<label>주소</label> <input class="input-group-prepend form-control"
								type="text" id="addrView" disabled="disabled" value="${member.addr }">
						</div>
						<div class="form-group">
							<label>회원 권한</label>
							<label class="radio-inline">
								<input type="radio" checked="checked" name="auth" value="ROLE_ADMIN">관리자						
							</label>
							<label class="radio-inline">
								<input type="radio" name="auth" value="ROLE_MEMBER">멤버						
							</label>
							<label class="radio-inline">
								<input type="radio" name="auth" value="ROLE_USERT">유저												
							</label>					
						</div>
						<button type="button" id="addrBtn" onclick="javascript:goPopup()"
							class="btn btn-default">주소 검색</button>
						<br> <br>
						<button type="button" id="submitBtn" class="btn btn-default">입력</button>
						<button type="button" id="deleteBtn" class="btn btn-default">회원 탈퇴</button>
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

<script type="text/javascript">
	$(function() {
		$("#submitBtn").click(function() {
			if ($("#userpw").val() == "") {
				alert("패스워드를 입력해주세요");
				return false;
			}
			if ($("#pwdcheck").val() == "") {
				alert("패스워드 확인을 입력해주세요");
				return false;
			}
			if ($("#username").val() == "") {
				alert("이름을 입력해주세요");
				return false;
			}
			if ($("#addr").val() == "") {
				alert("주소를 입력해주세요");
				return false;
			}
			if ($("#userpw").val() != $("#pwdcheck").val()) {
				alert("패스워드가 틀립니다");
				return false;
			}
			alert("회원 정보 수정이 완료 되었습니다!");
			$("#frm").submit();
		})

		$("#deleteBtn").click(function(){
			var id = "${member.userid}";
			if(confirm("정말 탈퇴하시겠습니까?")){
				alert("탈퇴가 완료되었습니다");
				location.href="/member/delete?id="+id;
				}

			})
	})

	function goPopup() {
		// 주소검색을 수행할 팝업 페이지를 호출합니다.
		// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
		var pop = window.open("/member/popup", "pop",
				"width=570,height=420, scrollbars=yes, resizable=yes");

		// 모바일 웹인 경우, 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrMobileLinkUrl.do)를 호출하게 됩니다.
		//var pop = window.open("/popup/jusoPopup.jsp","pop","scrollbars=yes, resizable=yes"); 
	}

	function jusoCallBack(roadFullAddr, roadAddrPart1, addrDetail,
			roadAddrPart2, engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,
			detBdNmList, bdNm, bdKdcd, siNm, sggNm, emdNm, liNm, rn, udrtYn,
			buldMnnm, buldSlno, mtYn, lnbrMnnm, lnbrSlno, emdNo) {
		// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
		$("#addr").val(roadFullAddr);
		$("#addrView").val(roadFullAddr);
		$("#zipNo").val(zipNo);
		$("#zipNoView").val(zipNo);
	}
</script>


<%@include file="../board/includes/footer.jsp"%>

