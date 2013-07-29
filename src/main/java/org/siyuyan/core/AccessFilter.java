package org.siyuyan.core;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.siyuyan.module.web.model.User;

public class AccessFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = ((HttpServletRequest)request);
		String path = req.getServletPath();
		System.out.println("Filter>>"+ path);
		chain.doFilter(request, response);
		User user = (User)req.getSession().getAttribute("userSession");
		request.setAttribute("user", user);
		return;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	

}