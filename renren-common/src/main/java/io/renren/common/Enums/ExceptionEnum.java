package io.renren.common.Enums;
import java.text.MessageFormat;
public enum ExceptionEnum {
    USER_CHECK_SMS_CODE_ERROR(1001, "短信验证码不正确"),
    USER_CHECK_SMS_CODE_REDIS_OUTDATE_ERROR(1002, "短信验证码已过期"),
    USER_CHECK_SMS_CODE_REDIS_NULL_ERROR(1003, "短信验证码已过期"),
    USER_REGISTER_FAILED_ERROR(1004, "注册失败，请重新注册"),
    SESSION_UN_LOGIN_ERROR(1005, "您还没有登录哦"),
    USER_LOGIN_PASSWORD_ERROR(1006, "手机号或密码错误")
    ;
    private int code;
    private String message;
    private String temlate;

    private ExceptionEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private ExceptionEnum(int code, String message, String template) {
        this.code = code;
        this.message = message;
        this.temlate = template;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ExceptionEnum setCustomMessage(String message) {
        this.setMessage(message);
        return this;
    }

    /**
     * 根据占位符填充动态信息
     * @param ags
     * @return
     */
    public ExceptionEnum setDynamicMessage(Object... ags){
        String dynamicMsg= MessageFormat.format(this.temlate,ags);
        this.setMessage(dynamicMsg);
        return this;
    }

}