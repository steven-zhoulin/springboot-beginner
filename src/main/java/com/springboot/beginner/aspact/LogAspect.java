package com.springboot.beginner.aspact;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HttpAspect
 * @Description TODO
 * @auther steven.zhou
 * @date 2018/06/03 16:24
 */

@Aspect
@Component
public class LogAspect {

    private static final Logger LOG = LoggerFactory.getLogger(LogAspect.class);

    /**
     * 设定一个切入点
     */
    @Pointcut("execution(public * com.springboot.beginner.controller.GirlController.*(..))")
    public void grilPointcut() {

    }

    @Before("grilPointcut()")
    public void doBefore(JoinPoint joinPoint) {

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();

        LOG.info("url: {}", httpServletRequest.getRequestURL());
        LOG.info("method: {}", httpServletRequest.getMethod());
        LOG.info("ip: {}", httpServletRequest.getRemoteAddr());
        LOG.info("class_method: {}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        LOG.info("args: {}", joinPoint.getArgs());

        LOG.info("<<<<<<<<<<<<<<<<<<<<<< Before >>>>>>>>>>>>>>>>>>>>>");
    }

    @After("grilPointcut()")
    public void doAfter() {
        LOG.info("<<<<<<<<<<<<<<<<<<<<<< After >>>>>>>>>>>>>>>>>>>>>>");
    }

    @AfterReturning(pointcut = "grilPointcut()", returning = "object")
    public void doAfterReturning(Object object) {
        LOG.info("response={}", object.toString());
        LOG.info("<<<<<<<<<<<<<<<<<<<<<< AfterReturning >>>>>>>>>>>>>>>>>>>>>>");
    }

}
