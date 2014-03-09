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

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.fieldQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchAllQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;
import static org.elasticsearch.search.facet.FacetBuilders.termsFacet;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.stereotype.Service;

/**
 * @author whiteme
 * @date 2013年7月17日
 * @desc 查询工具
 */
@Service(value="searcher")
public class Searcher {

	private Log log = LogFactory.getLog(this.getClass());

	private Client client = ESClient.getClient();

	public Searcher() {
	};

	/**
	 * @param facet
	 * @param query
	 * @param size
	 * @return
	 * @desc 计算facet
	 */
	public SearchResponse facet(HashMap<String, String> facet,
			HashMap<String, Object> query, int size) {

		SearchRequestBuilder sqb = client.prepareSearch();
		if (query != null) {
			BoolQueryBuilder bqb = boolQuery();
			for (Entry<String, Object> entry : query.entrySet()) {
				bqb.must(matchQuery(entry.getKey(), entry.getValue()));
			}
			sqb.setQuery(bqb);
		} else {
			sqb.setQuery(matchAllQuery());
		}

		Set<Entry<String, String>> sets = facet.entrySet();
		for (Entry<String, String> entry : sets) {
			sqb.addFacet(termsFacet(entry.getKey()).field(entry.getValue())
			// .order(ComparatorType.REVERSE_TERM)
			.size(size));
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
	public boolean exists(String index, String type, String id) {
		GetResponse response = client.prepareGet(index, type, id).execute()
				.actionGet();
		return response.isExists();
	}
	/**
	 * get document
	 * @param index
	 * @param type
	 * @param id
	 * @return
	 */
	public GetResponse get(String index,String type,String id){
		return client.prepareGet(index, type, id).execute()
		.actionGet();
	}
	/**
	 * @param map
	 * @return 查询
	 */
	public SearchResponse query(HashMap<String, Object> map) {
		BoolQueryBuilder qb = boolQuery();
		Set<Entry<String, Object>> sets = map.entrySet();
		for (Entry<String, Object> entry : sets) {
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
	/**
	 * @param query
	 * @param sortField
	 * @param order
	 * @param from
	 * @param size
	 * @return 
	 * @desc 查询
	 */
	public SearchResponse query(HashMap<String, Object> query,
			String sortField, SortOrder order, int from, int size) {
		BoolQueryBuilder qb = boolQuery();
		if(null==query || query.size()==0){
			qb.must(matchAllQuery());
		}else{
			Set<Entry<String, Object>> sets = query.entrySet();
			for (Entry<String, Object> entry : sets) {
				qb.must(fieldQuery(entry.getKey(), entry.getValue()));
			}
		}
		SearchRequestBuilder sqb = client.prepareSearch().setQuery(qb).setSize(size).setFrom(from);
				if(StringUtils.isNotBlank(sortField) && null!=order){
					sqb.addSort(sortField, order);
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
	 * @return
	 * @desc 返回热门电影
	 */
	public SearchResponse hotMovies(int size) {
		SearchRequestBuilder sqb = client.prepareSearch()
				.setQuery(termQuery("t", "电影"))
				// .addFields("d","gj")
				.addSort("score", SortOrder.DESC).setSize(size).setFrom(0);
		SearchResponse searchResponse;
		try {
			searchResponse = sqb.execute().get();
			return searchResponse;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * @param size
	 * @return
	 * @desc 返回size个最新(最新收录的)的电影
	 */
	public SearchResponse newMovies(int size) {
		SearchRequestBuilder sqb = client.prepareSearch()
				.setQuery(termQuery("t", "电影"))
				// .addFields("d","gj")
				.addSort("_timestamp", SortOrder.DESC).setSize(size).setFrom(0);
		SearchResponse searchResponse;
		try {
			searchResponse = sqb.execute().get();
			return searchResponse;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param category
	 * @param sortField
	 * @param order
	 * @param size
	 * @param from
	 * @return
	 * @desc 用termQuery("t", category)查询size条记录，并按照sortField排序
	 */
	public SearchResponse queryVideos(String category,String sortField,
			SortOrder order,int size,int from) {
		SearchRequestBuilder sqb = client.prepareSearch();
		if(StringUtils.isNotBlank(category)){
			sqb.setQuery(termQuery("t", category));
		}else {
			sqb.setQuery(matchAllQuery());
		}
		if(StringUtils.isNotBlank(sortField) && null!=order){
			sqb.addSort(sortField, order);
		}
		if(size <=0){
			size = 20;
		}
		if(from<=0){
			from = 0;
		}
		sqb.setSize(size).setFrom(from);
		
		SearchResponse searchResponse;
		try {
			searchResponse = sqb.execute().get();
			return searchResponse;
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param category
	 * @param size
	 * @param from
	 * @return 
	 * @desc 用termQuery("t", category)返回size条记录
	 */
	public SearchResponse queryVideos(String category,
			int size,int from) {
		return queryVideos(category, null, null, from, size);
	}
	/**
	 * @param size
	 * @param from
	 * @return
	 * @desc 用matchAllQuery返回size条记录
	 */
	public SearchResponse queryVideos(int size,int from){
		return queryVideos(null, null, null, size, from);
	}
	
	public static void main(String[] args) {
		Searcher searcher = new Searcher();
	}
}
