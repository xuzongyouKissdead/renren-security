package io.renren.form.response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@ApiModel
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class SessionResponse {
    @JsonProperty("appName")
    private String appName;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("userUuid")
    private String userUuid;

    @JsonProperty("sessionId")
    private String sessionId;
    //最后一次登录时间
    @JsonProperty("lastLoginTime")
    private Date lastLoginTime;
    //客户端版本
    @JsonProperty("clientVersion")
    private String clientVersion;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("ip")
    private String ip;

    @JsonProperty("expireIn")
    private String expireIn;

    @JsonProperty("status")
    private String status;

    @ApiModelProperty(value = "短信验证码key")
    @JsonProperty
    private String sysCodeKey;

    @ApiModelProperty(value = "身份证号")
    @JsonProperty
    private String idCard;
    @ApiModelProperty(value = "真实姓名")
    @JsonProperty
    private String realName;
    @ApiModelProperty(value = "用户角色")
    @JsonProperty
    private Integer userRole;
}
