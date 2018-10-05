<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="update">
	<form action="boardUpdate.bo" method="post">
		<div class="board-update">
			<input type="hidden" name="btype" value="${btype}" required />
			<div class="b-head">
				<div class="b-row">
					<div class="b-col b-id">
					<input type="hidden" name="bid"  value="${data.getBid()}" />
					${data.getBid()}
					</div>
					<div class="b-col b-title">
						<input type="text" name="btitle" value="${data.getBtitle()}"
							maxLength="45" required />
					</div>
				</div>
			</div>
			<div class="b-body">
				<div class="b-row">
					<div class="b-col b-content">
						<textarea name="bcontent">${data.getBcontent()}</textarea>
					</div>
				</div>
			</div>
		</div>

		<div class="bottom">
			<button type="submit">수정 완료</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</div>