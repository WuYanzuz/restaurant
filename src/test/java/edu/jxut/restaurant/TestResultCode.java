package edu.jxut.restaurant;

import edu.jxut.restaurant.comment.Result2Web;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/13 17:26
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@SpringBootTest(classes = RestApplication.class)
@Slf4j
public class TestResultCode {

    @Test
    public void Test2Code(){
        HashMap map = new HashMap();
        map.put("name","zz");
        Result2Web<Map> success = Result2Web.success(map);
        log.error(success.toString());
    }
}
