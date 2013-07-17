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
package org.siyuyan.module.user.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.siyuyan.core.BaseController;
import org.siyuyan.es.Searcher;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whiteme
 * @date 2013年7月17日
 * @desc facet查询
 */
@Controller("facetController")
@RequestMapping("facet")
public class FacetController extends BaseController {
	
	Searcher searcher = new Searcher();
	
	@RequestMapping(value="nd")
	public String nd(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		HashMap<String, Integer> m = searcher.facet();
		request.setAttribute("facet", m);
		request.setAttribute("catgoryName","年代");
		return "../index";
	}
}