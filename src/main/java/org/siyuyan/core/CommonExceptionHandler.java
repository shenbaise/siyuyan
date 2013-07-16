package org.siyuyan.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author shenbaise(shenbaise1001@126.com)
 * @date 2012-1-18
 * TODO 全局异常捕获处理，避免在Controller中判断跳转。。。
 */
public class CommonExceptionHandler implements HandlerExceptionResolver{
	private static Logger logger = Logger.getLogger(CommonExceptionHandler.class);
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception exception) {
		ModelAndView failModelAndView = new ModelAndView(BaseController.COMMON_FAIL_PAGE);
		
		if(exception instanceof MessageAlertable){
			failModelAndView.addObject(BaseController.COMMON_FAIL_ALERT_KEY, exception.getMessage());
		}else{
			failModelAndView.addObject(BaseController.COMMON_FAIL_ALERT_KEY, "系统异常处理");
		}
		
		exception.printStackTrace();
		return failModelAndView;
	}
}
