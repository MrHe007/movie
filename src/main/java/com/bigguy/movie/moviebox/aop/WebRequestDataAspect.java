package com.bigguy.movie.moviebox.aop;
/**
 * @author shkstart
 * @create 2019-03-21 13:24
 */

import com.alibaba.fastjson.JSON;
import com.bigguy.movie.moviebox.service.RedisService;
import com.bigguy.movie.moviebox.service.SpringUtils;
import com.bigguy.movie.moviebox.utils.CommonConstant;
import com.bigguy.movie.moviebox.utils.PublicUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author hechen
 * @data 2019/3/21
 *
 */
@Aspect
@Component
public class WebRequestDataAspect {

    Logger logger = LoggerFactory.getLogger(WebRequestDataAspect.class);

    // 所有请求网络资源数都要执行 MyHttpClientUtils 方法拿到数据
    @Pointcut("execution(* com.bigguy.movie.moviebox.service.NewPublicApiService.*(..))")
    public void  webData(){}

    @Around("webData()")
    public Object storeReqDataToRedis(ProceedingJoinPoint joinPoint) throws Exception {
        Signature signature =  joinPoint.getSignature();
        // 获得返回值类型
        Class returnType = ((MethodSignature) signature).getReturnType();


        String url = PublicUtils.parseKeyFromJointPoint(joinPoint);       // 拿到请求网络的 url

        Object rtValue = null;
        try {
            logger.info("url : "+url);
            // 拿到redisService 实例
            RedisService redisService = SpringUtils.getBean(RedisService.class);
            // 如果该链接存在redis中就从redis中拿数据
            if(redisService.containsKeyHashMap(CommonConstant.MOV,url)){
                logger.info(url+" exists!");
                String jsonObjStr = redisService.getHashMap(CommonConstant.MOV, url);     // 拿到Redis里面的数据
                rtValue = JSON.parseObject(jsonObjStr, returnType);             // fastJson

            }else {
                logger.info(url+" not exists!");
                // 执行连接点方法拿到数据，存到redis中
                rtValue = joinPoint.proceed();
                // 指定存活时间
                redisService.setHashMapWithTime(CommonConstant.MOV,url, JSON.toJSONString(rtValue),60*60*24);
            }
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return rtValue;
    }

}
