package kr.itedu.boardmvc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardUpdateService;

public class BoardUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		BoardUpdateService service = new BoardUpdateService();
		BoardVO data = null;
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		int bid = Utils.getParamInt(request.getParameter("bid"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");

		if (btitle != null && bcontent != null) {
			data = new BoardVO();
			data.setBid(bid);
			data.setBtitle(btitle);
			data.setBcontent(bcontent);
			service.boardUpdate(btype, data);
			
			forward.setPath("boardList.bo?btype=" + btype);
			forward.setRedirect(true);
		} else {			
			data = service.getBoard(btype, bid);
			request.setAttribute("title", Var.TITLES[btype]);
			request.setAttribute("content", "boardUpdate");
			request.setAttribute("btype", btype);
			request.setAttribute("data", data);
			
			forward.setPath(Var.TEMPLATE_1);
		}

		return forward;
	}

}
