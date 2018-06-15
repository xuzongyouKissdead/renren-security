package io.renren.controller.sysController;
import io.renren.form.SysCodeForm;
import io.renren.form.builders.R;
import io.renren.form.response.BaseResponseEntity;
import io.renren.service.sysService.SysCodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Api(tags="验证码发送接口")
public class ApiSendSysCodeController {
    @Autowired
    SysCodeService sysCodeService;
    @PostMapping("/sendSysCode")
    @ApiOperation("发送验证码")
    public BaseResponseEntity register(@RequestBody SysCodeForm form){
        return R.success(sysCodeService.sendSysCode(form));
    }
}
