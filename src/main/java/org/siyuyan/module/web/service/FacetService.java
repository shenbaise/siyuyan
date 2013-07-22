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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.facet.Facet;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.siyuyan.es.Searcher;
import org.springframework.stereotype.Service;

/**
 * @author whiteme
 * @date 2013年7月18日
 * @desc 提供facet服务
 */
@Service("facetService")
public class FacetService {
	
	private Searcher searcher = new Searcher();
	
	/**
	 * @param size
	 * @return
	 * 返回大类（电影，电视剧，综艺，动漫等）的facet
	 */
	public List<HashMap<String, Integer>> facetCategory(int size){
		HashMap<String, String> map = new HashMap<>();
		map.put("f", "t");
		SearchResponse sr = searcher.facet(map,null,size);
		Facet f = sr.getFacets().facetsAsMap().get("f");
		if(f!=null)
			return processFacetResult((TermsFacet)f);
		else 
			return null;
	}
	
	/**
	 * @param category
	 * @param size
	 * @return
	 * @desc 返回category下的subcategory的facet
	 */
	public List<HashMap<String, Integer>> facetSubcategory(String category,int size){
		HashMap<String, String> map = new HashMap<>();
		map.put("f", "lb");
		HashMap<String, Object> q = new HashMap<>();
		q.put("t", category);
		SearchResponse sr = searcher.facet(map,q,size);
		Facet f = sr.getFacets().facetsAsMap().get("f");
		if(f!=null)
			return processFacetResult((TermsFacet)f);
		else 
			return null;
	}
	
	/**
	 * @param tf
	 * @return
	 * @desc 返回facet结果
	 */
	public List<HashMap<String, Integer>> processFacetResult(TermsFacet tf){
		List<HashMap<String, Integer>> result = new ArrayList<>();
		for (TermsFacet.Entry entry : tf) {
		    HashMap<String, Integer> m = new HashMap<>(1);
		    m.put(entry.getTerm().toString(), entry.getCount());
		    result.add(m);
		}
		return result;
	}
	
}
