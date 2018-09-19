package kr.itedu.boardmvc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;
import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.Utils;
import kr.itedu.boardmvc.common.Var;
import kr.itedu.boardmvc.service.BoardInsertService;

public class BoardInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ActionForward forward = new ActionForward();
		
		int btype = Utils.getParamInt(request.getParameter("btype"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		if (btitle != null && bcontent != null) {
			BoardVO data = new BoardVO();
			data.setBtitle(btitle);
			data.setBcontent(bcontent);
			System.out.println(data);
			BoardInsertService service = new BoardInsertService();
			service.boardInsert(btype, data);
			
			forward.setPath("boardList.bo?btype=" + btype);
			forward.setRedirect(true);
		} else {
			request.setAttribute("title", Var.TITLES[btype]);
			request.setAttribute("content", "boardInsert");
			request.setAttribute("btype", btype);
			
			forward.setPath(Var.TEMPLATE_1);
		}
		
		return forward;
	}

}
