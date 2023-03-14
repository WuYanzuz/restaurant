package edu.jxut.restaurant.orm;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.util.DigestUtils;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 11:24
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@Slf4j
public class MD5test {

    @Test
    public void conv(){
        log.error(DigestUtils.md5DigestAsHex("wuYanzu123456".getBytes()));

    }
}
