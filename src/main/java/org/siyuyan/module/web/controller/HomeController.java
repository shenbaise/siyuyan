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

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.facet.Facet;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.elasticsearch.search.sort.SortOrder;
import org.siyuyan.core.BaseController;
import org.siyuyan.es.Searcher;
import org.siyuyan.module.web.service.FacetService;
import org.siyuyan.utils.SearchResponseUtil;
import org.siyuyan.utils.UrlMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author whiteme
 * @date 2013年7月20日
 * @desc 主页信息
 */
@Controller(value="homeController")
public class HomeController extends BaseController{
	
	private Searcher searcher = new Searcher();
	@Autowired
	private FacetService facetService ;
	@Autowired
	private SearchResponseUtil util;
	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 * @desc 首页
	 */
	@RequestMapping(value="/")
	public String home(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 最近收录的影片
		SearchResponse sr = searcher.newMovies(10);
		request.setAttribute("newFilm", util.processSearchRespons(sr));
		
		// 首页facet，按大类分，默认是安装count排序的
		HashMap<String, String> map = new HashMap<>();
		map.put("f", "t");
		sr = searcher.facet(map,null,15);
		Facet f = sr.getFacets().facetsAsMap().get("f");
		request.setAttribute("catgoryName", "分类");
		request.setAttribute("facet", util.processFacetResult((TermsFacet) f));
		
		// 电影
		HashMap<String, Object> query = new HashMap<>();
		query.put("t", "电影");
		sr = searcher.query(query, "nd", SortOrder.DESC, 0, 3);
		SearchHit[] sh = sr.getHits().getHits();
		List<HashMap<String,Object>> film = new ArrayList<>();
		for(SearchHit h:sh){
			HashMap<String, Object> m = new HashMap<>();
			m.put("name", h.getId());
			Map<String, Object> source = h.getSource();
			if(null!=source){
				List<String> dList = (List<String>) source.get("d");
				if(null!=dList && dList.size()>0){
					m.put("d", dList.get(0));
				}
				List<String> mList = (List<String>) source.get("img");
				if(null!=mList && mList.size()>0){
					m.put("img", mList.get(0));
				}
			}
			film.add(m);
		}
		request.setAttribute("film", film);
		
		// 电视剧
		HashMap<String, Object> query2 = new HashMap<>();
		query2.put("t", "电视剧");
		sr = searcher.query(query2, "nd", SortOrder.DESC, 0, 3);
		sh = sr.getHits().getHits();
		List<HashMap<String,Object>> tv = new ArrayList<>();
		for(SearchHit h:sh){
			HashMap<String, Object> m = new HashMap<>();
			m.put("name", h.getId());
			Map<String, Object> source = h.getSource();
			if(null!=source){
				List<String> dList = (List<String>) source.get("d");
				if(null!=dList && dList.size()>0){
					m.put("d", dList.get(0));
				}
				List<String> mList = (List<String>) source.get("img");
				if(null!=mList && mList.size()>0){
					m.put("img", mList.get(0));
				}
			}
			
			tv.add(m);
		}
		request.setAttribute("tv", tv);
		
		// 综艺
		HashMap<String, Object> query3 = new HashMap<>();
		query3.put("t", "综艺");
		sr = searcher.query(query3, "nd", SortOrder.DESC, 0, 3);
		sh = sr.getHits().getHits();
		List<HashMap<String,Object>> zy = new ArrayList<>();
		for(SearchHit h:sh){
			HashMap<String, Object> m = new HashMap<>();
			m.put("name", h.getId());
			Map<String, Object> source = h.getSource();
			if(null!=source){
				List<String> dList = (List<String>) source.get("d");
				if(null!=dList && dList.size()>0){
					m.put("d", dList.get(0));
				}
				List<String> mList = (List<String>) source.get("img");
				if(null!=mList && mList.size()>0){
					
					m.put("img", mList.get(0));
					if(mList.size()>1){
						m.put("img", mList.get(1));
					}
				}
			}
			
			zy.add(m);
		}
		request.setAttribute("zy", zy);
		return "index";
	}
	
