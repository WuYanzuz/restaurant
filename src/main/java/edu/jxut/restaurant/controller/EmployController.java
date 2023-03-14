package edu.jxut.restaurant.controller;

import edu.jxut.restaurant.comment.Result2Web;
import edu.jxut.restaurant.service.EmployeeServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 11:19
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployController {

    @Autowired
    private EmployeeServer employeeServer;

    @PostMapping("/login")
    public Result2Web userLogin(@RequestBody Map<String,String> param,HttpServletRequest request){
        String password = param.get("password");
        String username = param.get("username");
        return employeeServer.userLogin(password,username,request);
    }

    @GetMapping("/page")
    public Result2Web getEmpByPage(@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize, @RequestParam(value = "name",required = false)String name){
        return employeeServer.getEmployeesByPage(page,pageSize,name);
    }
}
