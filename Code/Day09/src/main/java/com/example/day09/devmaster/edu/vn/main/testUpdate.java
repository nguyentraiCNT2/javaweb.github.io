package com.example.day09.devmaster.edu.vn.main;

import com.example.day09.devmaster.edu.vn.dao.ProductDAOIMPL;
import com.example.day09.devmaster.edu.vn.entity.Product;

import java.util.Scanner;

public class testUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sản phẩm cần sửa: ");
        String Maspofedit = sc.next();
        Product p = new ProductDAOIMPL().getProductById(Maspofedit);
        System.out.print("Nhập tên sản phẩm: ");
        String tensp = sc.next();
        System.out.print("Nhập ảnh sản phẩm: ");
        String anhsp = sc.next();
        System.out.print("Nhập số lượng sản phẩm: ");
        Integer qtysp = sc.nextInt();
        System.out.print("Nhập đơn giá sản phẩm: ");
        Double giasp = sc.nextDouble();
        p.setMaSP(Maspofedit);
        p.setTenSanPham(tensp);
        p.setAnhSanPham(anhsp);
        p.setSoLuong(qtysp);
        p.setDonGia(giasp);
        p.setTrangThai(true);
        boolean flags = new ProductDAOIMPL().updateProduct(p);
        if (flags == true ) System.out.println("Sửa đổi dữ liệu thành công! ");
        else System.out.println("Sảy ra lỗi sửa đổi sản phẩm! ");
    }
}
