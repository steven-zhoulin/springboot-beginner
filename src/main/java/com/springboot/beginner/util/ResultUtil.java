package com.springboot.beginner.util;

import com.springboot.beginner.domain.Result;

/**
 * @ClassName ResultUtil
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 17:24
 */
public class ResultUtil {

    public static Result success() {
        Result result = new Result();
        result.setCode(0);
        result.setMessage("SUCCESS");
        return result;
    }

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(0);
        result.setMessage("SUCCESS");
        result.setData(object);
        return result;
    }

    public static Result failure(Integer code, String message) {
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    
}
