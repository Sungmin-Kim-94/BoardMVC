package kr.itedu.boardmvc.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.CommentVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardCommentService;
import kr.itedu.boardmvc.service.BoardDetailService;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		forward.setPath(Var.TEMPLATE_1);
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		
		BoardDetailService service = new BoardDetailService();
		BoardVO data = service.getBoard(btype, bid);
		
		BoardCommentService coService = new BoardCommentService();
		ArrayList<CommentVO> coData = coService.getCommentList(btype, bid);
		
		request.setAttribute("title", Var.TITLES[btype]);
		request.setAttribute("content", "boardDetail");
		request.setAttribute("btype", btype);
		request.setAttribute("data", data);
		request.setAttribute("coData", coData);
		
		return forward;
	}
	
}
