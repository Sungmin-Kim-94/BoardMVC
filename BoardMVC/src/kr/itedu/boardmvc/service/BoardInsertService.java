package kr.itedu.boardmvc.service;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

public class BoardInsertService {
	public int boardInsert(int btype, BoardVO data) {
		int result = -1;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.boardInsert(btype, data);
		System.out.println(result);
		return result;
	}
}
