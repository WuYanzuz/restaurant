package edu.jxut.restaurant.orm;

import com.alibaba.fastjson.JSON;
import edu.jxut.restaurant.comment.Result2Web;
import edu.jxut.restaurant.mapper.EmployeeMapper;
import edu.jxut.restaurant.pojo.Employee;
import edu.jxut.restaurant.service.EmployeeServer;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.DigestUtils;

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

    @Autowired
    private EmployeeServer employeeServer;

    @Test
    public void select(){
        Employee employee = new Employee();
        employee.setId(1L);
        Employee employee1 = mapper.selectByEm(employee);
        log.error(JSON.toJSONString(employee1));
    }


    @Test
    public void setIn(){
        Employee employee = new Employee();
        employee.setName("沙师弟");
        employee.setIdNumber("10101111111");
        employee.setPassWord((DigestUtils.md5DigestAsHex("wuYanzu123456".getBytes())));
        employee.setPhone("13208089921");
        employee.setSex(1);
        employee.setCreateUser("1");
        employee.setUpdateUser("1");
        employee.setUsername("admin3");
        mapper.insert(employee);
    }

    @Test
    public void empResult(){
        Result2Web<Employee> employeeResult2Web = employeeServer.queryById("1635835300145180674");
        log.error(JSON.toJSONString(employeeResult2Web));
    }
}
