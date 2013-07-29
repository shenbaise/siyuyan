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

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.cglib.core.Constants;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.get.GetResponse;
import org.siyuyan.core.BaseController;
import org.siyuyan.es.Searcher;
import org.siyuyan.module.web.common.Constant;
import org.siyuyan.utils.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.CharMatcher;

/**
 * @author whiteme
 * @date 2013年7月28日
 * @desc 播放
 */
@Controller(value="playController")
public class PlayController extends BaseController {
	@Autowired
	private Searcher searcher;
	/**
	 * 播放
	 * @param id
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/play/{id}",method=RequestMethod.GET)
	public String category(@PathVariable String id,HttpServletRequest request,HttpServletResponse response) throws Exception{
		id = StringHelper.isoToUtf8(id);
		if(StringUtils.isNotBlank(id)){
			if(id.contains("|")){
				id = CharMatcher.anyOf("|").replaceFrom(id, "/");
			}
		}
		GetResponse get = searcher.get(Constant.movieIndex, Constant.type, id);
		Map<String, Object> m = get.getSource();
		
		request.setAttribute("movie", m);
		return "show";
	}
}
