package com.jdd.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * @Author: L_earn
 * @Description：todo
 * @ckassName：CorsConfig
 * @Date: 2020/6/16 22:07
 */
@Configuration
public class CorsConfig {
    public CorsConfig() {

    }

    @Bean
    public CorsFilter corsFilter(){
        //1.添加配置
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //设置允许访问本服务(本容器)的路径
        corsConfiguration.addAllowedOrigin("http://localhost:8080");
        //2.设置是否发送cookie信息
        corsConfiguration.setAllowCredentials(true);
        //3.放行的请求方式
        corsConfiguration.addAllowedMethod("*");
        //4.设置允许的header
        corsConfiguration.addAllowedHeader("*");
        //5.为url添加映射
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        //6.返回重新定义好的corSource
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }
}
