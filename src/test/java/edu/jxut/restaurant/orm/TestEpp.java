package edu.jxut.restaurant.orm;

import com.alibaba.fastjson.JSON;
import edu.jxut.restaurant.mapper.EmployeeMapper;
import edu.jxut.restaurant.pojo.Employee;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 10:34
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@SpringBootTest
@Data
@Slf4j
public class TestEpp {

    public TestEpp(@Autowired EmployeeMapper employee){
        this.mapper=employee;
    }
    private EmployeeMapper mapper;

    @Test
    public void select(){
        Employee employee = new Employee();
        employee.setId(1L);
        Employee employee1 = mapper.selectByEm(employee);
        log.error(JSON.toJSONString(employee1));
    }
}
