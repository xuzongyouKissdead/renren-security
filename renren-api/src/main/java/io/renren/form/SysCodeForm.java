package io.renren.form;
/**
 * 验证码入参pojo
 * @author xuzongyou
 * @date 2018-06-14 17:27
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@ApiModel(value = "注册表单")
@Data
public class SysCodeForm extends BaseRequestForm {
    @ApiModelProperty(value = "手机号")
    @NotBlank(message = "手机号不能为空")
    private String mobile;
}
