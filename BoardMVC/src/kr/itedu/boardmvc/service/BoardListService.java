package kr.itedu.boardmvc.service;

import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;
import kr.itedu.boardmvc.common.BoardDAO;

/**
 * BoardList 비즈니스 로직을 구현하는 Service 클래스
 * 
 * @author USER
 *
 */
public class BoardListService {
	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardList(btype);
		return result;
	}

	public ArrayList<BoardVO> getBoardList(int btype, int viewCnt, int pageNum) {
		ArrayList<BoardVO> result = null;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getBoardList(btype, viewCnt, pageNum);
		return result;
	}

	public int getListCount(int btype) {
		int result = 0;
		BoardDAO dao = BoardDAO.getInstance();
		result = dao.getListCount(btype);
		return result;
	}
}
