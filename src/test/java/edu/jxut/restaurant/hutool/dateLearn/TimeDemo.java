package edu.jxut.restaurant.hutool.dateLearn;

import cn.hutool.Hutool;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.date.Month;
import cn.hutool.core.date.TimeInterval;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/15 10:07
 * @CreatedBy IntelliJ IDEA
 * @Details HuTool TIME 工具使用
 */
@Slf4j
public class TimeDemo {

    @Test
    public void openTime(){
        //年龄计算
        int age = DateUtil.age(new Date(950753983000L), new Date());
        log.info("aaa");
        log.debug("www");
        log.error(age+"");

    }
}
