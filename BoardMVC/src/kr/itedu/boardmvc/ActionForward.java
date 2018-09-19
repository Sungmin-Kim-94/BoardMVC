package kr.itedu.boardmvc;

public class ActionForward {
	private String path;
	private boolean isRedirect;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}
	/**
	 * redirect 설정
	 * @param isRedirect true면 redirect false면 forward
	 */
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
