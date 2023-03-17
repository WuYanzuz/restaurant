package edu.jxut.restaurant.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 9:55
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@Data
@TableName("employee")
public class Employee {
    @TableId
    private Long id;
    @TableField("username")
    private String username;
    private String name;
    @TableField("password")
    @JSONField(serialize = false)
    @JsonIgnore
    private String passWord;
    private String phone;
    private Integer sex; // 0 男 1 女
    private String idNumber;
    @JSONField(format = "yyyy,MM,mm")
//    @JsonFormat(pattern = "yyyy-MM-mm HH:mm:ss")
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
//    @JsonFormat(pattern = "yyyy-MM-mm HH:mm:ss")
    @JSONField(format = "yyyy,MM,mm")
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    private String createUser;
    private String updateUser;
    private String status;
}
