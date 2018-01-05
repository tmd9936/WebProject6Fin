package com.sc.web5.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	
	@Override
	/**
	 * 이런 (customer/login) 리퀘스트매핑이 있는 함수를 실행시키기 전에 preHandle을 먼저 실행시킴
	 * 컨트롤러의 메서드가 실행되기전에 처리되는 부분 
	 **/
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//로그인이 되어 있는지를 판단
		//세션을 획득
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("id");
		if(loginId == null){
			//로그인이 되어있지 않을 경우에는 로그인 폼으로 이동
			//절대 경로를 구한다.
			String path = request.getContextPath();
			response.sendRedirect(path+"/customer/loginForm");
			//요청했던 주소로 안보내려면 return false을 쓰면 됨
			return false;
		}
		//로그인이 되어 있을 경우에는 원래 요청주소로 이동
		//아래의 함수에서 true를 리턴하고있어서 안 바꿔줘도 상관없음
		return super.preHandle(request, response, handler);
	}
	
}
