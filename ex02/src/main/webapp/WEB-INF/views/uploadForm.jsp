<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<!-- 업로드 시 방식은 무조건 post, enctype 에 multipart/form-data을 항상 입력해줘야 함  -->
	<form action="uploadFormAction" method="post" enctype="multipart/form-data">
		<input type="file" name="uploads" multiple="multiple">
		<button>submit</button>
	</form>

</body>
</html>