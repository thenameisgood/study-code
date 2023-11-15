package com.wang.enums;

public enum HttpCodeEnum {
    // 成功
    SUCCESS(200, "成功"),
    NEED_LOGIN(401,"需要登录"),
    NO_OPERATOR_AUTH(501,"没有权限"),
    SYSTEM_ERROR(502,"认证失败");

    int code;
    String msg;

    HttpCodeEnum(int code, String errorMessage) {
        this.code = code;
        this.msg = errorMessage;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}


