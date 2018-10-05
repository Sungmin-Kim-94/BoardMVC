<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="detail">
	<div class="board-detail">
		<div class="b-head">
			<div class="b-row">
				<div class="b-col b-id">${data.getBid()}</div>
				<div class="b-col b-title">${data.getBtitle()}</div>
			</div>
		</div>
		<div class="b-body">
			<div class="b-row">
				<div class="b-col b-regdate">작성일 : ${data.getBregdate()}</div>
			</div>
			<div class="b-row">
				<div class="b-col b-content">${data.getBcontent()}</div>
			</div>
		</div>
	</div>

	<div class="bottom">
		<form action="boardUpdate.bo" method="get">
			<input type="hidden" name="btype" value="${btype}" />
			<input type="hidden" name="bid" value="${data.getBid()}" />
			<button type="submit">글 수정</button>
		</form>
		
		<form action="boardDelete.bo" method="post">
			<input type="hidden" name="btype" value="${btype}" />
			<input type="hidden" name="bid" value="${data.getBid()}" />
			<button type="submit">글 삭제</button>
		</form>
	</div>
</div>