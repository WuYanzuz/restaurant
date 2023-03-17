package edu.jxut.restaurant.comment;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/15 9:38
 * @CreatedBy IntelliJ IDEA
 * @Details 自动填充公共字段
 */
@Component
public class MyAutoFillColumns implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //时间
        Object createTime = getFieldValByName("createTime", metaObject);
        boolean empty = ObjectUtils.isEmpty(createTime);
        if (empty) {
            setFieldValByName("createTime",new Date(),metaObject);
        }
        Object updateTime = getFieldValByName("updateTime", metaObject);
        boolean empty1 = ObjectUtils.isEmpty(updateTime);
        if (empty1){
            setFieldValByName("updateTime",new Date(),metaObject);
        }

        //操作员
        Object createUser = getFieldValByName("createUser", metaObject);
        boolean empty2 = ObjectUtils.isEmpty(createTime);
        if (empty2) {
            setFieldValByName("createUser",EmployeeHolder.get().getId(),metaObject);
        }

        Object updateUser = getFieldValByName("updateUser", metaObject);
        boolean empty3 = ObjectUtils.isEmpty(createTime);
        if (empty3) {
            setFieldValByName("updateUser",EmployeeHolder.get().getId(),metaObject);
        }

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //时间
        Object updateTime = getFieldValByName("updateTime", metaObject);
        boolean empty1 = ObjectUtils.isEmpty(updateTime);
        if (empty1){
            setFieldValByName("updateTime",new Date(),metaObject);
        }

        //操作员
        Object updateUser = getFieldValByName("updateUser", metaObject);
        boolean empty = ObjectUtils.isEmpty(updateUser);

        if (empty){
            setFieldValByName("updateUser",EmployeeHolder.get().getId(),metaObject);
        }

    }
}
