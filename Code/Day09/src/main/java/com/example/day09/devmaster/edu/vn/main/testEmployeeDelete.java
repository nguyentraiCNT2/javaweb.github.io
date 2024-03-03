package com.example.day09.devmaster.edu.vn.main;

import com.example.day09.devmaster.edu.vn.dao.EmployeeDAOIMPL;
import com.example.day09.devmaster.edu.vn.dao.ProductDAOIMPL;

import java.math.BigDecimal;
import java.util.Scanner;

public class testEmployeeDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm cần xóa: ");
        BigDecimal Maspofdelete = sc.nextBigDecimal();
        boolean flagtodelete = new EmployeeDAOIMPL().deleteEmployee(Maspofdelete);
        if (flagtodelete == true ) System.out.println("Đã xóa sản phẩm thành công! ");
        else System.out.println("Sảy ra lỗi xóa sản phẩm! ");
    }

}
