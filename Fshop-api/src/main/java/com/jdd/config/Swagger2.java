package com.jdd.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author: L_earn
 * @Description：todo
 * @ckassName：Swagger2
 * @Date: 2020/6/14 18:14
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
    /**
     * 两种路径访问
     * 1.http://localhost:8088/swagger-ui.html#/
     * 2.http://localhost:8088/doc.html
     * @return
     */
    //配置swagger2核心配置 docket
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)  //指定api的类型为Swagger2
                .apiInfo(apiInfo())//用于定义api文档汇总信息
                .select().apis(RequestHandlerSelectors.basePackage("com.jdd.controller"))//扫描controller包
                .paths(PathSelectors.any())//所有controller
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().
                title("Fshop后端接口api"). //文档标题
                contact(new Contact("Fshop","https://www.imooc.com","L_earn@yeah.com")).//联系人信息
                description("Fshop后台接口文档").//描述信息
                version("1.0").//文档版本号
                termsOfServiceUrl("https://www.imooc.com").//网站地址
                build();
    }
}
