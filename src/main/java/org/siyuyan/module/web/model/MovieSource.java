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
package org.siyuyan.module.web.model;

import java.util.List;
import java.util.TreeMap;

/**
 * @author whiteme
 * @date 2013年7月26日
 * @desc 影片资源，可能更新比较频繁
 */
public class MovieSource {

	/**
	 * 主键，使用片名或者片名的拼音
	 */
	private String id;
	/**
	 * 下载资源
	 */
	private TreeMap<String, List<Source>> download;
	/**
	 * 在线观看资源
	 */
	private TreeMap<String, List<Source>> online;

	public MovieSource() {
	};

	public MovieSource(String id, TreeMap<String, List<Source>> download,
			TreeMap<String, List<Source>> online) {
		super();
		this.id = id;
		this.download = download;
		this.online = online;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TreeMap<String, List<Source>> getDownload() {
		return download;
	}

	public void setDownload(TreeMap<String, List<Source>> download) {
		this.download = download;
	}

	public TreeMap<String, List<Source>> getOnline() {
		return online;
	}

	public void setOnline(TreeMap<String, List<Source>> online) {
		this.online = online;
	}

	public static void main(String[] args) {
		System.out.println("Hello World!");
	}

	/**
	 * 资源
	 */
	class Source {
		/**
		 * 资源连接
		 */
		private String url;
		/**
		 * 有效值（值为负，小于-20删除之）， 有人举报连接无效值-1，举报连接有效+2（考虑无效连接投诉率高，有效连接反馈率低）
		 */
		private int value;

		public Source() {
		}

		public Source(String url, int value) {
			super();
			this.url = url;
			this.value = value;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
}
