<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="detail">
	${data.getBid()}
	<br />
	${data.getBtitle()}
	<br />
	${data.getBcontent()}
	<br />
	${data.getBregdate()}
	<a href="boardUpdate.bo?btype=${btype}&bid=${data.getBid()}">
		<button>글 수정</button>
	</a>
	<form action="boardDelete.bo" method="post">
		<input type="hidden" name="btype" value="${btype}" />
		<input type="hidden" name="bid" value="${data.getBid()}" />
		<button type="submit">글 삭제</button>
	</form>

</div>