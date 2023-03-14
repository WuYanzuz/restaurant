package edu.jxut.restaurant.comment;

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
public class RestControllerAdvice {
    @ExceptionHandler(Exception.class)
    public Result2Web checkException(Exception e){
        return Result2Web.error(e.getMessage());
    }
}
