package com.example.vdday08.dao.IMPL;

import com.example.vdday08.entity.ProductEntity;

import java.util.List;

public class TestSelect {
    public static void main(String[] args) {
        List<ProductEntity> list = new  ProductDAOIMPL().getAllProduct();
        if (list == null)
            return;
        for (ProductEntity item : list){
            System.out.println("\n%-10s "+item.getMaSP());
            System.out.println("%-15s  "+item.getTenSanPham());
            System.out.println("% 15d  "+item.getSoLuong());
            System.out.println("% 15.of  "+item.getDonGia());
        }
    }
}
