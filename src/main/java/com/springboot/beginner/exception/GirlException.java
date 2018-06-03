package com.springboot.beginner.exception;

import com.springboot.beginner.domain.Girl;
import com.springboot.beginner.enums.ResultEnum;

/**
 * @ClassName GirlException
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 20:42
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
