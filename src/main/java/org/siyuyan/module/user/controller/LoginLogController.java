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
 * @author shenbaise(shenbaise1001@126.com)
 * @date 2012-1-13
 * TODO
 */
@Controller("loginLogController")
@RequestMapping(value="logs/loginlog")
public class LoginLogController extends BaseController{
	
	
	/**
	 * 登录日志列表
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="list")
	public String list(Integer currPage,Integer pageSize,HttpServletRequest request,HttpServletResponse response) throws Exception{

		
		return "logs/loginlog/list";
	}
	
	
	/**
	 * 查看页
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="{id}/show",method=RequestMethod.GET)
	public String show(@PathVariable Long id,HttpServletRequest request) throws Exception{
		
			return "redirect:../list.do";
	}
	/**
	 * 删除登录日志
	 * @param id
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="{id}/del",method=RequestMethod.GET)
	public String delss(@PathVariable Long id,HttpServletRequest request) throws Exception{
		
		System.out.println("ll...");
		
		return "redirect:../list.do";
	}
	/**
	 * 批量删除
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="{id}/batchDel",method=RequestMethod.GET)
	public String batchDel(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		return "redirect:../list.do";
	}
	
}
