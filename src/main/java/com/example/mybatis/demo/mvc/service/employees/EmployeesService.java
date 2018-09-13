package com.example.mybatis.demo.mvc.service.employees;

import com.example.mybatis.demo.entity.Employees;

import java.util.List;

public interface EmployeesService {

    List<Employees> selectEmployeesList(String lastName);
}
