package kr.itedu.boardmvc;

public class CommentVO {
	private int cid = 0;
	private int bid = 0;
	private int btype = 0;
	private String ccontent = "";
	private String cregdate = "";

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCregdate() {
		return cregdate;
	}

	public void setCregdate(String cregdate) {
		this.cregdate = cregdate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" CID : ").append(getCid()).append("\n");
		sb.append(" BID : ").append(getBid()).append("\n");
		sb.append(" BTYPE : ").append(getBtype()).append("\n");
		sb.append(" CCONTENT : ").append(getCcontent()).append("\n");
		sb.append(" CREGDATE : ").append(getCregdate()).append("\n\n");

		return sb.toString();
	}
}
