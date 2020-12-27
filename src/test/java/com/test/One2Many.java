package com.test;

import com.offcn.entity.Department;
import com.offcn.entity.Employee;
import com.offcn.mapper.DepartmentMapper;
import com.offcn.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class One2Many {
    @Test
    public void getDepartmentById2(){
        SqlSession sqlSession = MybatisUtils.getSession();
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department department = mapper.getDepartmentById2(2);
        System.out.println(department.getName());
        for (Employee emp : department.getEmps()) {
            System.out.println(emp.getName() + emp.getGender() + emp.getAge() + emp.getId());
        }
        MybatisUtils.close(sqlSession);
    }

}
