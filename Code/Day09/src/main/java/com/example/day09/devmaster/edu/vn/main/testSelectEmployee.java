package com.example.day09.devmaster.edu.vn.main;

import com.example.day09.devmaster.edu.vn.dao.EmployeeDAOIMPL;
import com.example.day09.devmaster.edu.vn.dao.ProductDAOIMPL;
import com.example.day09.devmaster.edu.vn.entity.Employee;
import com.example.day09.devmaster.edu.vn.entity.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class testSelectEmployee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> list = new EmployeeDAOIMPL().getAllEmployee();
        if (list == null)
            return;
        for (Employee item : list){
            System.out.println("|"+item.getEMP_ID()
                    +" | "+item.getEMP_NAME()
                    +" | "+item.getEMP_NO()
                    +" | "+item.getHIRE_DATE()
                    +" | "+item.getIMAGE()
                    +" | "+item.getJOB()
                    +" | "+item.getDEPT_ID()
                    +" | "+item.getMNG_ID()
                    +" | "+item.getSALARY()
                    +" | ");
        }
        System.out.print("Nhập ID : ");
        BigDecimal EMP_ID = sc.nextBigDecimal();
        Employee employee = new EmployeeDAOIMPL().getEmployeeById(EMP_ID);
        System.out.println("|"+employee.getEMP_ID()
                +" | "+employee.getEMP_NAME()
                +" | "+employee.getEMP_NO()
                +" | "+employee.getHIRE_DATE()
                +" | "+employee.getIMAGE()
                +" | "+employee.getJOB()
                +" | "+employee.getDEPT_ID()
                +" | "+employee.getMNG_ID()
                +" | "+employee.getSALARY()
                +" | ");
    }
}
