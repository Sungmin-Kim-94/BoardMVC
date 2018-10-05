package kr.itedu.boardmvc.common;

import static kr.itedu.boardmvc.common.DBConnector.close;
import static kr.itedu.boardmvc.common.DBConnector.getConn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

import kr.itedu.boardmvc.BoardVO;

/**
 * Data Access Object
 * <p>
 * 데이터에 접근하기위한 오브젝트
 * </p>
 */
public class BoardDAO {
	private static BoardDAO dao;

	private BoardDAO() {
	}

	/**
	 * 싱글톤 패턴
	 * <p>
	 * 사용법 :
	 * 
	 * <pre>
	 * BoardDAO dao = BoardDAO.getInstance();
	 * </pre>
	 * </p>
	 * 
	 * @return BoardDAO 객체
	 */
	public static BoardDAO getInstance() {
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}
	
	public int getListCount(int btype) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		StringBuffer query = new StringBuffer();
		query.append("\n SELECT ");
		query.append("\n     COUNT(BID) AS COUNT ");
		query.append("\n FROM T_BOARD").append(btype);
		
		try {
			con = getConn();
			ps = con.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				result = rs.getInt("COUNT");
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println(query.toString());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: SQLException 예외 처리
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: Exception 예외 처리
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		return result;
	}
	
	/**
	 * 
	 * @param btype 테이블 번호
	 * @param pageCnt 한 페이지당 보여지는 게시글 수
	 * @param pageNum 페이지 번호
	 * @return
	 */
	public ArrayList<BoardVO> getBoardList(int btype, int viewCnt, int pageNum) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int maxPageNum = viewCnt * pageNum;
		int minPageNum = 1 + ((pageNum - 1) * viewCnt);
		
		StringBuffer subQuery1 = new StringBuffer();
		subQuery1.append("\n SELECT ");
		subQuery1.append("\n     BID, ");
		subQuery1.append("\n     BTITLE, ");
		subQuery1.append("\n     BREGDATE ");
		subQuery1.append("\n FROM T_BOARD").append(btype);
		subQuery1.append("\n ORDER BY BID DESC ");
		
		StringBuffer subQuery2 = new StringBuffer();
		subQuery2.append("\n SELECT ");
		subQuery2.append("\n     ROWNUM AS RNUM, ");
		subQuery2.append("\n     Z.* ");
		subQuery2.append("\n FROM ( ").append(subQuery1).append(") Z ");
		subQuery2.append("\n WHERE ROWNUM <= ").append(maxPageNum);
		
		StringBuffer query = new StringBuffer();
		query.append("\n SELECT ");
		query.append("\n     * ");
		query.append("\n FROM ( ").append(subQuery2).append(") ");
		query.append("\n WHERE RNUM >= ").append(minPageNum);
		
		try {
			con = getConn();
			ps = con.prepareStatement(query.toString());
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int bid = rs.getInt("BID");
				String btitle = rs.getString("BTITLE");
				String bregdate = rs.getString("BREGDATE");

				BoardVO vo = new BoardVO();
				vo.setBid(bid);
				vo.setBtitle(btitle);
				vo.setBregdate(bregdate);
				result.add(vo);
			}
		} catch (SQLSyntaxErrorException e) {
			System.out.println(subQuery1.toString() + "\n");
			System.out.println(subQuery2.toString() + "\n");
			System.out.println(query.toString());
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: SQLException 예외 처리
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: Exception 예외 처리
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		
		return result;
	}

	public ArrayList<BoardVO> getBoardList(int btype) {
		ArrayList<BoardVO> result = new ArrayList<BoardVO>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConn();
			String query = String.format("" + " SELECT" + " 	BID," + "		BTITLE,"
					+ "		TO_CHAR(BREGDATE, 'YYYY-MM-DD HH24:MI') AS BREGDATE" + " FROM T_BOARD%d "
					+ " ORDER BY BID DESC ", btype);
			ps = con.prepareStatement(query);
			rs = ps.executeQuery();
			while (rs.next()) {
				int bid = rs.getInt("BID");
				String btitle = rs.getString("BTITLE");
				String bregdate = rs.getString("BREGDATE");

				BoardVO vo = new BoardVO();
				vo.setBid(bid);
				vo.setBtitle(btitle);
				vo.setBregdate(bregdate);
				result.add(vo);
			}
		} catch (SQLException e) {
			// TODO: SQLException 예외 처리
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: Exception 예외 처리
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}

		return result;
	}

	public BoardVO getBoard(int btype, int bid) {
		BoardVO result = new BoardVO();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConn();
			String query = String.format("" + " SELECT" + " 	BID," + "		BTITLE," + "		BCONTENT, "
					+ "		TO_CHAR(BREGDATE, 'YYYY-MM-DD HH24:MI') AS BREGDATE" + " FROM T_BOARD%d "
					+ " WHERE BID = ? " + " ORDER BY BID DESC ", btype);
			ps = con.prepareStatement(query);
			ps.setInt(1, bid);
			rs = ps.executeQuery();

			while (rs.next()) {
				result.setBid(rs.getInt("BID"));
				result.setBtitle(rs.getString("BTITLE"));
				result.setBcontent(rs.getString("BCONTENT"));
				result.setBregdate(rs.getString("BREGDATE"));
			}
		} catch (SQLException e) {
			// TODO: SQLException 예외 처리
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: Exception 예외 처리
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}

		return result;
	}

	public int boardUpdate(int btype, BoardVO data) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			String query = String.format(""
					+ " UPDATE T_BOARD%d "
					+ " SET BTITLE = ?, "
					+ " 	BCONTENT = ?, "
					+ "		BREGDATE = SYSDATE "
					+ " WHERE BID = ? ", btype);
			
			ps = con.prepareStatement(query);
			ps.setString(1, data.getBtitle());
			ps.setString(2, data.getBcontent());
			ps.setInt(3, data.getBid());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: SQLException 예외 처리
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: Exception 예외 처리
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		
		return result;
	}

	public int boardInsert(int btype, BoardVO data) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			String query = String.format(""
					+ " INSERT INTO T_BOARD%d "
					+ " (BID, BTITLE, BCONTENT, BREGDATE) "
					+ " VALUES "
					+ " ((SELECT NVL(MAX(BID), 0) + 1 AS BID FROM T_BOARD%d), ?, ?, SYSDATE) ", btype, btype);
			
			ps = con.prepareStatement(query);
			ps.setString(1, data.getBtitle());
			ps.setString(2, data.getBcontent());
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: SQLException 예외 처리
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: Exception 예외 처리
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		
		return result;
	}

	public int boardDelete(int btype, int bid) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			con = getConn();
			String query = String.format(""
					+ " DELETE FROM T_BOARD%d ", btype);
			
			if (bid > 0) {
				query += " WHERE BID = ? ";
			}
			ps = con.prepareStatement(query);
			if (bid > 0) {
				ps.setInt(1, bid);
			}
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: SQLException 예외 처리
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: Exception 예외 처리
			e.printStackTrace();
		} finally {
			close(con, ps, null);
		}
		
		return result;
	}

}
