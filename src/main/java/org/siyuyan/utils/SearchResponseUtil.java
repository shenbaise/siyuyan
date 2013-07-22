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
package org.siyuyan.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.springframework.stereotype.Service;

/**
 * @author whiteme
 * @date 2013年7月21日
 * @desc 
 */
@Service
public class SearchResponseUtil {
	
	/**
	 * @param sr
	 * @return
	 */
	public List<HashMap<String,Object>> processSearchRespons(SearchResponse sr){
		List<HashMap<String,Object>> list = new ArrayList<>();
		SearchHit[] sh = sr.getHits().getHits();
		for(SearchHit h:sh){
			HashMap<String, Object> m = new HashMap<>();
			m.put("name", h.getId());
			m.putAll(h.getSource());
			list.add(m);
		}
		return list;
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
