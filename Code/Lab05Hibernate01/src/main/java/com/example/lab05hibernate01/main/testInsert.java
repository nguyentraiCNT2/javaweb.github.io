package com.example.lab05hibernate01.main;

import com.example.lab05hibernate01.dao.IMPL.EmployeeDAOIMPL;
import com.example.lab05hibernate01.dao.IMPL.ProductDAOIMPL;
import com.example.lab05hibernate01.entity.EMPLOYEE;
import com.example.lab05hibernate01.entity.ProductEntity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class testInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EMPLOYEE CreateEmployee = new EMPLOYEE();
        System.out.print("Nhập mã : ");
        BigDecimal Ma = sc.nextBigDecimal();
        System.out.print("Nhập tên : ");
        String ten = sc.next();
        System.out.print("Nhập emp no : ");
        String no = sc.next();
        System.out.print("Nhập job: ");
        String JOB = sc.next();
        System.out.print("Nhập salary: ");
        Double salaty = sc.nextDouble();
        System.out.print("Nhập DEPT_ID: ");
        Integer deptid = sc.nextInt();
        System.out.print("Nhập đMNG_ID: ");
        BigDecimal mngid = sc.nextBigDecimal();
        sc.nextLine();
        System.out.println("Nhập ngày tháng năm theo định dạng dd-MM-yyyy: ");
        String dateString = sc.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = dateFormat.parse(dateString);
            System.out.println("Ngày đã nhập: " + dateFormat.format(date));
            CreateEmployee.setEMP_ID(Ma);
            CreateEmployee.setEMP_NAME(ten);
            CreateEmployee.setEMP_NO(no);
            CreateEmployee.setHIRE_DATE(date);
            CreateEmployee.setJOB(JOB);
            CreateEmployee.setSALARY(salaty);
            CreateEmployee.setDEPT_ID(deptid);
            CreateEmployee.setMNG_ID(mngid);
            boolean flag = new EmployeeDAOIMPL().insertEmployee(CreateEmployee);
            if (flag == true ) System.out.println("Thêm mới dữ liệu thành công! ");
            else System.out.println("Sảy ra lỗi thêm mới sản phẩm! ");
        }catch (Exception e){
            System.out.println("Định dạng không hợp lệ. Hãy nhập theo định dạng dd-MM-yyyy.");
        }

    }
}
