package edu.jxut.restaurant.comment;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/13 17:10
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@Data
@NoArgsConstructor
@ToString
public class Result2Web<T> {
    private String code;
    private T body;
    private String msg;

    public static <T> Result2Web<T> success(T object) {
        Result2Web<T> tResult2Web = new Result2Web<T>();
        if (ObjectUtils.isEmpty(object)) {
            tResult2Web.setCode(ResultCode.SUCCESS);
        } else {
            tResult2Web.setBody(object);
            tResult2Web.setCode(ResultCode.SUCCESS);
        }
        return tResult2Web;
    }

    public static <T> Result2Web<T> error(String failMsg) {
        Result2Web<T> tResult2Web = new Result2Web<T>();
        if (failMsg.equals("") || null == "") {
            tResult2Web.setCode(ResultCode.FAIL);
        } else {
            tResult2Web.setMsg(failMsg);
            tResult2Web.setCode(ResultCode.FAIL);
        }
        return tResult2Web;
    }
}
