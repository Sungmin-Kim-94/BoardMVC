<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
	<c:choose>
		<c:when test="${!empty data}">
			<div class="board-list">
				<div class="b-head">
					<div class="b-row">
						<div class="b-col b-id">번호</div>
						<div class="b-col b-title">제목</div>
						<div class="b-col b-regdate">작성일</div>
					</div>
				</div>
				<div class="b-body">
					<c:forEach items="${data}" var="vo">
						<div class="b-row">
							<div class="b-col b-id">${vo.getBid()}</div>
							<div class="b-col b-title">
								<a href="boardDetail.bo?btype=${btype}&bid=${vo.getBid()}">
									${vo.getBtitle()} </a>
							</div>
							<div class="b-col b-regdate">${vo.getBregdate()}</div>
						</div>
					</c:forEach>
				</div>
				<div class="b-foot">
					<ul class="b-paging">
						<c:forEach begin="1" end="${pcnt}" step="1" varStatus="status">
							<c:choose>
								<c:when test="${param.pnum == status.count}">
									<li class="pg-item active">
										<a href="boardList.bo?btype=${btype}&pnum=${status.count}">
											${status.count} </a>
									</li>
								</c:when>
								<c:otherwise>
									<li class="pg-item">
										<a href="boardList.bo?btype=${btype}&pnum=${status.count}">
											${status.count} </a>
									</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</ul>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div class="alert alert-info alert-dismissible">
				<button type="button" class="close" data-dismiss="alert">&times;</button>
				<strong>알림</strong>
				게시글이 하나도 없습니다!
			</div>
		</c:otherwise>
	</c:choose>

	<div class="bottom">
		<a href="boardInsert.bo?btype=${btype}">
			<button>글쓰기</button>
		</a>
	</div>
</div>







