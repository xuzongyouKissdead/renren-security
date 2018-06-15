
package io.renren.service.impl.user;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import io.renren.common.Enums.ExceptionEnum;
import io.renren.common.exception.RRException;
import io.renren.common.exception.ServiceException;
import io.renren.common.utils.RedisUtils;
import io.renren.common.validator.Assert;
import io.renren.dao.UserDao;
import io.renren.entity.TokenEntity;
import io.renren.entity.UserEntity;
import io.renren.form.LoginForm;
import io.renren.form.RegisterForm;
import io.renren.form.response.RegisterReponse;
import io.renren.form.response.SessionResponse;
import io.renren.models.ApiRedisKeys;
import io.renren.service.sysService.SysCodeService;
import io.renren.service.userService.TokenService;
import io.renren.service.userService.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {
	@Autowired
	private TokenService tokenService;
	@Autowired
	private SysCodeService sysCodeService;
	@Autowired
	RedisUtils redisUtils;

	@Override
	public UserEntity queryByMobile(String mobile) {
		UserEntity userEntity = new UserEntity();
		userEntity.setMobile(mobile);
		return baseMapper.selectOne(userEntity);
	}
	//用户登录
	@Override
	public SessionResponse login(LoginForm form) {
		UserEntity user = queryByMobile(form.getMobile());
		Assert.isNull(user, "手机号或密码错误");
		//密码错误
		if(!user.getPassword().equals(DigestUtils.sha256Hex(form.getPassword()))){
			try {
				throw new ServiceException(ExceptionEnum.USER_LOGIN_PASSWORD_ERROR);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
			
		

		/*//获取登录token
		TokenEntity tokenEntity = tokenService.createToken(user.getUserId());

		Map<String, Object> map = new HashMap<>(2);
		map.put("token", tokenEntity.getToken());
		map.put("expire", tokenEntity.getExpireTime().getTime() - System.currentTimeMillis());

		return map;*/
		return redisSession(user);
	}

	//用户注册
	@Override
	public SessionResponse register(RegisterForm form) {
		//验证码校验
		sysCodeService.checkSysCode(form.getMobile(), form.getSysCode());
		UserEntity user = new UserEntity();
		user.setMobile(form.getMobile());
		user.setPassword(DigestUtils.sha256Hex(form.getPassword()));
		user.setCreateTime(new Date());
		user.setLastLoginTime(new Date());
		user.setUuid(UUID.randomUUID().toString());
		if (!this.insert(user)) {
			try {
				throw new ServiceException(ExceptionEnum.USER_REGISTER_FAILED_ERROR);
			} catch (ServiceException e) {
				e.printStackTrace();
			}
		}
		//将注册基本信息存储到缓存，生成sessiond
		SessionResponse registerReponse = redisSession(user);
		return registerReponse;
	}
	//将基本信息存到缓存
	public SessionResponse redisSession(UserEntity user) {
		SessionResponse sessionResponse= new SessionResponse();
		sessionResponse.setMobile(user.getMobile());
		sessionResponse.setUserUuid(user.getUuid());
		String sessiond = ApiRedisKeys.getSessiond(user.getMobile());
		sessionResponse.setSessionId(sessiond);
		redisUtils.set(sessiond, sessionResponse, redisUtils.DEFAULT_EXPIRE);
		return  sessionResponse;
	}

}
