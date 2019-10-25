package com.cmkj.mall.portal.config;

import com.cmkj.mall.common.api.ResultCode;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

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

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build()
                .globalResponseMessage(RequestMethod.GET, resMsgList)
                .globalResponseMessage(RequestMethod.POST, resMsgList)
                .globalResponseMessage(RequestMethod.PUT, resMsgList)
                .globalResponseMessage(RequestMethod.DELETE, resMsgList);

//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.cmkj.mall.portal.controller"))
//                .paths(PathSelectors.any())
//                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("mall前台系统")
                .description("mall前台系统")
                .version("1.0")
                .build();
    }
}
