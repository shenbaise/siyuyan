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
import java.util.zip.ZipEntry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.SortOrder;
import org.siyuyan.core.BaseController;
import org.siyuyan.es.Searcher;
import org.siyuyan.module.web.common.Constant;
import org.siyuyan.module.web.service.FacetService;
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

	
	@RequestMapping(value="/category/{t}/{lb}",method=RequestMethod.GET)
	public String category(@PathVariable String t,@PathVariable String lb,
			Integer page,Integer size,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			int from = filterPageSize(page=getPage(page), size=getSize(size));
			
			t = new String(t.getBytes("iso8859-1"),"utf-8");
			lb = new String(lb.getBytes("iso8859-1"),"utf-8");
			HashMap<String, Object> query = new HashMap<>();
			query.put("t", UrlMapper.get(t));
			query.put("lb", lb);
			System.out.println(page + " " + size + " "+ from );
			SearchResponse sr = searcher.query(query, "_timestamp", SortOrder.DESC, from, size);
			SearchHit[] sh = sr.getHits().getHits();
			List<HashMap<String,Object>> film = new ArrayList<>();
			for(SearchHit h:sh){
				HashMap<String, Object> m = new HashMap<>();
				m.put("name", h.getId());
				Map<String, Object> source = h.getSource();
				if(null!=source){
					HashMap<String, Object> dList = (HashMap<String, Object>) source.get("d");
					if(null!=dList && dList.size()>0){
						m.put("d", dList);
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
			request.setAttribute("facet", facetService.facetSubcategory(UrlMapper.get(t), 15));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return t;
	}
	
	/**
	 * @param page
	 * @param size
	 * 处理页码异常
	 */
	public static int filterPageSize(Integer page,Integer size){
		return (page-1)*size;
	}
	
	public int getPage(Integer page){
		if(page==null)
			page = 1;
		if(page<0)
			page = 1;
		return page;
	}
	public static int getSize(Integer size){
		if(size==null)
			size = Constant.defaultPageSize;
		if(size<=0)
			size = Constant.defaultPageSize;
		return size;
	}
	
}
