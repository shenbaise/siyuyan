/**
 * ########################  SHENBAISE'S WORK  ##########################
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.siyuyan.module.web.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;
import org.apache.commons.lang3.StringUtils;
import org.siyuyan.core.BaseController;
import org.siyuyan.module.web.model.User;
import org.siyuyan.module.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whiteme
 * @date 2013年7月27日
 * @desc 用户登录、注册、注销等
 */
@Controller(value="userController")
public class UserController extends BaseController {
	
	@Autowired
	UserService userService;
	/**
	 * 跳转到登录页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="login")
	public String login() throws Exception{
		
		return "login";
	}
	/**
	 * 跳转到注册页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="register")
	public String register() throws Exception{
		return "register";
	}
	/**
	 * 跳转到重置密码页
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="forgetpwd")
	public String forgetpwd() throws Exception{
		return "forgetpwd";
	}
	/**
	 * 处理用户登录
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="dologin")
	public String doLogin(User user,HttpServletRequest request,HttpServletResponse response) throws Exception{
		// TODO 进行登录认证，记录登录日志（用户、ip、等）
		// 先取cookies
		if(null==user){
			Cookie[] cookies = request.getCookies();
			String email = null,password = null;
			for(Cookie cookie:cookies){
				if("email".equals(cookie.getName())){
					email = cookie.getValue();
				}else if ("password".equals(cookie.getName())) {
					password = cookie.getValue();
				}
			}
			// 创建用户
			user = new User();
			if(StringUtils.isNotBlank(password))
				user.setPassword(password);
			if(StringUtils.isNotBlank(email))
				user.setEmail(email);
		}
		if(null!=(user=userService.login(user))){
			if(user.isRememberMe()){
				// 两周免登录
				Cookie email = new Cookie("email", user.getEmail());
				email.setMaxAge(60 * 60 * 24 * 14);
				Cookie password = new Cookie("password", user.getPassword());
				password.setMaxAge(60 * 60 * 24 * 14);
				response.addCookie(email);
				response.addCookie(password);
			}
			
			request.getSession().setAttribute("userSession", user);
		}else {
			request.setAttribute("msg", "用户名或密码错误");
			return "login";
		}
		return "redirect:/";
	}
	
	@RequestMapping(value="logout")
	public String logout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 清空session
		request.getSession().setAttribute("userSession", null);
		// 清空cookies
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie:cookies){
			cookie.setValue(null);
			response.addCookie(cookie);
		}
		return "redirect:/";
	}
	/**
	 * 用户密码重置（发送重置密码链接到用户邮箱）
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="doresetpasswd")
	public String dorestPasswd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// TODO 重置用户密码 、通过邮箱找回密码
		return "redirect:/";
	}
	@RequestMapping(value="setpasswd")
	public String setpasswd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// TODO 重置用户密码
		return "redirect:/";
	}
	/**
	 * 注册用户
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="doregister")
	public String doregister(User user,HttpServletRequest request,HttpServletResponse response) throws Exception{
		if(!userService.register(user)){
			request.setAttribute("msg", "注册失败");
			return "login";
		}
		
		return "redirect:/";
	}
	/**
	 * 完善用户资料
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="profile")
	public String dopersonalprofile(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		TODO 注册用户资料完善
		return "redirect:/";
	}
	
}
