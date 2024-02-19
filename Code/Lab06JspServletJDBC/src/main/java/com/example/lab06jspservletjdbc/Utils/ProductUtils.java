package com.example.lab06jspservletjdbc.Utils;

import com.example.lab06jspservletjdbc.beans.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductUtils {
    public static List<Product> queryProduct(Connection conn )throws SQLException{
        String sql ="SELECT a.CODE, a.NAME , a.PRICE FROM PRODUCT a";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
        while (rs.next()){
            String code = rs.getString("CODE");
            String name = rs.getString("NAME");
            float price = rs.getFloat("PRICE");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
            list.add(product);

        }
        return list;

    }
    public static Product queryProduct(Connection conn, String code )throws SQLException{
        String sql ="SELECT a.CODE, a.NAME , a.PRICE FROM PRODUCT a WHERE a.CODE = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, code);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()){
            String name = rs.getString("NAME");
            float price = rs.getFloat("PRICE");
            Product product = new Product();
            product.setCode(code);
            product.setName(name);
            product.setPrice(price);
      return product;
        }
        return null;
    }

    public static void  insertProduct(Connection conn, Product product) throws SQLException{
        String sql ="INSERT INTO PRODUCT (CODE, NAME, PRICE) VALUES (?,?,?);";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, product.getCode());
        pstm.setString(2, product.getName());
        pstm.setFloat(3, product.getPrice());
        pstm.executeUpdate();
    }

    public  static void updateProduct (Connection conn , Product product) throws  SQLException{
        String sql= "UPDATE PRODUCT SET NAME = ? , PRICE =? WHERE CODE =?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, product.getName());
        pstm.setFloat(2, product.getPrice());
        pstm.setString(3, product.getCode());
        pstm.executeUpdate();
    }
    public  static void deleteProduct (Connection conn , String code) throws  SQLException{
        String sql= "DELETE FROM PRODUCT WHERE CODE =?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,code);
        pstm.executeUpdate();
    }
}
