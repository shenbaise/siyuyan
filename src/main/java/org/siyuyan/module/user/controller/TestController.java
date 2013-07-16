/**
 * 
 */
package org.siyuyan.module.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.siyuyan.core.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author whiteme
 * controller测试
 */
@Controller("testController")
@RequestMapping(value="test")
public class TestController extends BaseController {
	
	@RequestMapping(value="{id}/say",method=RequestMethod.GET)
	public String batchDel(@PathVariable String msg,HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println(msg);
		request.setAttribute("msg", msg);
		return "../test";
	}
	
	@RequestMapping(value="hi",method=RequestMethod.GET)
	public String batchDel(HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("h打发对对对打发ello");
		return "test";
	}
	
	@RequestMapping(value="me",method=RequestMethod.GET)
	public String batchDeld(String s, HttpServletRequest request,HttpServletResponse response) throws Exception{
		System.out.println("h打发对对对打发ello");
		System.out.println(request.getParameter("s"));
		return "test";
	}
}
