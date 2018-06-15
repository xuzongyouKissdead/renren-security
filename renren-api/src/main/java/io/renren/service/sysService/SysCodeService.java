package io.renren.service.sysService;

import io.renren.form.SysCodeForm;

/**
 * 验证码业务处理
 *@author xuzongyou
 * @date 2018-06-14 17:27
 * */
public interface SysCodeService {
    //发送验证码
    void sendSysCode(SysCodeForm sysCodeForm);
    //校验验证码：注册 重置密码 绑定银行卡
    void checkSysCode(String mobile,String sysCode);

}
