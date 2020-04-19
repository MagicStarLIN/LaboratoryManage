package com.lcl.labmanage.entity;

public enum ResultCode {
    SUCCESS(0, "成功"),
    REPEAT_NAME(401, "用户名重复"),
    USER_ABSENCE(402, "用户不存在"),
    NULL_DATA(403, "无数据"),
    AREADY_OCCUPIED(406, "实验室已经被占用"),
    ILLEGAL_COUNT(407, "非法数量"),
    REPEAT_DEVICE(408, "重复设备"),

    ERROR(500,"未知错误")
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
