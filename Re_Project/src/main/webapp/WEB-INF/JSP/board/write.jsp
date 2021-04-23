<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<script src="js/ckeditor/ckeditor.js"></script>

<script>
window.onload=function() {
	CKEDITOR.replace('brdmemo', {'filebrowserUploadUrl':'upload4ckeditor'});
}


</script>

<title>글쓰기</title>
</head>
<body>
	<jsp:include page="../common/navigation.jsp" />

	<div class="row">
		<form id="form1" name="form1" role="form" action="boardSave" method="post" enctype="multipart/form-data" onsubmit="return fn_formSubmit();">
			<div>
				<div>
					<div>
						<label><s:message code="board.title" /></label>
						<div>
							<input type="text" id="brdtitle" name="brdtitle" size="70"
								maxlength="250" value="<c:out value="${boardInfo.brdtitle}"/>">
							<c:if test="${bgInfo.bgnotice=='Y'}">
								<label> <input type="checkbox" name="brdnotice"
									value="Y"
									<c:if test="${boardInfo.brdnotice=='Y'}">checked="checked"</c:if> />
									공지사항
								</label>
							</c:if>
						</div>
					</div>
					<div class="row form-group">
						<label><s:message code="board.contents" /></label>
						<div>
							<textarea id="brdmemo" name="brdmemo" class="form-control" rows="10" cols="60"><c:out
									value="${boardInfo.brdmemo}" /></textarea>
						</div>
					</div>
					<div>
						<label><s:message code="board.file" /></label>
						<div>
							<c:forEach var="listview" items="${listview}" varStatus="status">
								<input type="checkbox" name="fileno"
									value="<c:out value="${listview.fileno}"/>">
								<a href="fileDownload?filename=<c:out value="${listview.filename}"/>&downname=<c:out value="${listview.realname }"/>">
									<c:out value="${listview.filename}" />
								</a>
								<c:out value="${listview.size2String()}" />
								<br />
							</c:forEach>

							<input type="file" name="uploadfile" multiple="multiple" />
						</div>
					</div>
				</div>
			</div>
			<button>
				<s:message code="common.btnSave" />
			</button>
			<input type="hidden" name="bgno" value="<c:out value="${bgno}"/>">
			<input type="hidden" name="brdno"
				value="<c:out value="${boardInfo.brdno}"/>">
		</form>
	</div>
</html>
