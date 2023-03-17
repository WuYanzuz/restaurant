package edu.jxut.restaurant.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.jxut.restaurant.comment.Result2Web;
import edu.jxut.restaurant.comment.ResultCode;
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
    public Result2Web<Employee> userLogin(String password, String name, HttpServletRequest request) {
        String asHashPassWord = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<Employee>();
        queryWrapper.eq(Employee::getUsername,name).eq(Employee::getPassWord,asHashPassWord);
        Employee employee = employeeMapper.selectOne(queryWrapper);
        Result2Web<Employee> mapResult2Web = new Result2Web<>();
        if (ObjectUtils.isEmpty(employee)){
            mapResult2Web.setCode(ResultCode.FAIL);
            mapResult2Web.setMsg("登录失败");
        }else {
            request.getSession().setAttribute("userInfo",employee);
            mapResult2Web.setData(employee);
            mapResult2Web.setCode(ResultCode.SUCCESS);
        }
        return mapResult2Web;
    }

    @Override
    public Result2Web<Page<Employee>> getEmployeesByPage(Integer page, Integer size, String name) {
        Page<Employee> employeePage = new Page<>();
        employeePage.setPages(page);
        employeePage.setSize(size);

        Page<Employee> employeeResult = employeeMapper.selectPage(employeePage, new LambdaQueryWrapper<Employee>().eq(StringUtils.isNoneBlank(name),Employee::getUsername,name));
        return Result2Web.success(employeeResult);
    }

    @Override
    public Result2Web<String> setStatus(Employee employee) {
        employeeMapper.updateById(employee);
        return Result2Web.success("员工信息修改成功");
    }


    @Override
    public Result2Web<Employee> queryById(String id) {
        return Result2Web.success(employeeMapper.selectById(id));
    }

    @Override
    public Result2Web<String> addEmo(Employee employee) {
        employeeMapper.insert(employee);
        return Result2Web.success("添加成功");
    }
}
