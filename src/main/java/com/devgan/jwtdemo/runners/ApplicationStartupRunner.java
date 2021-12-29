package com.devgan.jwtdemo.runners;

import com.devgan.jwtdemo.entities.Employee;
import com.devgan.jwtdemo.repositories.EmployeeRepository;
import com.devgan.jwtdemo.utils.ApplicationUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApplicationStartupRunner implements CommandLineRunner {


    private final ApplicationUtils appUtils;
    private final EmployeeRepository employeeRepository;
    public ApplicationStartupRunner(ApplicationUtils appUtils, EmployeeRepository employeeRepository) {
        this.appUtils = appUtils;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        List<Employee> list=appUtils.parseObjectList(Employee.class,"Employee.json");
        employeeRepository.saveAll(list);
    }
}
