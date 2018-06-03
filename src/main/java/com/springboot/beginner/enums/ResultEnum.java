package com.springboot.beginner.enums;

/**
 * @ClassName ResultEnum
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 20:51
 */
public enum ResultEnum {

    UNKOWN_ERROR(-1, "未知错误!"),
    SUCCESS(0, "SUCCESS"),
    PRIMARY_SCHOOL(100, "小学"),
    MIDDLE_SCHOOL(101, "初中");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
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
