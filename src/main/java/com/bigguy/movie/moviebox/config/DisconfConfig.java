package com.bigguy.movie.moviebox.config;/**
 * @Auther: hechen
 * @Date: 2019/4/23 16:18
 * @Description: ...
 */

import org.springframework.context.annotation.Configuration;

/**
 * @author hechen
 * @data 2019/4/23
 */

@Configuration
public class DisconfConfig {


//    @Bean(destroyMethod = "destroy")
//    public DisconfMgrBean disconfMgrBean(){
//        DisconfMgrBean disconfMgrBean = new DisconfMgrBean();
//        disconfMgrBean.setScanPackage("no_used");
//        return disconfMgrBean;
//    }
//
//    @Bean(initMethod = "init", destroyMethod = "destroy")
//    public DisconfMgrBeanSecond disconfMgrBeanSecond(){
//        return new DisconfMgrBeanSecond();
//    }
//
//    @Bean(name = "reloadablePropertiesFactoryBean")
//    @AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE)
//    public ReloadablePropertiesFactoryBean reloadablePropertiesFactoryBean() {
//        ReloadablePropertiesFactoryBean propertiesFactoryBean = new ReloadablePropertiesFactoryBean();
//        propertiesFactoryBean.setSingleton(true);
//
//        // disconf 配置文件 (这里只有application.properties)
//        List<String> fileNames = new ArrayList<>();
//        fileNames.add("classpath:druid.properties");
//
//        propertiesFactoryBean.setLocations(fileNames);
//        return propertiesFactoryBean;
//    }
//
//    @Bean(name = "propertyPlaceholderConfigurer")
//    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(ReloadablePropertiesFactoryBean reloadablePropertiesFactoryBean){
//        PropertyPlaceholderConfigurer placeholderConfigurer = new PropertyPlaceholderConfigurer();
//        placeholderConfigurer.setIgnoreResourceNotFound(false);
//        placeholderConfigurer.setIgnoreUnresolvablePlaceholders(false);
//        try {
//            Properties properties = reloadablePropertiesFactoryBean.getObject();
//            placeholderConfigurer.setProperties(properties);
//        } catch (IOException e) {
//            throw new RuntimeException("unable to find properties", e);
//        }
//        return placeholderConfigurer;
//    }

}
