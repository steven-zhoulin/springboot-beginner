package com.springboot.beginner.handle;

import com.springboot.beginner.domain.Result;
import com.springboot.beginner.exception.GirlException;
import com.springboot.beginner.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName ExceptionHandle
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 20:24
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger LOG = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        if (e instanceof GirlException) {
            Integer code = ((GirlException) e).getCode();
            return ResultUtil.failure(code, e.getMessage());
        } else {
            LOG.error(e.getMessage());
            return ResultUtil.failure(-1, e.getMessage());
        }

    }

}
