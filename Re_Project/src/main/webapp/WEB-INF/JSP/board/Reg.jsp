<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script defer src="${root}/js/jquery-3.1.0.min.js"></script>
<script defer src="${root}/js/ckeditor/ckeditor.js"></script>
</head>

<body>

	<div class="container">
		<div class="row">
			<form method="post" action="boardReg">
				<table class="table table-striped">
					<tr>
						<td>제목</td>
						<td><input type="hidden" name="writer_id"
							value="${sessionScope.name}"> <input type="text"
							class="form-control" placeholder="글 제목" name="title"
							maxlength="50" value="${boardview.title}"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td colspan="3" style="height: 300px; text-align: left"><textarea
								class="form-control" placeholder="글 내용" name="content"
								maxlength="2048" style="height: 350px;">${boardview.content}</textarea>
						</td>
				</table>
				<a class="btn btn-primary" href="boardmain">목록</a>
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기">

			</form>
		</div>
	</div>
<script type="text/javascript">
            $(function(){
               CKEDITOR.replace('content',{
                  filebrowserUploadUrl: 'fileupload'
               });
            });
</script>
</body>
</html>