/**
 * 
 */
package org.siyuyan.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author shenbaise(shenbaise1001@126.com)
 * @date 2012-5-2
 * TODO	设置全局responses对象属性
 */
public class MonitorInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
//		response.setHeader( "Cache-Control" , "no-cache" ); 
//		//Forces caches to obtain a new copy of the page from the origin server 
//		response.setHeader( "Cache-Control" , "no-store" ); 
//		//Directs caches not to store the page under any circumstance 
//		response.setDateHeader( "Expires" , 0); 
//		//Causes the proxy cache to see the page as "stale" 
//		response.setHeader( "Pragma" , "no-cache" );
		return super.preHandle(request, response, handler);
	}
	
}
