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

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

/**
 * @author whiteme
 * es client
 */
public class ESClient {

	static Settings settings = ImmutableSettings.settingsBuilder()
//	 .put("cluster.name", "ES-index")
			.put("client.transport.sniff", true).build();

	private static Client client = null;
	
	/**
	 * 建立链接
	 */
	public static void init(){
		if(null==client)
			client = new TransportClient(settings)
			.addTransportAddress(new InetSocketTransportAddress(
					"127.0.0.1", 9300));
	}


	public static Client getClient() {
		if (null == client) {
			client = new TransportClient(settings)
					.addTransportAddress(new InetSocketTransportAddress(
							"127.0.0.1", 9300));
		}
		return client;
	}

	public static void distroy() {
		if(null!=client)
			client.close();
	}
	
	public static void main(String[] args) {
		System.out.println("...");
	}
}
