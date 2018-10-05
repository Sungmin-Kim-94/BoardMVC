package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.close;
import static kr.itedu.boardmvc.common.DBConnector.getConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

import kr.itedu.boardmvc.CommentVO;

public class CommentDAO {
	private static CommentDAO dao;

	private CommentDAO() {
	}

	/**
	 * 싱글톤 패턴
	 * <p>
	 * 사용법 :
	 * 
	 * <pre>
	 * CommentDAO dao = CommentDAO.getInstance();
	 * </pre>
	 * </p>
	 * 
	 * @return CommentDAO 객체
	 */
	public static CommentDAO getInstance() {
		if (dao == null) {
			dao = new CommentDAO();
		}
		return dao;
	}
	
	public ArrayList<CommentVO> getCommentList(int btype, int bid) {
		System.out.println("CommentDAO.getCommentList()");
		ArrayList<CommentVO> result = new ArrayList<CommentVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		StringBuffer query = new StringBuffer();
		query.append("\n SELECT ");
		query.append("\n     CID, ");
		query.append("\n     CCONTENT, ");
		query.append("\n     CREGDATE ");
		query.append("\n FROM T_COMMENT ");
		query.append("\n WHERE BTYPE = ? ");
		query.append("\n AND BID = ? ");
		query.append("\n ORDER BY CID DESC");
		
		try {
			con = getConn();
			ps = con.prepareStatement(query.toString());
			ps.setInt(1, btype);
			ps.setInt(2, bid);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int cid = rs.getInt("CID");
				String ccontent = rs.getString("CCONTENT");
				String cregdate = rs.getString("CREGDATE");
				
				CommentVO vo = new CommentVO();
				vo.setCid(cid);
				vo.setCcontent(ccontent);
				vo.setCregdate(cregdate);
				result.add(vo);
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println(query.toString());
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		return result;
	}
}
