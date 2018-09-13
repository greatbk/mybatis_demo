package com.example.mybatis.demo.mvc.service.employees;

import com.example.mybatis.demo.entity.Employees;
import com.example.mybatis.demo.mapper.EmployeesMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EmployeesServiceImpl implements EmployeesService {

    private static final Logger logger = LoggerFactory.getLogger(EmployeesServiceImpl.class);

    @Autowired
    private EmployeesMapper employeesMapper;

    @Override
    public List<Employees> selectEmployeesList(String lastName) {
        loggerTest("selectEmployeesList");
        return employeesMapper.selectEmployeesList(lastName);
    }

    /**
     * logger test
     * @param methodName method_name
     */
    private void loggerTest(String methodName) {
        logger.debug(String.format("EmployeesServiceImpl:%s", methodName));
    }
}
