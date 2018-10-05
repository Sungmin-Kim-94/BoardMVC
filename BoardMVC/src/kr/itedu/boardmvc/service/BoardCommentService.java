package kr.itedu.boardmvc.service;

import java.util.ArrayList;

import kr.itedu.boardmvc.CommentVO;
import kr.itedu.boardmvc.common.CommentDAO;

public class BoardCommentService {
	
	public ArrayList<CommentVO> getCommentList(int btype, int bid) {
		System.out.println("BoardCommentService.getCommentList()");
		ArrayList<CommentVO> result = null;
		CommentDAO dao = CommentDAO.getInstance();
		result = dao.getCommentList(btype, bid);
		return result;
	}
}
