/**
 * Copyright 2018 大法医开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package io.renren.service.userService;


import com.baomidou.mybatisplus.service.IService;
import io.renren.entity.UserEntity;
import io.renren.form.LoginForm;
import io.renren.form.RegisterForm;
import io.renren.form.response.RegisterReponse;
import io.renren.form.response.SessionResponse;

import java.util.Map;

/**
 * 用户
 * 
 * @author xuzongyou
 * @email
 *
 */
public interface UserService extends IService<UserEntity> {

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param form    登录表单
	 * @return        返回登录信息
	 */
	SessionResponse login(LoginForm form);

	//用户注册
	SessionResponse register(RegisterForm registerForm);

}