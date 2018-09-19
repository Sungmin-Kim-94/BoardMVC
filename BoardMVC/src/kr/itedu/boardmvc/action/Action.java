package kr.itedu.boardmvc.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.itedu.boardmvc.ActionForward;

public interface Action {
	ActionForward execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException;
}
