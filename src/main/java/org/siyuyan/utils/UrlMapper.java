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

import java.util.HashMap;

/**
 * @author whiteme
 * @date 2013年7月21日
 * @desc 
 */
public class UrlMapper {
	
	public static HashMap<String, String> mapper = new HashMap<>();
	static {
		mapper.put("film", "电影");
		mapper.put("tv", "电视剧");
		mapper.put("zy", "综艺");
		mapper.put("music", "音乐");
		mapper.put("dm", "动漫");
	}
	
	
	public static String get(String key){
		return mapper.get(key);
	}
}
