package com.bigguy.movie.moviebox.service;

/**
 * @author bigguy_hc
 * @create 2019-05-13 22:18
 */

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 获取Spring容器中Bean实例的工具类(Java泛型方法实现)。
 *
 * @author leiwen@FansUnion.cn
 */
@Component
public class SpringUtils implements ApplicationContextAware {

    public static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringUtils.context = context;
    }

    /**
     * 获取容器中的实例
     * @param beanId 注入在Spring容器中的bean的ID 默认为类名首字母小写
     * @param clazz 获取的bean的实际的类的class
     */
    public static <T> T getBean(String beanId, Class<T> clazz){
        return context.getBean(beanId, clazz);
    }

    public static <T> T getBean( Class<T> clazz){
        return context.getBean(clazz);
    }

    public static ApplicationContext getContext(){
        return context;
    }
}