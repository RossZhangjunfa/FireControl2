package com.bolijiang3d.program.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Description swagger分层配置
 * @Author      zjf
 * @Date        2020/01/02
 */
@EnableSwagger2
@Configuration
@ComponentScan(basePackages = {"com.bolijiang3d.program.controller"})
public class SwaggerConfig {
    @Value("${swagger2.enable}")
    private boolean swaggerEnable;

    /**
     * @Description web接口
     * @Author      zjf
     * @Date        2020/01/02
     * @Return      springfox.documentation.spring.web.plugins.Docket
     */
    @Bean
    public Docket webApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(swaggerEnable)
                .apiInfo(webApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("消防系统")
                .description("消防平台接口文档")
                .version("1.0.0")
                .build();
    }

}
