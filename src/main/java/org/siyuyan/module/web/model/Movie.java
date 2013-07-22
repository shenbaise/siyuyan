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

import java.util.HashMap;

/**
 * @author whiteme
 * @date 2013年7月18日
 * @desc 
 */
public class Movie {
	
	public static HashMap<String, String> infoName = new HashMap<>();
	{
		infoName.put("片　　名", "pm");
		infoName.put("片　名", "pm");
		infoName.put("片名", "pm");
		infoName.put("译　　名", "ym");
		infoName.put("译　名", "ym");
		infoName.put("译名", "ym");
		infoName.put("国　　家", "gj");
		infoName.put("国　家", "gj");
		infoName.put("国家", "gj");
		infoName.put("地　　区", "gj");
		infoName.put("地　区", "gj");
		infoName.put("出品时间", "nd");
		infoName.put("制片地区", "dq");
		infoName.put("编剧", "bj");
		infoName.put("集数", "gj");
		infoName.put("监制", "gj");
		infoName.put("类　　别", "lb");
		infoName.put("类　别", "lb");
		infoName.put("类别", "lb");
		infoName.put("监制", "gj");
		infoName.put("类　　型", "lb");
		infoName.put("类　型", "lb");
		infoName.put("类型", "lb");
		infoName.put("语　　言", "yy");
		infoName.put("语　言", "yy");
		infoName.put("语言", "yy");
		infoName.put("字　　幕", "zm");
		infoName.put("字　幕", "zm");
		infoName.put("字幕", "zm");
		infoName.put("文件格式", "gs");
		infoName.put("视频尺寸", "cc");
		infoName.put("IMDB评分", "imdb-pf");
		infoName.put("评　　分", "pf");
		infoName.put("评　分", "pf");
		infoName.put("评分", "pf");
		infoName.put("文件大小", "dx");
		infoName.put("片　　长", "pc");
		infoName.put("片　长", "pc");
		infoName.put("片长", "pc");
		infoName.put("导　　演", "dy");
		infoName.put("导　演", "dy");
		infoName.put("导演", "dy");
		infoName.put("主　　演", "zy");
		infoName.put("主　演", "zy");
		infoName.put("主演", "zy");
		infoName.put("简　　介", "jq");
		infoName.put("简　介", "jq");
		infoName.put("剧情介绍", "jq");
		infoName.put("下载地址", "xzdz");
		infoName.put("在线观看", "zzdz");
		infoName.put("年　　代", "nd");
		infoName.put("年代", "nd");
		infoName.put("时间", "pc");
		infoName.put("音频", "yy");
		infoName.put("演员", "zy");
	}
	
	public static HashMap<String, String> model = new HashMap<>();
	{
		model.put("pm","片名");
		model.put("gj", "国家");
		model.put("nd", "年代");
		model.put("dy", "导演");
		model.put("zy", "主演");
		model.put("lb", "类别");
		model.put("jq", "简介");
		model.put("d", "下载地址");
		model.put("k", "在线观看");
	}
}
