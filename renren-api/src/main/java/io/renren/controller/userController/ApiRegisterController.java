package io.renren.controller.userController;
import io.renren.common.validator.ValidatorUtils;
import io.renren.form.RegisterForm;
import io.renren.form.response.BaseResponseEntity;
import io.renren.service.userService.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 注册接口
 * @author xuzongyou
 * @date 2018-06-14 17:27
 */
@RestController
@RequestMapping("/api")
@Api(tags="注册接口")
public class ApiRegisterController {
    @Autowired
    UserService userService;
    @PostMapping("register")
    @ApiOperation("注册")
    public BaseResponseEntity register(@RequestBody RegisterForm form){
        //表单校验
        ValidatorUtils.validateEntity(form);
        return io.renren.form.builders.R.success(userService.register(form));
    }
}
