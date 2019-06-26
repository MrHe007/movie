package com.bigguy.movie.moviebox.utils;

import com.bigguy.movie.moviebox.resource.MovieUrlProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.DefaultParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bigguy_hc
 * @create 2019-05-11 16:30
 */
public class PublicUtils {

    // 封装 apiKey

    private static HashMap<String, Class> map = new HashMap<String, Class>() {
        {
            put("java.lang.Integer", int.class);
            put("java.lang.Double", double.class);
            put("java.lang.Float", float.class);
            put("java.lang.Long", long.class);
            put("java.lang.Short", short.class);
            put("java.lang.Boolean", boolean.class);
            put("java.lang.Char", char.class);
        }
    };


    @Autowired
    MovieUrlProperties properties;

    public static String parseKeyFromJointPoint(ProceedingJoinPoint joinPoint){
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        String params = null;
        try {
            params = getFieldsName(joinPoint);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
// 以方法形式返回作为key
        return classType +"."+ methodName + params;
    }


    public static String getFieldsName(ProceedingJoinPoint joinPoint) throws ClassNotFoundException, NoSuchMethodException {
        String classType = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        // 参数值
        Object[] args = joinPoint.getArgs();
        Class<?>[] classes = new Class[args.length];
        for (int k = 0; k < args.length; k++) {
            classes[k] = args[k].getClass();
        }
        ParameterNameDiscoverer pnd = new DefaultParameterNameDiscoverer();
        // 获取指定的方法，第二个参数可以不传，但是为了防止有重载的现象，还是需要传入参数的类型
        Method method = Class.forName(classType).getMethod(methodName, classes);
        // 参数名
        String[] parameterNames = pnd.getParameterNames(method);
        // 通过map封装参数和参数值
        HashMap<String, Object> paramMap = new HashMap();
        for (int i = 0; i < parameterNames.length; i++) {
            paramMap.put(parameterNames[i], args[i]);
        }

        String s = paramMap.toString();

        return s;
    }

    // 分页的两个参数都不为 null，表示可以分页
    public static String parsePageParam(Integer start, Integer count){

        String query = "";
        if(start!=null){
            query += "&start="+start;
        }
        if(count!=null){
            query += "&count=" +count;
        }
        return query;
    }


    public static boolean notNull(Integer num){
        return num!=null;
    }

    // 数字不为0，或者是 null 即为有效数字
    public static boolean isEffectiveNum(Integer num){

        if(num!=null && num!=0){
            return true;
        }
        return false;
    }


    public static HttpServletRequest getHttpRequest(){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        return request;
    }

    public static String getHeadTagKey(String url){
        return url.substring(url.indexOf("?")+1);
    }

    public static Map<String,String> getMapByElement(Element element){
        Map<String,String> temMap = new HashMap<>();
        temMap.put("name", element.text());
        temMap.put("url", element.attr("href"));
        return temMap;
    }

}
