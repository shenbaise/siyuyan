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
package org.siyuyan.es;

import static org.elasticsearch.index.query.QueryBuilders.*;
import static org.elasticsearch.search.facet.FacetBuilders.termsFacet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.lucene.search.vectorhighlight.FieldQuery;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.search.facet.FacetBuilders;
import org.elasticsearch.search.facet.FacetBuilders.*;
import org.elasticsearch.search.facet.terms.TermsFacet;
import org.elasticsearch.search.sort.SortOrder;

/**
 * @author whiteme
 * @date 2013年7月17日
 * @desc 查询工具
 */
public class Searcher {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	private Client client = ESClient.getClient();
	
	/**
	 * facet 查询
	 * @return
	 */
	public HashMap<String, Integer> facet(){
		SearchResponse sr = client.prepareSearch()
//        .setQuery()
        .addFacet( FacetBuilders
        		.termsFacet("f")
        	    .field("nd")
        	    .size(100) )
        .execute().actionGet();
		
		TermsFacet f = (TermsFacet) sr.getFacets().facetsAsMap().get("f");

		f.getTotalCount();      // Total terms doc count
		f.getOtherCount();      // Not shown terms doc count
		f.getMissingCount();    // Without term doc count

		// For each entry
		HashMap<String, Integer> facet = new HashMap<>();
		for (TermsFacet.Entry entry : f) {
		    entry.getTerm();    // Term
		    entry.getCount();   // Doc count
		    System.out.println(entry.getTerm().toString() + "\t" + entry.getCount());
		    facet.put(entry.getTerm().toString(), entry.getCount());
		}
		System.out.println(sr.getFacets());
		return facet;
	}
	/**
	 * @param map
	 * @return
	 * @desc 计算facet
	 */
	public SearchResponse facet(HashMap<String, String> map){
		SearchRequestBuilder sqb = client.prepareSearch()
                .setQuery(matchAllQuery());
		Set<Entry<String, String>> sets = map.entrySet();
		for(Entry<String, String> entry:sets){
			sqb.addFacet(termsFacet(entry.getKey()).field(entry.getValue()).size(15));
		}
		try {
			SearchResponse searchResponse = sqb.execute().get();
			return searchResponse;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			log.debug(e.getMessage());
		}
		return null;
	}
	
	/**
	 * @param index
	 * @param type
	 * @param id
	 * @return 该id的文档是否存在
	 */
	public boolean exists(String index,String type,String id){
		GetResponse response = client.prepareGet(index, type, id).execute().actionGet();
		return response.isExists();
	}
	
	/**
	 * @param map
	 * @return 查询
	 */
	public SearchResponse query(HashMap<String, Object> map){
		
		BoolQueryBuilder qb = boolQuery();
		Set<Entry<String, Object>> sets = map.entrySet();
		for(Entry<String, Object> entry:sets){
			qb.must(fieldQuery(entry.getKey(), entry.getValue()));
		}
		
		SearchRequestBuilder sqb = client.prepareSearch().setQuery(qb);
		
		try {
			SearchResponse searchResponse = sqb.execute().get();
			return searchResponse;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			log.debug(e.getMessage());
		}
		return null;
	}
	
public SearchResponse query(HashMap<String, Object> query,String sortField,SortOrder order,int from,int size){
		
		BoolQueryBuilder qb = boolQuery();
		Set<Entry<String, Object>> sets = query.entrySet();
		for(Entry<String, Object> entry:sets){
			qb.must(fieldQuery(entry.getKey(), entry.getValue()));
		}
		
		SearchRequestBuilder sqb = client.prepareSearch().setQuery(qb).addSort(sortField,order).setSize(size).setFrom(from);
		
		try {
			SearchResponse searchResponse = sqb.execute().get();
			return searchResponse;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			log.debug(e.getMessage());
		}
		return null;
	}
	/**
	 * @return 
	 * @desc 返回热门电影
	 */
	public SearchResponse hotMovies(){
		
		return null;
	}
	
	public static void main(String[] args) {
		Searcher searcher = new Searcher();
		searcher.facet();
	}
}
