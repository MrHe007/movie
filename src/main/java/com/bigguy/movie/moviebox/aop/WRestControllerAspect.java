package com.bigguy.movie.moviebox.aop;/**
 * @author shkstart
 * @create 2019-03-21 13:24
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author hechen
 * @data 2019/3/21
 *
 */
//@Aspect
@Component
public class WRestControllerAspect {

    Logger logger = LoggerFactory.getLogger(WRestControllerAspect.class);

    // 拦截所有来自 web 的请求数据
//    @Pointcut("execution(* com.bigguy.movie.moviebox.controller.*RestController.*(..))")
    public void  wData(){}

//    @Around("wData()")
//    public Object storeDataToRedis(ProceedingJoinPoint joinPoint){
//        Signature signature =  joinPoint.getSignature();
//        // 获得返回值类型
//        Class returnType = ((MethodSignature) signature).getReturnType();
//        Object rtValue = null;
//        try {
//            HttpServletRequest httpRequest = PublicUtils.getHttpRequest();
//            // 本系统的API url+ 请求参数
//            String requestURI = httpRequest.getRequestURI();
//            if(httpRequest.getQueryString() != null){        // 如果有请求参数 就加上
//                requestURI +=  httpRequest.getQueryString();
//            }
//
//            logger.info("requestUrl : "+requestURI);
//            // 拿到redisService 实例
//            RedisService redisService = SpringUtils.getBean(RedisService.class);
//            // 如果该链接存在redis中就从redis中拿数据
//            if(redisService.containsKeyHashMap(CommonConstant.MOV,requestURI)){
//                logger.info(requestURI+" 这个key在 redis中，准备从redis中拿数据");
//                String jsonObjStr = redisService.getHashMap(CommonConstant.MOV, requestURI);     // 拿到Redis里面的数据
//                rtValue = JSON.parseObject(jsonObjStr, returnType);             // fastJson
//
//            }else {
//                logger.info(requestURI+" 这个key不在 redis中，准备执行对应Controller 方法取数据");
//                // 执行连接点方法拿到数据，存到redis中
//                rtValue = joinPoint.proceed();
//                // 指定存活时间
//                redisService.setHashMapWithTime(CommonConstant.MOV,requestURI, JSON.toJSONString(rtValue),60*60*24);
//            }
//
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//        }
//        return rtValue;
//    }

}
