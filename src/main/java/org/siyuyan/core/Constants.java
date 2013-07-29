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
package org.siyuyan.core;

import java.util.HashMap;

import com.google.common.collect.Maps;

/**
 * @author whiteme
 * @date 2013年7月25日
 * @desc 常量
 */
public class Constants {
	
	public static HashMap<String, String> infoName = Maps.newHashMap();
	static {
		infoName.put("片名", "title");
		infoName.put("译名", "translation");
		infoName.put("国家", "nation");
		infoName.put("地区", "area");
		infoName.put("出品时间", "publishTime");
		infoName.put("制片地区", "area");
		infoName.put("集数", "number");
		infoName.put("监制", "studioManager");
		infoName.put("大类", "category");
		infoName.put("类别", "type");
		infoName.put("语言", "lang");
		infoName.put("视频尺寸", "size");
		infoName.put("评分", "score");
		infoName.put("片长", "duration");
		infoName.put("导演", "director");
		infoName.put("主演", "actors");
		infoName.put("简介", "summary");
		infoName.put("剧情", "summary");
		infoName.put("介绍", "summary");
		infoName.put("下载地址", "download");
		infoName.put("在线观看", "online");
		infoName.put("年代", "year");
		infoName.put("出品时间", "year");
		infoName.put("上映时间", "year");
		infoName.put("时间", "duration");
		infoName.put("演员", "actors");
	}
}
