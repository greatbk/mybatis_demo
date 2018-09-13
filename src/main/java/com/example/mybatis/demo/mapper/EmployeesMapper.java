package com.example.mybatis.demo.mapper;

import com.example.mybatis.demo.entity.Employees;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeesMapper {

    List<Employees> selectEmployeesList(String lastName);
}
