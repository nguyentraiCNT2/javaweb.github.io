package com.example.lab05hibernate01.dao;

import com.example.lab05hibernate01.entity.EMPLOYEE;
import com.example.lab05hibernate01.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeDAO {
    public List<EMPLOYEE> getAllEmployee();
    public EMPLOYEE getEmployeeByEMP_NAME(String EMP_NAME);

    boolean insertEmployee(EMPLOYEE employee);

    boolean updateEmployee(EMPLOYEE employee);

    boolean deleteProduct(BigDecimal EMP_ID);
}
