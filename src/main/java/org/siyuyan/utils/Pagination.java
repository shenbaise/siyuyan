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

import org.apache.commons.lang3.StringUtils;
import org.siyuyan.module.web.common.Constant;

/**
 * @author whiteme
 * @date 2013年7月25日
 * @desc 基于bootstrap样式的分页
 */
public class Pagination {

	private int group = 5;
	private int page = 1;
	private int pageSize = Constant.defaultPageSize;
	private int total;
	private int totalPages = 10000;
	private PaginationSize pSize = PaginationSize.defaultSize;
	private PagiationPosition position = PagiationPosition.center;
	/**
	 * 查询关键字
	 */
	private String wd;

	public Pagination() {
	}

	public Pagination(int group, int page) {
		super();
		this.group = group;
		this.page = page;
		if(this.page<1)
			this.page=1;
		if(this.group>10)
			this.group = 10;
		if(this.group<5)
			this.group = 5;
	}
	
	public Pagination(int group, int page,int pageSize,int total) {
		super();
		this.group = group;
		this.page = page;
		this.total = total;
		if(this.page<1)
			this.page=1;
		if(this.group>10)
			this.group = 10;
		if(this.group<5)
			this.group = 5;
		
		float f = (float)total / (float)pageSize;
		totalPages = total / pageSize;
		if(f>totalPages)
			totalPages +=1;
	}

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public PaginationSize getpSize() {
		return pSize;
	}

	public void setpSize(PaginationSize pSize) {
		this.pSize = pSize;
	}

	public PagiationPosition getPosition() {
		return position;
	}

	public void setPosition(PagiationPosition position) {
		this.position = position;
	}
	
	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public String getWd() {
		return wd;
	}

	public void setWd(String wd) {
		this.wd = StringUtils.isBlank(wd)?"":wd;
	}

	/**
	 * 获得分页信息
	 */
	public String getPagination() {
		if(totalPages<=0){
			return "<div class=\"pagination pagination-large\"><b>非常抱歉，没有内容</b></div>";
		}
		StringBuilder sb = new StringBuilder();
		int start = 1;
		sb.append("<div class=\"pagination ");
		// 大小
		switch (pSize) {
		case large:
			sb.append("pagination-large ");
			break;
		case small:
			sb.append("pagination-small ");
			break;
		case mini:
			sb.append("pagination-mini ");
			break;
		default:
			break;
		}
		// 位置
		switch (position) {
		case right:
			sb.append("pagination-right\">");
			break;
		case center:
			sb.append("pagination-centered\">");
			break;
		default:
			sb.append("\">");
			break;
		}
		// 上一页
		sb.append("<ul>");
		if(page==1){
			sb.append("<li class=\"disabled\"> <a>上一页</a> </li>");
		}else {
			sb.append("<li> <a href=\"?page="+(page-1)+"&wd="+wd+"\">上一页</a> </li>");
		}
		// 页码
		
		start = page - group/2 + 1;
		if(start<1)
			start=1;
	
		int n = start + group -1;
		if(page >= totalPages || n>totalPages){
			n=totalPages;
		}
		if(start>n)
			start = n - group;
		for(;start<=n;start++){
			if(start == page){
				sb.append("<li class=\"active\"> <a href=\"?page="+start +"&wd="+wd+ "\">"+ start +"</a></li>");
			}else {
				sb.append("<li> <a href=\"?page="+start +"&wd="+wd+ "\">"+ start +"</a></li>");
			}
		}
		
		// 下一页
		sb.append("<ul>");
		if(page>=totalPages){
			sb.append("<li class=\"disabled\"> <a>下一页</a> </li>");
		}else {
			sb.append("<li> <a href=\"?page="+(page+1)+"&wd="+wd+"\">下一页</a> </li>");
		}
		sb.append("</ul></div>");
		return sb.toString();
	}

	public enum PaginationSize {
		defaultSize, large, small, mini
	}

	public enum PagiationPosition {
		left, center, right
	}
}
