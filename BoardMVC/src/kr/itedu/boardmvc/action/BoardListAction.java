package kr.itedu.boardmvc.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardListService;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 포워드 경로 설정
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);

		// 필요한 데이터 가져오기
		BoardListService service = new BoardListService();
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int pageNum = Utils.getParamInt(request.getParameter("pnum"));
		if (pageNum <= 0) {
			pageNum = 1;
		}
		int viewCnt = Utils.getParamInt(request.getParameter("pcnt"));
		if (viewCnt <= 0) {
			viewCnt = 10;
		}
		ArrayList<BoardVO> data = service.getBoardList(btype, viewCnt, pageNum);
		int pageCnt = (int) Math.ceil(service.getListCount(btype) / (viewCnt * 1.0f));
		
		// request에 값 저장
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardList");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("pcnt", pageCnt);

		return forward;
	}

}
