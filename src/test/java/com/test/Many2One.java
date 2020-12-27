package com.test;

import com.offcn.entity.Employee;
import com.offcn.mapper.EmployeeMapper;
import com.offcn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Many2One {
    @Test
    public void getEmployeeById() {
        SqlSession session = MybatisUtils.getSession();
        EmployeeMapper employeeMapper = session.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmployeeById(3);
        System.out.println(employee.getName() + " " + employee.getDepart().getName());
        MybatisUtils.close(session);
    }
}
