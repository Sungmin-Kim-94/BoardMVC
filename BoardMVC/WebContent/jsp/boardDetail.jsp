<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

	<div class="comment">
		<h4>댓글</h4>
		<ul class="c-list">
			<c:forEach items="${coData}" var="vo">
				<li class="c-item">
					<span class="c-content">${vo.getCcontent()}</span>
					<span class="c-regdate">${vo.getCregdate()}</span>
					<a href="">
						<button>삭제</button>
					</a>
				</li>
			</c:forEach>
		</ul>
		<div class="c-insert">
			<form action="" method="post">
				<input type="text" name="ccontent" />
				<button type="submit">작성</button>
			</form>
		</div>
	</div>

</div>