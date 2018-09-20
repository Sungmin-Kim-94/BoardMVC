package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.common.BoardDAO;

public class BoardDeleteService {

	public int boardDelete(int btype, int bid) {
		int result = -1;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.boardDelete(btype, bid);
		System.out.println(result);
		return result;
	}
	
}
