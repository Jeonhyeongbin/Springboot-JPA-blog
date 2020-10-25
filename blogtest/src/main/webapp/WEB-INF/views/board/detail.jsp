<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ include file="../layout/header.jsp" %>

<div class="container">
<button class ="btn btn-secondary" onclick = "history.back()">back</button>
<a href="/board/${board.id}/updateForm" class ="btn btn-warning">update</a>
<c:if test="${board.user.id == principal.user.id}">
<button id = "btn-delete" class ="btn btn-danger">delete</button>
</c:if>
<br/><br/>
<div>
	�� ��ȣ: <span id="id"><i>${board.id}</i></span>
	�ۼ���: <span><i>${board.user.username}</i></span>
</div>
</br>
		<div>
			<h3>${board.title}</h3>
		</div>
		<hr/>
		<div>
		  <div>
		  	${board.content}
		  </div>
		</div>
		<hr/>
</div>


<script src="/js/board.js"></script>
<!--

//-->

<%@ include file="../layout/footer.jsp" %>