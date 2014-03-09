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

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.inject.internal.Nullable;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.siyuyan.core.BaseController;
import org.siyuyan.es.Searcher;
import org.siyuyan.module.web.common.Constant;
import org.siyuyan.module.web.service.FacetService;
import org.siyuyan.utils.Pagination;
import org.siyuyan.utils.SearchResponseUtil;
import org.siyuyan.utils.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author whiteme
 * @date 2013年7月21日
 * @desc 
 */
@Controller(value="categoryController")
public class CategoryController extends BaseController {
	
	private Searcher searcher = new Searcher();
	
	@Autowired
	private FacetService facetService ;
	@Autowired
	private SearchResponseUtil util;

	/**
	 * 大类（分栏）下的细分类别。如电影-恐怖
	 * @param t
	 * @param lb
	 * @param page
	 * @param size
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="category/{t}/{lb}",method=RequestMethod.GET)
	public String category(@PathVariable String t,@Nullable @PathVariable String lb,
			Integer page,Integer size,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			HashMap<String, Object> query = new HashMap<>();
			query.put("category", t);
			query.put("type", lb);
			SearchResponse sr = searcher.query(query, "_timestamp", SortOrder.DESC,
					getStartPage(page=getPage(page), size=getSize(size)), size);
			int total = (int) sr.getHits().totalHits();
			int num = sr.getHits().getHits().length;
			if(num==0) total = 0;
			
			request.setAttribute("film", util.processSearchRespons(sr));
			// 最近收录的影片
			sr = searcher.newMovies(10);
			request.setAttribute("newFilm", util.processSearchRespons(sr));
			// 首页facet，按类别分默认是安装count排序的
			request.setAttribute("catgoryName", "分类");
			request.setAttribute("category", t);
			request.setAttribute("type", lb);
			request.setAttribute("facet", facetService.facetSubcategory(UrlMapper.get(t), 15));
			Pagination pagination = new Pagination(Constant.defaultPageGroup, page, Constant.defaultPageSize, total);
			request.setAttribute("pager", pagination.getPagination());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "category";
	}
	
}
