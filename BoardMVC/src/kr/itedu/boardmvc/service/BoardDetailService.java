package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardDetailService {
	public BoardVO getBoard(int btype, int bid) {
		BoardVO result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoard(btype, bid);
		return result;
	}
}
