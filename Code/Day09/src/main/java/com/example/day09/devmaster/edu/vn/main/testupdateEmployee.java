package com.example.day09.devmaster.edu.vn.main;

import com.example.day09.devmaster.edu.vn.dao.EmployeeDAOIMPL;
import com.example.day09.devmaster.edu.vn.entity.Employee;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class testupdateEmployee {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhập EMP_ID cần sửa: ");
            BigDecimal id = sc.nextBigDecimal();
            Employee UpdateEmployee = new EmployeeDAOIMPL().getEmployeeById(id);
            System.out.print("Nhập EMP_NAME: ");
            String EMP_NAME = sc.next();
            System.out.print("Nhập EMP_NO: ");
            String EMP_NO = sc.next();
            sc.nextLine();
            System.out.println("Nhập ngày tháng năm theo định dạng dd-MM-yyyy: ");
            String dateString = sc.nextLine();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = dateFormat.parse(dateString);
            System.out.println("Ngày đã nhập: " + dateFormat.format(date));
            System.out.print("Nhập JOB: ");
            String JOB = sc.next();
            System.out.print("Nhập DEPT_ID: ");
            Integer DEPT_ID = sc.nextInt();
            System.out.print("Nhập MNG_ID: ");
            BigDecimal MNG_ID = sc.nextBigDecimal();
            System.out.print("Nhập SALARY: ");
            Double SALARY = sc.nextDouble();
            UpdateEmployee.setEMP_ID(id);
            UpdateEmployee.setEMP_NAME(EMP_NAME);
            UpdateEmployee.setEMP_NO(EMP_NO);
            UpdateEmployee.setHIRE_DATE(date);
            UpdateEmployee.setIMAGE(null);
            UpdateEmployee.setJOB(JOB);
            UpdateEmployee.setDEPT_ID(DEPT_ID);
            UpdateEmployee.setMNG_ID(MNG_ID);
            UpdateEmployee.setSALARY(SALARY);
            boolean flag = new EmployeeDAOIMPL().updateEmployee(UpdateEmployee);
            if (flag == true) System.out.println("Sửa đổi dữ liệu thành công! ");
            else System.out.println("Sảy ra lỗi sửa đổi sản phẩm! ");
        } catch (Exception e) {
            System.out.println("Định dạng không hợp lệ. Hãy nhập theo định dạng dd-MM-yyyy.");
        }
    }
}
