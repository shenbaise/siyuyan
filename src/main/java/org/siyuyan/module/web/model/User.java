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

/**
 * @author whiteme
 * @date 2013年7月28日
 * @desc user
 */
public class User {
	// 基本
	private String id;
	private String username;
	private String password;
	private String email;
	private boolean rememberMe;
	// 详细
	private int birth;	//仅存年份
	private String gender;
	private String eduacation;
	private String job;
	private String address;
	private String phone;
	// 其他各种补充信息全部放在hoby中
	private List<String> hoby;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String email,
			int birth, String gender, String eduacation, String job,
			String address, List<String> hoby) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.birth = birth;
		this.gender = gender;
		this.eduacation = eduacation;
		this.job = job;
		this.address = address;
		this.hoby = hoby;
	}
	public User(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getBirth() {
		return birth;
	}
	public void setBirth(int birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEduacation() {
		return eduacation;
	}
	public void setEduacation(String eduacation) {
		this.eduacation = eduacation;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<String> getHoby() {
		return hoby;
	}
	public void setHoby(List<String> hoby) {
		this.hoby = hoby;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public boolean isRememberMe() {
		return rememberMe;
	}
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", username=")
				.append(username).append(", password=").append(password)
				.append(", email=").append(email).append(", birth=")
				.append(birth).append(", gender=").append(gender)
				.append(", eduacation=").append(eduacation).append(", job=")
				.append(job).append(", address=").append(address)
				.append(", hoby=").append(hoby).append("]");
		return builder.toString();
	}
	
	
}
