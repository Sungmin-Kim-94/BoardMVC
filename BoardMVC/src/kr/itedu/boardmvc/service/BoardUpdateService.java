package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardUpdateService {
	public BoardVO getBoard(int btype, int bid) {
		BoardDetailService detailService = new BoardDetailService();
		return detailService.getBoard(btype, bid);
	}
	
	public int boardUpdate(int btype, BoardVO data) {
		int result = -1;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.boardUpdate(btype, data);
		return result;
	}
}
