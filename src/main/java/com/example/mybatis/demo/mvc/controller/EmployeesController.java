package com.example.mybatis.demo.mvc.controller;

import com.example.mybatis.demo.entity.Employees;
import com.example.mybatis.demo.exception.AsyncException;
import com.example.mybatis.demo.exception.PageException;
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
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeesController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/single")
    public String employeesSingle() {
        logger.debug("start employeesSingle");

        try {
            return "employees.single";

        } catch(Exception e) {
            throw new PageException(e);
        }
    }

    @GetMapping("/main")
    public String employeesMain() {
        logger.debug("employeesMain");

        try {
            return "employees.main";

        } catch(Exception e) {
            throw new PageException(e);
        }
    }

    @GetMapping("/simple")
    public String employeesSimple() {
        logger.debug("employeesSimple");

        try {
            return "simple.simple";

        } catch(Exception e) {
            throw new PageException(e);
        }
    }

    @GetMapping("/list/{lastName}")
    @ResponseBody
    public ResponseEntity<List<Employees>> employeesList(@PathVariable String lastName) {
        logger.debug("employeesList");

        try {
            List<Employees> list = employeesService.selectEmployeesList(lastName);
            return new ResponseEntity<>(list, HttpStatus.OK);

        } catch(Exception e) {
            throw new AsyncException(e);
        }
    }
}
