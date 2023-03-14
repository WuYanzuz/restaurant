package edu.jxut.restaurant.service;

import edu.jxut.restaurant.comment.Result2Web;
import edu.jxut.restaurant.pojo.Employee;


import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 10:59
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
public interface EmployeeServer {
    public Result2Web<Map> userLogin(String password, String name,HttpServletRequest request);

    public Result2Web<List<Employee>> getEmployeesByPage(Integer page, Integer size, String name);
}
