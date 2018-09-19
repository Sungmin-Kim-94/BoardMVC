package kr.itedu.boardmvc;

public class BoardVO {
	private int bid, btype;
	private String btitle = "", bcontent = "", bregdate = "";

	public int getBtype() {
		return btype;
	}

	public void setBtype(int btype) {
		this.btype = btype;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	
	public String getBregdate() {
		return bregdate;
	}

	public void setBregdate(String bregdate) {
		this.bregdate = bregdate;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(" BID : ").append(getBid()).append("\n");
		sb.append(" BTITLE : ").append(getBtitle()).append("\n");
		sb.append(" BCONTENT : ").append(getBcontent()).append("\n");
		sb.append(" BREGDATE : ").append(getBregdate()).append("\n\n");

		return sb.toString();
	}

}
