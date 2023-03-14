package edu.jxut.restaurant;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/13 17:03
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@SpringBootApplication
@ServletComponentScan
@Slf4j
public class RestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestApplication.class,args);
        log.info("项目启动成功");
    }
}
