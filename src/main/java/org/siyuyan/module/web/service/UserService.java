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
package org.siyuyan.module.web.service;

import java.util.Map;

import javax.xml.transform.Source;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.get.GetResponse;
import org.siyuyan.es.BaseEsDao;
import org.siyuyan.es.Searcher;
import org.siyuyan.module.web.model.User;
import org.siyuyan.utils.EncryptUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * @author whiteme
 * @date 2013年7月28日
 * @desc 用户
 */
@Service(value="userService")
public class UserService {
	
	public static String User = "user";
	public static String type = "0";
	
	private Searcher searcher = new Searcher();
	@Autowired
	private BaseEsDao esDao;
	
	/***
	 * 登录验证
	 * @param user
	 * @return
	 */
	public User login(User user){
		// 登录
		if(null!=user){
			String email = user.getEmail();
			String password = user.getPassword();
			String id = "";
			if(StringUtils.isNotBlank(email)
					&& StringUtils.isNotBlank(password)){
				id = EncryptUtils.encodeMD5(email + password);
			}else {
				return null;
			}
			try {
				GetResponse get = searcher.get(User, type,id);
				if(get.isExists()){
					Map<String, Object> source = get.getSource();
					user = JSON.parseObject(JSON.toJSONString(source), User.class);
				}else {
					return null;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}else {
			return null;
		}
		return user;
	}
	/**
	 * 注册
	 * @param user
	 * @return
	 */
	public boolean register(User user){
		if(null!=user && StringUtils.isNotBlank(user.getUsername())
				&& StringUtils.isNotBlank(user.getPassword())
				&& StringUtils.isNotBlank(user.getEmail())){
			if(esDao.insert(user, User, type, EncryptUtils.encodeMD5(user.getEmail()+user.getPassword()))){
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
