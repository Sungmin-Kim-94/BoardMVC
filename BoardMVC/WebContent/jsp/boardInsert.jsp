<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="insert">
	<form action="boardInsert.bo" method="post">
		<input type="text" name="btype" value="${btype}" required />
		<input type="text" name="btitle" value="" maxLength="200" required />
		<textarea name="bcontent" cols="30" rows="10"></textarea>
		<button type="submit">작성 완료</button>
		<button type="reset">초기화</button>
	</form>
</div>