package com.example.mybatis.demo.mvc.controller;

import com.example.mybatis.demo.entity.Employees;
import com.example.mybatis.demo.mvc.service.employees.EmployeesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeesController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/single")
    public String employeesSingle() {
        loggerTest("employees-single");
        return "employees.single-page";
    }

    @GetMapping("/main")
    public String employeesMain() {
        loggerTest("employees-main");
        return "employees.main";
    }

    @GetMapping("/list/{lastName}")
    public ResponseEntity<List<Employees>> employeesList(@PathVariable String lastName) {
        loggerTest("employeesList");
        List<Employees> list = employeesService.selectEmployeesList(lastName);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    /**
     * logger test
     * @param methodName method_name
     */
    private void loggerTest(String methodName) {
        logger.debug(String.format("EmployeesController:%s", methodName));
    }
}
