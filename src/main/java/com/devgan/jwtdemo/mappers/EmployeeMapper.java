package com.devgan.jwtdemo.mappers;

import com.devgan.jwtdemo.dtos.EmployeeDTO;
import com.devgan.jwtdemo.entities.Employee;

public class EmployeeMapper {

    public static EmployeeDTO entityToDTO(Employee emp) {
        EmployeeDTO empdto = new EmployeeDTO();
        empdto.setName(emp.getName());
        empdto.setEmail(emp.getEmail());
        empdto.setJob(emp.getJob());
        empdto.setSalary(emp.getSalary());
        return empdto;
    }
    public static Employee dtoToEntity(EmployeeDTO empdto) {
        Employee emp = new Employee();
        emp.setName(empdto.getName());
        emp.setEmail(empdto.getEmail());
        emp.setJob(empdto.getJob());
        emp.setSalary(empdto.getSalary());
        return emp;
    }

}
