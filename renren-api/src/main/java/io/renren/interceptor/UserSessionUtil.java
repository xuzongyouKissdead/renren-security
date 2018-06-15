/*
package io.renren.interceptor;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.common.collect.ImmutableList;
import com.iou.common.constants.RedisContants;
import com.iou.common.enums.system.ExceptionEnum;
import com.iou.common.exceptions.BadRequestException;
import com.iou.common.exceptions.ServiceException;
import com.iou.common.models.BaseRequest;
import com.iou.common.models.LoginOrderUserSession;
import com.iou.common.models.LoginSession;
import com.iou.common.redis.RedisClient;
import io.lettuce.core.RedisClient;
import io.renren.common.Enums.ExceptionEnum;
import io.renren.common.exception.ServiceException;
import io.renren.form.BaseRequestForm;
import io.renren.form.response.SessionResponse;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


*/
/**
 * @Author  xuzongyou.
 *//*

@Slf4j
public class UserSessionUtil {

    private static List<String> list = ImmutableList.of("/system/isUpdate","/system/appH5UrlValueList");

    private static final int EXPIRES_SECOND = 30 * 60 * 60;

    public static void filter(HttpServletRequest httpRequest, RedisClient redisClient,
            BaseRequestForm baseRequest) throws ServiceException {
        Map<String, String> params = new HashMap<>();
        params.put("timestamp", baseRequest.getTimestamp());
        params.put("sessionId", baseRequest.getSessionId());

//        String version=baseRequest.getClient_version();
//        String clientType=baseRequest.getClient_type();
//        boolean tempFlag=true;
//        if(clientType.equals("android")){
//            if(version.compareTo("1.0.7")<0){
//                tempFlag=false;
//            }
//        }
//        if(tempFlag){
//            if (baseRequest.getSign() == null || baseRequest.getTimestamp() == null) {
//                throw new ServiceException(ExceptionEnum.USER_BASE_PARAMS_ILLEGAL);
//            }
//            if (!SignUtils.signVerify(baseRequest.getSign(), params)) {
//                throw new ServiceException(ExceptionEnum.SESSION_UN_LOGIN);
//            }
//        }

        if (!isContains(httpRequest.getRequestURI())) {
            validationSession(httpRequest, redisClient, baseRequest);
        }

    }

    private static void validationSession(HttpServletRequest request, RedisClient redisClient,
            BaseRequestForm baseRequest) throws ServiceException {
        String loginSessionStr = getLoginSessionStr(redisClient, baseRequest.getSessionId());
        if (loginSessionStr == null) {
            log.error("未登录");
            throw new ServiceException(ExceptionEnum.SESSION_UN_LOGIN_ERROR);
        }
        SessionResponse loginSession = JSONUtils.deserialize(loginSessionStr,SessionResponse.class);
        if (loginSession.getUserUuid().equals("0")) {
            log.error("未登录");
            throw new ServiceException(ExceptionEnum.SESSION_UN_LOGIN_ERROR);
        }
        baseRequest.setUserUuid(loginSession.getUserUuid());
    }

    private static boolean isContains(String url) {
        if (list.contains(url)) {
            return true;
        }
        return false;
    }

    */
/**
     * 创建并存本地user登陆后到sessioId
     *
     *//*

   */
/* public static void generateAndSetSessionId(RedisClient redisClient, SessionResponse loginSession) throws ServiceException {
        String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
        loginSession.setSessionId(sessionId);
        redisClient.set(SESSION_PREFIX + sessionId, JsonUtils.serialize(loginSession),EXPIRES_SECOND);
    }*//*


    */
/**
     * 得到LoginSession 对象json str
     *
     *//*

  public static String getLoginSessionStr(RedisClient redisClient, String sessionId) {
        return redisClient.get;
    }

     */
/* public static boolean delLoginSession(RedisClient redisClient, String sessionId) {
        Long delKeys = redisClient.del(SESSION_PREFIX + sessionId);
        return delKeys == null ? false : (delKeys.intValue() > 0);
    }
    *//*
*/
/**
     * h5创建并存本地user登陆后到sessioId
     *
     *//*
*/
/*
    public static void generateAndSetSessionIdForH5(RedisClient redisClient,
                                               LoginSession loginSession) throws BadRequestException {
        String sessionId = UUID.randomUUID().toString().replaceAll("-", "");
        loginSession.setSessionId(sessionId);
        redisClient.set(SESSION_PREFIX + sessionId, JsonUtils.serialize(loginSession),3*60*60);
    }

    *//*
*/
/**
     * 创建并保存userUuid和orderNo session
     *
     *//*
*/
/*
    public static void generateUserOrderSessionId(RedisClient redisClient,String userUuid,String orderNo) throws BadRequestException {
        LoginOrderUserSession loginOrderUserSession=new LoginOrderUserSession(userUuid,orderNo);
        redisClient.set(RedisContants.SESSION_H5_USER_ORDER_PREFIX + userUuid, JsonUtils.serialize(loginOrderUserSession),24 * 60 * 60);
    }

    *//*
*/
/**
     * 根据userUuid获取订单
     * @param redisClient
     * @param userUuid
     * @return
     *//*
*/
/*
    public static LoginOrderUserSession getGenerateUserOrderSessionId(RedisClient redisClient,String userUuid) throws ServiceException {
        String s = redisClient.get(RedisContants.SESSION_H5_USER_ORDER_PREFIX + userUuid);
        if(s==null){
            log.error("当前用户还没有h5订单");
            throw new ServiceException(ExceptionEnum.USER_H5_USER_ORDER_IS_NULL);
        }
        return JsonUtils.deserialize(s,LoginOrderUserSession.class);
    }
*//*

}
*/
