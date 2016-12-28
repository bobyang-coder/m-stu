package com.bob.stu.hello;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常捕获
 *
 * @author bob
 * @since 2016-11-13 22:37
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public void defaultErrorHandler(HttpServletRequest request, Exception e) {
        //打印异常信息：
        e.printStackTrace();
        System.out.println("----------GlobalDefaultExceptionHandler.defaultErrorHandler()");
    }
}
