package edu.jxut.restaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.jxut.restaurant.comment.EmployeeHolder;
import edu.jxut.restaurant.comment.Result2Web;
import edu.jxut.restaurant.mapper.EmployeeMapper;
import edu.jxut.restaurant.pojo.Employee;
import edu.jxut.restaurant.service.EmployeeServer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 11:01
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@Service
public class EmployeeServerImpl implements EmployeeServer {


    private String salt;

    private final EmployeeMapper employeeMapper;

    public EmployeeServerImpl(EmployeeMapper employeeMapper,@Value("${rest.salt}")String salt) {
        this.employeeMapper = employeeMapper;
        this.salt=salt;
    }

    @Override
    public Result2Web<Map> userLogin(String password, String name, HttpServletRequest request) {
        String asHashPassWord = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<Employee>();
        queryWrapper.eq(Employee::getUserName,name).eq(Employee::getPassWord,asHashPassWord);
        Employee employee = employeeMapper.selectOne(queryWrapper);
        Result2Web<Map> mapResult2Web = new Result2Web<>();
        if (ObjectUtils.isEmpty(employee)){
            mapResult2Web.setCode("0");
            mapResult2Web.setMsg("登录失败");
        }else {
            request.getSession().setAttribute("employee",employee.getId());
            EmployeeHolder.setEmployee(employee);
            mapResult2Web.setCode("1");
        }
        return mapResult2Web;
    }

    @Override
    public Result2Web<List<Employee>> getEmployeesByPage(Integer page, Integer size, String name) {
        Page<Employee> employeePage = new Page<>();
        employeePage.setPages(page);
        employeePage.setSize(size);

        Page<Employee> employeeResult = employeeMapper.selectPage(employeePage, new LambdaQueryWrapper<Employee>().eq(StringUtils.isNoneBlank(name),Employee::getUserName,name));
        List<Employee> list = employeePage.getRecords();

        return Result2Web.success(list);
    }
}
