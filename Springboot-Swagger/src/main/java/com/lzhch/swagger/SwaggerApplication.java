package com.lzhch.swagger;

import com.google.common.base.Predicates;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @packageName： com.lzhch.swagger
 * @className: SwaggerApplication
 * @description: TODO
 * @version: v1.0
 * @author: liuzhichao
 * @date: 2020-05-20 15:11
 */
@SpringBootApplication
@EnableSwagger2
public class SwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SwaggerApplication.class, args);
        System.out.println("<--------start--------->");
    }

    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 指定要暴露给 swagger 来展示的接口所在的包 RequestHandlerSelectors.basePackage("com.lzhch")可以指定包 any 是所有
                .apis(RequestHandlerSelectors.any())
                // PathSelectors.any() 表示所有路径都放行
                .paths(
                        //PathSelectors.any()
                        Predicates.or(
                        // 过滤显示接口
                        PathSelectors.regex("/users" + ".*"),
                        PathSelectors.regex("/url" + ".*")
                        )
                )
                .build();
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                // 标题
                .title("System API Doc")
                // 描述
                .description("系统接口测试.")
                // 联系人
                .contact(new Contact("liuzhichao", null,"www.liuzhichao00@163.com"))
                // 版本
                .version("1.0")
                .build();
    }

}
