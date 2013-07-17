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

import java.util.HashMap;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.search.facet.FacetBuilders;
import org.elasticsearch.search.facet.FacetBuilders.*;
import org.elasticsearch.search.facet.terms.TermsFacet;

/**
 * @author whiteme
 * @date 2013年7月17日
 * @desc 查询工具
 */
public class Searcher {
	
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
	
	public static void main(String[] args) {
		Searcher searcher = new Searcher();
		searcher.facet();
	}
}
