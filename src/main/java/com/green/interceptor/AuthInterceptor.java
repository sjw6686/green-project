package com.green.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// prehandle(), posthandle()
public class AuthInterceptor extends HandlerInterceptorAdapter {
	
	// preHandle() : controller 보다 먼저 실행되는 메소드
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
			throws Exception {
		
		// session 객체를 가져옴
		HttpSession  session = request.getSession();
		// login 처리를 담장하는 사용자 정보를 담고 있는 객체를 가져옴
		
		// 애러 : 리디렉션횟수가 너무 많습니다 방지 목적
		
		//--------------------------------------------
		// exclude-mapping 대신에 오쳥된 URL 체크해서
		String  requestUrl = request.getRequestURL().toString();
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>requestUrl: " + requestUrl);
		// 하단의 Url 체크를 통해, login 페이지는 예외처리를
		//    해주어야만 무한 리디렉션을 벗어날 수 있다.
		if(requestUrl.contains("/user")) {
			return true;
		}
		else if(requestUrl.contains("/loginProcess")) {
			return true;
		}
		else if(requestUrl.contains("/signUp")) {
			return true;
		}
		else if(requestUrl.contains("/signUpProcess")) {
			return true;
		}
		//-------------------------------------------------
		
		Object obj = session.getAttribute("login");
		if (obj == null ) {
			// 로그인 되어있지 않다면 /login으로 이동하시오
			response.sendRedirect("/login");
			return false; // 더이상 컨트롤러 요청으로 가지 않도록 false를 반환함
		}
		
		return super.preHandle(request, response, handler);
		
		// preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 
		//  허가하는 의미임
        // 따라서 true로하면 컨트롤러 uri로 가게 됨.
        //return true;
	}

	// postHandle() : controller가 실행되고 화면이 보여지기 
	//                직전에 수행되는 메소트
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}


}











