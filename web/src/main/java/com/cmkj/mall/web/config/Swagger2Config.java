package com.cmkj.mall.web.config;

import com.cmkj.mall.common.api.ResultCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.PathProvider;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.DocumentationContextBuilder;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Swagger2API文档的配置
 * Created by cmkj on 2018/4/26.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        // 配置全局参数返回状态
        java.util.List<ResponseMessage> resMsgList = Arrays.asList(
                new ResponseMessageBuilder().code(ResultCode.SUCCESS.getCode()).message(ResultCode.SUCCESS.getMessage()).build(),
                new ResponseMessageBuilder().code(ResultCode.FAILED.getCode()).message(ResultCode.FAILED.getMessage()).build(),
                new ResponseMessageBuilder().code(ResultCode.EMPTY_RESULT.getCode()).message(ResultCode.EMPTY_RESULT.getMessage()).build(),
                new ResponseMessageBuilder().code(ResultCode.SERVER_ERROR.getCode()).message(ResultCode.SERVER_ERROR.getMessage()).build(),
                new ResponseMessageBuilder().code(ResultCode.REQUEST_PARAM_VALID_FAILED.getCode()).message(ResultCode.REQUEST_PARAM_VALID_FAILED.getMessage())
                        .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .securityContexts(securityContexts())
                .securitySchemes(securitySchemes())
                .globalResponseMessage(RequestMethod.GET, resMsgList)
                .globalResponseMessage(RequestMethod.POST, resMsgList)
                .globalResponseMessage(RequestMethod.PUT, resMsgList)
                .globalResponseMessage(RequestMethod.DELETE, resMsgList);

//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.cmkj.mall"))
//                .paths(PathSelectors.any())
//                .build()
//                .securitySchemes(securitySchemes())
//                .securityContexts(securityContexts());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("创敏商城")
                .description("移动端内部API接口")
                .version("1.0").contact(new Contact("cmkj","http://www.98htcz.com","swallowff@163.com"))
                .build();
    }

    private List<ApiKey> securitySchemes() {
        //设置请求头信息
        List<ApiKey> result = new ArrayList<>();
        ApiKey apiKey = new ApiKey("Authorization", "Authorization", "123456");
        result.add(apiKey);
        return result;
    }

    private List<SecurityContext> securityContexts() {
        //设置需要登录认证的路径
        List<SecurityContext> result = new ArrayList<>();
        result.add(getContextByPath("/brand/.*"));
        result.add(getContextByPath("/product/.*"));
        result.add(getContextByPath("/productCategory/.*"));
        return result;
    }

    private SecurityContext getContextByPath(String pathRegex){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex(pathRegex))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        List<SecurityReference> result = new ArrayList<>();
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        result.add(new SecurityReference("Authorization", authorizationScopes));
        return result;
    }
}
