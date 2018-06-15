package io.renren.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
@Data
public class BaseRequestForm { @ApiModelProperty(value = "网络类型", required = true)
@JsonProperty
private String net_type;//网络类型
    @ApiModelProperty(value = "手机系统版本号", required = true)
    @JsonProperty
    private String system_version;//手机系统版本号
    @ApiModelProperty(value = "客户端类型", required = true)
    @JsonProperty
    private String client_type;//客户端类型
    @ApiModelProperty(value = "渠道号", required = true)
    @JsonProperty
    private String channel_sn;//渠道号
    @ApiModelProperty(value = "渠道名", required = true)
    @JsonProperty
    private String channel_name; //渠道名
    @ApiModelProperty(value = "备号uuid", required = true)
    @JsonProperty
    private String deviceId;//备号uuid
    @ApiModelProperty(value = "应用版本号", required = true)
    @JsonProperty
    private String client_version;//应用版本号
    @ApiModelProperty(value = "分辨率", required = true)
    @JsonProperty
    private String resolution;//分辨率
    @ApiModelProperty(value = "ip地址", required = true)
    @JsonProperty
    private String IPAdress;//ip地址
    @ApiModelProperty(value = "签名", required = true)
    @JsonProperty
    private String sign;
    @ApiModelProperty(value = "时间戳", required = true)
    @JsonProperty
    private String timestamp;
    @ApiModelProperty(value = "session id", required = true)
    @JsonProperty
    private String sessionId;
    @ApiModelProperty(value = "用户 id", required = false)
    @JsonProperty
    private String userUuid;
    @ApiModelProperty(value = "mac地址")
    @JsonProperty
    private String mac;
    @ApiModelProperty(value = "wifi mac地址")
    @JsonProperty
    private String wifimac;
    @ApiModelProperty(value = "LbsX 经度")
    @JsonProperty
    private String lbsX;
    @ApiModelProperty(value = "LbsX 维度")
    @JsonProperty
    private String lbsY;

    @ApiModelProperty(value = "请求类型")
    @JsonProperty
    private String keyType;

}
