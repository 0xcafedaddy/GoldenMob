package com.mkit.website.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;



public class SecurityInterceptor implements HandlerInterceptor {
	private static final Logger logger = Logger.getLogger(SecurityInterceptor.class);
	private static final String[] excludeUrls = {"logout","login","index","welcome"};
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUrl = request.getRequestURI();
//		if(logger.isDebugEnabled()){
//			logger.debug("验证请求:[" + requestUrl + "]!" );
//		}
//		
//		HttpSession session  = request.getSession();
//		if(session.getAttribute(Constant.SESSION_USER) == null) {
//			if(logger.isDebugEnabled()){
//				logger.debug("拦截非法请求:[" + requestUrl + "]!" );
//			}
//			throw new AuthorizationException();
//		} else {
//			//不做拦截的请求
//			for (String  excludeUrl: excludeUrls) {
//				if(requestUrl.indexOf(excludeUrl)!=-1){
//					return true;
//				}
//			}
////			if(logger.isDebugEnabled()){
////				logger.debug("拦截非法请求:[" + requestUrl + "]!" );
////			}
			
			return true;
//		}
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

}