	@RequestMapping(value="{category}")
	public String home2(@PathVariable String category,Integer page,Integer size,HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 电影
		HashMap<String, Object> query = new HashMap<>();
		query.put("t", UrlMapper.get(category));
		SearchResponse sr = searcher.query(query, "_timestamp", SortOrder.DESC, 0, 20);
		SearchHit[] sh = sr.getHits().getHits();
		List<HashMap<String,Object>> film = new ArrayList<>();
		for(SearchHit h:sh){
			HashMap<String, Object> m = new HashMap<>();
			m.put("name", h.getId());
			Map<String, Object> source = h.getSource();
			if(null!=source){
				List<String> dList = (List<String>) source.get("d");
				if(null!=dList && dList.size()>0){
					m.put("d", dList.get(0));
				}
				List<String> mList = (List<String>) source.get("img");
				if(null!=mList && mList.size()>0){
					m.put("img", mList.get(0));
				}
			}
			film.add(m);
		}
		request.setAttribute("film", film);
		
		// 最近收录的影片
		sr = searcher.newMovies(10);
		request.setAttribute("newFilm", util.processSearchRespons(sr));
		
		// 首页facet，按类别分默认是安装count排序的
		request.setAttribute("catgoryName", "分类");
		request.setAttribute("facet", facetService.facetSubcategory(UrlMapper.get(category), 15));
		return category;
	}
	
	@RequestMapping(value="new")
	public String film(Integer page,Integer size,HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 最新电影
		HashMap<String, Object> query = new HashMap<>();
		query.put("t", "电影");
		SearchResponse sr = searcher.query(query, "_timestamp", SortOrder.DESC, 0, 20);
		SearchHit[] sh = sr.getHits().getHits();
		List<HashMap<String,Object>> film = new ArrayList<>();
		for(SearchHit h:sh){
			HashMap<String, Object> m = new HashMap<>();
			m.put("name", h.getId());
			Map<String, Object> source = h.getSource();
			if(null!=source){
				List<String> dList = (List<String>) source.get("d");
				if(null!=dList && dList.size()>0){
					m.put("d", dList.get(0));
				}
				List<String> mList = (List<String>) source.get("img");
				if(null!=mList && mList.size()>0){
					m.put("img", mList.get(0));
				}
			}
			film.add(m);
		}
		request.setAttribute("film", film);
		
		// 最近收录的影片
		sr = searcher.newMovies(10);
		request.setAttribute("newFilm", util.processSearchRespons(sr));
		
		// 首页facet，按类别分默认是安装count排序的
		request.setAttribute("catgoryName", "分类");
		request.setAttribute("facet", facetService.facetSubcategory("电影", 15));
		return "film";
	}
	
	/**
	 * 电视剧
	 * @param page
	 * @param size
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="hot")
	public String hot(Integer page,Integer size,HttpServletRequest request,HttpServletResponse response) throws Exception{
		// 最热电影
		HashMap<String, Object> query = new HashMap<>();
		query.put("t", "电影");
		SearchResponse sr = searcher.query(query, "nd", SortOrder.DESC, 0, 20);
		SearchHit[] sh = sr.getHits().getHits();
		List<HashMap<String,Object>> film = new ArrayList<>();
		for(SearchHit h:sh){
			HashMap<String, Object> m = new HashMap<>();
			m.put("name", h.getId());
			Map<String, Object> source = h.getSource();
			if(null!=source){
				List<String> dList = (List<String>) source.get("d");
				if(null!=dList && dList.size()>0){
					m.put("d", dList.get(0));
				}
				List<String> mList = (List<String>) source.get("img");
				if(null!=mList && mList.size()>0){
					m.put("img", mList.get(0));
				}
			}
			film.add(m);
		}
		request.setAttribute("film", film);
		
		// 最近收录的影片
		sr = searcher.newMovies(10);
		request.setAttribute("newFilm", util.processSearchRespons(sr));
		
		// 首页facet，按类别分默认是安装count排序的
		request.setAttribute("catgoryName", "分类");
		request.setAttribute("facet", facetService.facetSubcategory("电影", 15));
		
		return "tv";
	}
	
	
}