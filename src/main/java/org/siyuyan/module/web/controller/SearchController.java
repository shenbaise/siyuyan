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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.siyuyan.core.BaseController;
import org.siyuyan.es.Searcher;
import org.siyuyan.module.web.common.Constant;
import org.siyuyan.utils.Pagination;
import org.siyuyan.utils.SearchResponseUtil;
import org.siyuyan.utils.StringHelper;
import org.siyuyan.utils.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.CharMatcher;

/**
 * @author whiteme
 * @date 2013年7月27日
 * @desc Searcher
 */
@Controller(value="searchController")
public class SearchController extends BaseController {
	private Searcher searcher = new Searcher();
	@Autowired
	private SearchResponseUtil util;
	
	/**
	 * 查询
	 * @param kw
	 * @param page
	 * @param size
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="s")
	public String search(String wd,Integer page,Integer size,HttpServletRequest request,HttpServletResponse response) throws Exception{
		wd = StringHelper.isoToUtf8(wd);
		HashMap<String, Object> query = new HashMap<>();
		if(StringUtils.isNotBlank(wd))
			query.put("_all", wd);
		SearchResponse sr = searcher.query(query, null, null,
				getStartPage(page=getPage(page), size=getSize(size)), size);
		int total = (int) sr.getHits().totalHits();
		int num = sr.getHits().getHits().length;
		if(num==0)
			total = 0;
		Pagination pagination = new Pagination(Constant.defaultPageGroup, page, Constant.defaultPageSize, total);
		pagination.setWd(wd);
		SearchHit[] sh = sr.getHits().getHits();
		List<HashMap<String,Object>> film = new ArrayList<>();
		for(SearchHit h:sh){
			HashMap<String, Object> m = new HashMap<>();
			// 转换斜杠，否则Url不认
			String name = h.getId();
			if(name.contains("/")){
				name = CharMatcher.anyOf("/").replaceFrom(name, "|");
			}
			m.put("name", name);
			Map<String, Object> source = h.getSource();
			if(null!=source){
				HashMap<String, Object> dList = (HashMap<String, Object>) source.get("download");
				if(null!=dList && dList.size()>0){
					m.put("download", dList);
				}
				m.put("thumbnail", source.get("thumbnail"));
			}
			film.add(m);
		}
		request.setAttribute("film", film);
		request.setAttribute("pager", pagination.getPagination());
		request.setAttribute("wd", wd);
		return "search";
	}
}
