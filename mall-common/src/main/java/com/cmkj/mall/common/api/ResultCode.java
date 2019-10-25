package com.cmkj.mall.common.api;

/**
 * 枚举了一些常用API操作码
 * Created by cmkj on 2019/4/19.
 */
public enum ResultCode implements IErrorCode {
    SUCCESS(200, "操作成功"),
    FAILED(500, "操作失败"),
    SERVER_ERROR(600,"服务器出错了"),
    VALIDATE_FAILED(404, "参数检验失败"),
    UNAUTHORIZED(401, "暂未登录或token已经过期"),
    FORBIDDEN(403, "没有相关权限"),

    REQUEST_PARAM_VALID_FAILED(900,"请求参数校验失败"),
    EMPTY_RESULT(901,"没有更多数据了")
    ;

    private Integer code;
    private String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
