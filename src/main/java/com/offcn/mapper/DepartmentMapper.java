package com.offcn.mapper;

import com.offcn.entity.Department;
import com.offcn.entity.Employee;

import java.util.List;

public interface DepartmentMapper {
    public Department getDepartmentById(Integer id);
    public Department getDepartmentById2(Integer id);
    public List<Employee>  getEmployeeByEDepartId(Integer id);

}
