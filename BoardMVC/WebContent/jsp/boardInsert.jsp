<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="insert">
	<form action="boardInsert.bo" method="post">
		<div class="board-insert">
			<div class="b-head">
				<div class="b-row">
					<input type="hidden" name="btype" value="${btype}" required />
					<div class="b-col b-title">
						<label for="btitle">제목 : </label>
						<input type="text" id="btitle" name="btitle" value="" maxLength="45" required />
					</div>
				</div>
			</div>
			<div class="b-body">
				<div class="b-row">
					<div class="b-col b-content">
						<textarea name="bcontent"></textarea>
					</div>
				</div>
			</div>
		</div>

		<div class="bottom">
			<button type="submit">작성 완료</button>
			<button type="reset">초기화</button>
		</div>
	</form>
</div>