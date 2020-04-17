package com.lcl.labmanage.entity;

public enum ResultCode {
    SUCCESS(0, "成功"),
    REPEAT_NAME(401, "用户名重复"),
    USER_ABSENCE(402, "用户不存在"),

    ERROR(500,"错误")
    ;


    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
