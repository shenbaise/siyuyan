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
 * @desc user session
 */
public class UserSession {
	
	// 基本
		private String id;
		private String username;
		private String password;
		private String email;
		// 详细
		private int birth;	//仅存年份
		private String gender;
		private String eduacation;
		private String job;
		private String address;
		private String phone;
		// 其他各种补充信息全部放在hoby中
		private List<String> hoby;
}
