package com.example.lab05hibernate01.main;

import com.example.lab05hibernate01.dao.IMPL.EmployeeDAOIMPL;
import com.example.lab05hibernate01.dao.IMPL.ProductDAOIMPL;
import com.example.lab05hibernate01.entity.EMPLOYEE;
import com.example.lab05hibernate01.entity.ProductEntity;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class testUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EMPLOYEE E = new EMPLOYEE();
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
            E.setEMP_ID(Ma);
            E.setEMP_NAME(ten);
            E.setEMP_NO(no);
            E.setHIRE_DATE(date);
            E.setJOB(JOB);
            E.setSALARY(salaty);
            E.setDEPT_ID(deptid);
            E.setMNG_ID(mngid);
            boolean flags = new EmployeeDAOIMPL().updateEmployee(E);
            if (flags == true) System.out.println("Sửa đổi dữ liệu thành công! ");
            else System.out.println("Sảy ra lỗi sửa đổi sản phẩm! ");
        } catch (Exception e) {
            System.out.println("Định dạng không hợp lệ.");
        }
    }
}
