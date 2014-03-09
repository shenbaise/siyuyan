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

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.facet.Facet;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.elasticsearch.search.sort.SortOrder;
import org.siyuyan.core.BaseController;
import org.siyuyan.es.Searcher;
import org.siyuyan.module.web.common.Constant;
import org.siyuyan.module.web.service.FacetService;
import org.siyuyan.utils.Pagination;
import org.siyuyan.utils.SearchResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.common.base.CharMatcher;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author whiteme
 * @date 2013年7月20日
 * @desc 主页信息
 */
@Controller(value = "homeController")
public class HomeController extends BaseController {

	private Searcher searcher = new Searcher();
	@Autowired
	private FacetService facetService;
	@Autowired
	private SearchResponseUtil util;

	/**
	 * 显示主页信息--home page
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/")
	public String home(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 最近收录的影片
		SearchResponse sr = searcher.newMovies(10);
		request.setAttribute("newFilm", util.processSearchRespons(sr));

		// 首页facet，按大类分，默认是安装count排序的
		HashMap<String, String> map = Maps.newHashMap();
		map.put("f", "category");
		sr = searcher.facet(map, null, 15);
		Facet f = sr.getFacets().facetsAsMap().get("f");
		request.setAttribute("catgoryName", "分类");
		request.setAttribute("facet", util.processFacetResult((TermsFacet) f));

		// 电影
		HashMap<String, Object> query = new HashMap<>();
		query.put("category", "电影");
		sr = searcher.query(query, "year", SortOrder.DESC, 0, 6);
		request.setAttribute("film", util.processSearchRespons(sr));
		// 电视剧
		HashMap<String, Object> query2 = new HashMap<>();
		query2.put("category", "电视剧");
		sr = searcher.query(query2, "year", SortOrder.DESC, 0, 6);
		request.setAttribute("tv", util.processSearchRespons(sr));

		// 综艺
		HashMap<String, Object> query3 = new HashMap<>();
		query3.put("category", "综艺");
		sr = searcher.query(query3, "year", SortOrder.DESC, 0, 6);
		request.setAttribute("zy", util.processSearchRespons(sr));
		return "index";
	}
	
	/**
	 * 视频分栏
	 * @param category
	 * @param page
	 * @param size
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "category/{category}")
	public String category(@PathVariable String category, Integer page, Integer size, 
			ServletRequest request, ServletResponse response) throws Exception {
		if (StringUtils.isNotBlank(category)) {
			request.setAttribute("category", category);
			HashMap<String, Object> query = new HashMap<>();
			query.put("category", category);
			SearchResponse sr = searcher.query(query, "_timestamp", SortOrder.DESC, getStartPage(page = getPage(page), size = getSize(size)), size);
			List<HashMap<String, Object>> film = util.processSearchRespons(sr);
			// 分页信息
			int total = (int) sr.getHits().totalHits();
			int num = sr.getHits().getHits().length;
			if (num == 0)
				total = 0;
			Pagination pagination = new Pagination(Constant.defaultPageGroup, page, Constant.defaultPageSize, total);
			request.setAttribute("pager", pagination.getPagination());

			// 最近收录的影片
			sr = searcher.newMovies(10);
			request.setAttribute("film", film);
			request.setAttribute("newFilm", util.processSearchRespons(sr));
			// 首页facet，按类别分默认是安装count排序的
			request.setAttribute("catgoryName", "分类");
			request.setAttribute("facet", facetService.facetSubcategory(category, 15));
			request.setAttribute("page", page);
		}

		return "category";
	}

	/**
	 * 最新视频信息
	 * @param page
	 * @param size
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "new")
	public String film(Integer page, Integer size, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 最新电影
		HashMap<String, Object> query = new HashMap<>();
		query.put("category", "电影");
		SearchResponse sr = searcher.query(query, "_timestamp", SortOrder.DESC, getStartPage(page = getPage(page), size = getSize(size)), size);
		request.setAttribute("film", util.processSearchRespons(sr));
		// 分页信息
		int total = (int) sr.getHits().totalHits();
		int num = sr.getHits().getHits().length;
		if (num == 0)
			total = 0;
		Pagination pagination = new Pagination(Constant.defaultPageGroup, page, Constant.defaultPageSize, total);
		request.setAttribute("pager", pagination.getPagination());
		// 最近收录的影片
		sr = searcher.newMovies(10);
		request.setAttribute("newFilm", util.processSearchRespons(sr));

		// 首页facet，按类别分默认是安装count排序的
		request.setAttribute("catgoryName", "分类");
		request.setAttribute("facet", facetService.facetSubcategory("电影", 15));
		request.setAttribute("page", page);

		return "film";
	}

	/**
	 * 最热视频
	 * @param page
	 * @param size
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "hot")
	public String hot(Integer page, Integer size, HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 最热电影
		HashMap<String, Object> query = new HashMap<>();
		query.put("category", "电影");
		SearchResponse sr = searcher.query(query, "year", SortOrder.DESC, getStartPage(page = getPage(page), size = getSize(size)), size);
		request.setAttribute("film", util.processSearchRespons(sr));
		// 分页信息
		int total = (int) sr.getHits().totalHits();
		int num = sr.getHits().getHits().length;
		if (num == 0)
			total = 0;
		Pagination pagination = new Pagination(Constant.defaultPageGroup, page, Constant.defaultPageSize, total);
		request.setAttribute("pager", pagination.getPagination());
		// 最近收录的影片
		sr = searcher.newMovies(10);
		request.setAttribute("newFilm", util.processSearchRespons(sr));

		// 首页facet，按类别分默认是安装count排序的
		request.setAttribute("catgoryName", "分类");
		request.setAttribute("facet", facetService.facetSubcategory("电影", 15));
		request.setAttribute("page", page);

		return "tv";
	}

}
