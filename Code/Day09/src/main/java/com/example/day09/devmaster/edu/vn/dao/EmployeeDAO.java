package com.example.day09.devmaster.edu.vn.dao;

import com.example.day09.devmaster.edu.vn.entity.Employee;
import com.example.day09.devmaster.edu.vn.entity.Product;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();
    Employee getEmployeeById(BigDecimal id);
    boolean insertEmployee(Employee employee);
    boolean updateEmployee(Employee employee);
    boolean deleteEmployee(BigDecimal id);
}
