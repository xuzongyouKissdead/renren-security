package io.renren.controller.userController;


import io.renren.common.validator.ValidatorUtils;
import io.renren.form.LoginForm;
import io.renren.form.builders.R;
import io.renren.form.response.BaseResponseEntity;
import io.renren.form.response.SessionResponse;
import io.renren.service.userService.TokenService;
import io.renren.service.userService.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 登录接口
 *
 * @author xuzongyou
 *
 *
 */
@RestController
@RequestMapping("/api")
@Api(tags="登录接口")
public class ApiLoginController {
    @Autowired
    private UserService userService;
    @PostMapping("login")
    @ApiOperation("登录")
    public BaseResponseEntity<SessionResponse> login(@RequestBody LoginForm form) {
        //表单校验
        //ValidatorUtils.validateEntity(form);
        return R.success(userService.login(form));

    }

  /*  @Login
    @PostMapping("logout")
    @ApiOperation("退出")
    public R logout(@ApiIgnore @RequestAttribute("userId") long userId){
        tokenService.expireToken(userId);
        return R.success();
    }*/

}
