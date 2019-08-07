package com.xblog.open.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * swagger配置类
 * Created by Administrator on 2017/7/19.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {



    @Bean
    public Docket createRestApi() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("test")
                .genericModelSubstitutes(DeferredResult.class)
                .useDefaultResponseMessages(false)
                .forCodeGeneration(true)
                .pathMapping("/")// base，最终调用接口后会和paths拼接在一起
                .select()
                .paths(Predicates.or(PathSelectors.regex("/api/.*")))//过滤的接口
                .build()
                .apiInfo(testApiInfo());

        return docket;
    }

    private ApiInfo testApiInfo() {

        ApiInfo apiInfo = new ApiInfo("博客",//大标题
                "博客相关接口，主要用于测试.",//小标题
                "1.0",//版本
                "http://localhost:8090",
                "javamanual",//作者
                "javamanual",//链接显示文字
                "http://ww.javamanual.com"//网站链接
        );
        return apiInfo;

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("更多Spring Boot相关文章请关注：http://blog.didispace.com/")
                .termsOfServiceUrl("http://blog.didispace.com/")
                .contact("程序猿DD")
                .version("1.0")
                .build();
    }


}
