package edu.jxut.restaurant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.jxut.restaurant.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author Mengyuan Zhang
 * @Date 2023/3/14 9:51
 * @CreatedBy IntelliJ IDEA
 * @Details
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {

    public Employee selectByEm(@Param("epp")Employee employee);
}
