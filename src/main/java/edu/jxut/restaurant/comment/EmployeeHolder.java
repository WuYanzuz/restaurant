package edu.jxut.restaurant.comment;

import edu.jxut.restaurant.pojo.Employee;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 14:10
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
public class EmployeeHolder {
    private static final ThreadLocal<Employee> LOCAL=new ThreadLocal<Employee>();

    public static void setEmployee(Employee employee) {
        LOCAL.set(employee);
    }

    public static void removeEmployee(Employee employee){
        LOCAL.remove();
    }

}
