package io.renren.service.impl.sys;
import io.renren.common.Enums.ExceptionEnum;
import io.renren.common.exception.ServiceException;
import io.renren.common.utils.RedisUtils;
import io.renren.form.SysCodeForm;
import io.renren.models.ApiRedisKeys;
import io.renren.service.sysService.SysCodeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sysCodeService")
public class SysCodeServiceImpl implements SysCodeService{
    @Autowired
    RedisUtils redisUtils;
    //发送短信验证码你那个存储到缓存
    @Override
    public void sendSysCode(SysCodeForm sysCodeForm) {
        if(!StringUtils.isEmpty(sysCodeForm.getMobile())){
            //第三方渠道：短信发送，待定。
            String SysCode = "123456";


            String sysCodeKey= ApiRedisKeys.getSysCodeKey(sysCodeForm.getMobile());
            redisUtils.set(sysCodeKey,SysCode,redisUtils.SYSCODE_EXPIRE);
        }
    }

    //校验验证码
    @Override
    public void checkSysCode(String mobile, String sysCode) {
        String SysCodeKey = ApiRedisKeys.getSysCodeKey(mobile);
        String SysCodeRedisValue =redisUtils.get(SysCodeKey);
        if(!StringUtils.isEmpty(sysCode)){
            if(!StringUtils.isEmpty(SysCodeRedisValue)){
                if(!SysCodeRedisValue.equals(sysCode)){
                    try {
                        throw new ServiceException(ExceptionEnum.USER_CHECK_SMS_CODE_ERROR);
                    } catch (ServiceException e) {
                        e.printStackTrace();
                    }
                }
            }else{
                try {
                    throw new ServiceException(ExceptionEnum.USER_CHECK_SMS_CODE_REDIS_OUTDATE_ERROR);
                } catch (ServiceException e) {
                    e.printStackTrace();
                }
            }
        }else{
            try {
                throw new ServiceException(ExceptionEnum.USER_CHECK_SMS_CODE_REDIS_NULL_ERROR);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
        }
    }

}
