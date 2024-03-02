package com.example.day09.devmaster.edu.vn.main;

import com.example.day09.devmaster.edu.vn.dao.ProductDAOIMPL;
import com.example.day09.devmaster.edu.vn.entity.Product;

import java.util.Scanner;

public class testInsert {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Product Createproduct = new Product();
        System.out.print("Nhập mã sản phẩm: ");
        String Ma = sc.next();
        System.out.print("Nhập tên sản phẩm: ");
        System.out.print("Nhập tên sản phẩm: ");
        String tensp = sc.next();
        System.out.print("Nhập ảnh sản phẩm: ");
        String anhsp = sc.next();
        System.out.print("Nhập số lượng sản phẩm: ");
        Integer qty = sc.nextInt();
        System.out.print("Nhập đơn giá sản phẩm: ");
        Double gia = sc.nextDouble();
        Createproduct.setMaSP(Ma);
        Createproduct.setTenSanPham(tensp);
        Createproduct.setAnhSanPham(anhsp);
        Createproduct.setSoLuong(qty);
        Createproduct.setDonGia(gia);
        Createproduct.setTrangThai(true);
        boolean flag = new ProductDAOIMPL().insertProduct(Createproduct);
        if (flag == true ) System.out.println("Thêm mới dữ liệu thành công! ");
        else System.out.println("Sảy ra lỗi thêm mới sản phẩm! ");
    }
}
