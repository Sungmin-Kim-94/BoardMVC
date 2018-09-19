package kr.itedu.boardmvc.common;

public class Utils {

	/**
	 * 문자열로 된 파라미터를 정수형으로 바꿔줍니다.
	 * @param parameter 문자열로 된 파라미터
	 * @return	정수형으로 바뀐 파라미터. 정수형으로 바뀔 수 없는 파라미터이면 -1을 반환합니다.
	 */
	public static int getParamInt(String parameter) {
		int result = -1;
		if (parameter != null && !parameter.equals("")) {
			try {
				result = Integer.parseInt(parameter);
			} catch (NumberFormatException e) {
				// TODO: NumberFormatException 예외 처리
			} catch (Exception e) {
				// TODO: Exception 예외 처리
			}
		}
		
		return result;
	}

}
