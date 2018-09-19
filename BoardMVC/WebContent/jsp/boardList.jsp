<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${!empty data}">
		<div class="tableContainer">
			<table>
				<thead>
					<tr>
						<th>번호</th>
						<th style="width: 80%;">제목</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${data}" var="vo">
					<tr>
						<td class="txtct">${vo.getBid()}</td>
						<td>
							<a href="boardDetail.bo?btype=${btype}&bid=${vo.getBid()}">${vo.getBtitle()}</a>
						</td>
						<td>${vo.getBregdate()}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</c:when>
	<c:otherwise>
		<h4>게시글이 없습니다.</h4>
	</c:otherwise>
</c:choose>

<div class="bottom">
	<a href="boardInsert.bo?btype=${btype}">
		<button>글쓰기</button>
	</a>
</div>






