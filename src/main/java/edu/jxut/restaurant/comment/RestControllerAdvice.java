package edu.jxut.restaurant.comment;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 9:15
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@ControllerAdvice()
@ResponseBody
@Slf4j
public class RestControllerAdvice {
    @ExceptionHandler(Exception.class)
    public Result2Web checkException(Exception e){
        log.error("抓住异常{}",e.getMessage());
        return Result2Web.error(e.getMessage());
    }
}
