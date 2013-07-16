/**
 * 
 */
package org.siyuyan.core;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.siyuyan.utils.ApplicationContextHolder;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author shenbaise(shenbaise1001@126.com)
 * @date 2012-2-10
 * TODO 在容器启动时启动Mina Socket服务
 */
public class ContainerStartListener implements ServletContextListener{

	public void contextDestroyed(ServletContextEvent arg0) {
	}


	public void contextInitialized(ServletContextEvent arg0) {
		//创建一个ApplicationContext保存到SpringContexHolder中
		ApplicationContext appcontext = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());  
		ApplicationContextHolder aHolder = new ApplicationContextHolder();
		aHolder.setApplicationContext(appcontext);
	}

}
