package edu.jxut.restaurant.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import edu.jxut.restaurant.comment.Result2Web;
import edu.jxut.restaurant.pojo.Employee;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 10:59
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
public interface EmployeeServer {
    public Result2Web<Employee> userLogin(String password, String name,HttpServletRequest request);

    public Result2Web<Page<Employee>> getEmployeesByPage(Integer page, Integer size, String name);

    public Result2Web<String> setStatus (Employee employee);

    public Result2Web<Employee> queryById(String id);

    public Result2Web<String> addEmo(Employee employee);
}
