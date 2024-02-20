package com.example.lab06jspservletjdbc.Utils;

import com.example.lab06jspservletjdbc.beans.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerUtils {
    public static List<Customer> getAllCustomer(Connection conn) throws SQLException{
        String sql = "SELECT a.CusID, a.CusUser, a.CusPass, a.CusName, a.CusPhone, a.CusAdd, a.CusEmail, a.CusFacebook, a.CusSkyber, a.CusStatus FROM CUSTOMER a";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Customer> customerList = new ArrayList<Customer>();
        while (rs.next()){
            int CusID = rs.getInt("CusID");
            String CusUser = rs.getString("CusUser");
            String CusPass = rs.getString("CusPass");
            String CusName = rs.getString("CusName");
            String CusPhone = rs.getString("CusPhone");
            String CusAdd = rs.getString("CusAdd");
            String CusEmail = rs.getString("CusEmail");
            String CusFacebook = rs.getString("CusFacebook");
            String CusSkyber = rs.getString("CusSkyber");
            Byte CusStatus = rs.getByte("CusStatus");
            Customer customer = new Customer();
            customer.setId(CusID);
            customer.setUser(CusUser);
            customer.setPass(CusPass);
            customer.setName(CusName);
            customer.setPhone(CusPhone);
            customer.setAdd(CusAdd);
            customer.setEmail(CusEmail);
            customer.setFacebook(CusFacebook);
            customer.setSkyber(CusSkyber);
            customer.setStatus(CusStatus);
            customerList.add(customer);

        }
        return  customerList;

    }

    public static Customer findByCusID(Connection conn, int CusID) throws SQLException{
        String sql = "SELECT * FROM CUSTOMER WHERE CusID =? ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, CusID);
        ResultSet rs = statement.executeQuery();
        while (rs.next()){
            String CusUser = rs.getString("CusUser");
            String CusPass = rs.getString("CusPass");
            String CusName = rs.getString("CusName");
            String CusPhone = rs.getString("CusPhone");
            String CusAdd = rs.getString("CusAdd");
            String CusEmail = rs.getString("CusEmail");
            String CusFacebook = rs.getString("CusFacebook");
            String CusSkyber =rs.getString("CusSkyber");
            Byte CusStatus = rs.getByte("CusStatus");
                Customer customer = new Customer();
            customer.setId(CusID);
            customer.setUser(CusUser);
            customer.setPass(CusPass);
            customer.setName(CusName);
            customer.setPhone(CusPhone);
            customer.setAdd(CusAdd);
            customer.setEmail(CusEmail);
            customer.setFacebook(CusFacebook);
            customer.setSkyber(CusSkyber);
            customer.setStatus(CusStatus);
            return customer;


        }
        return null;

    }
    public static List<Customer> findByCusUser(Connection conn, String CusUser) throws SQLException{
        String sql = "SELECT a.CusID, a.CusUser, a.CusPass, a.CusName, a.CusPhone, a.CusAdd, a.CusEmail, a.CusFacebook, a.CusSkyber, a.CusStatus FROM CUSTOMER a WHERE CusUser = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, CusUser);
        ResultSet rs = statement.executeQuery();
        List<Customer> customerList = new ArrayList<Customer>();
        while (rs.next()){
            int CusID = rs.getInt("CusID");
            String CusPass = rs.getString("CusPass");
            String CusName = rs.getString("CusName");
            String CusPhone = rs.getString("CusPhone");
            String CusAdd = rs.getString("CusAdd");
            String CusEmail = rs.getString("CusEmail");
            String CusFacebook = rs.getString("CusFacebook");
            String CusSkyber = rs.getString("CusSkyber");
            Byte CusStatus = rs.getByte("CusStatus");
            Customer customer = new Customer();
            customer.setId(CusID);
            customer.setUser(CusUser);
            customer.setPass(CusPass);
            customer.setName(CusName);
            customer.setPhone(CusPhone);
            customer.setAdd(CusAdd);
            customer.setEmail(CusEmail);
            customer.setFacebook(CusFacebook);
            customer.setSkyber(CusSkyber);
            customer.setStatus(CusStatus);
            customerList.add(customer);

        }
        return  customerList;

    }
    public static void createCustomer(Connection conn, Customer customer) throws SQLException{
        String sql = "INSERT INTO CUSTOMER (CusUser, CusPass, CusName, CusPhone, CusAdd, CusEmail, CusFacebook, CusSkyber, CusStatus) "
                + "VALUES (?,?,?,?,?,?,?,?,?) ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,customer.getUser());
        statement.setString(2,customer.getPass());
        statement.setString(3,customer.getName());
        statement.setString(4,customer.getPhone());
        statement.setString(5,customer.getAdd());
        statement.setString(6,customer. getEmail());
        statement.setString(7,customer.getFacebook());
        statement.setString(8,customer.getSkyber());
        statement.setByte(9,customer.getStatus());
        statement.executeUpdate();
    }
    public static void updateCustomer(Connection conn, Customer customer) throws SQLException{
        String sql= "UPDATE CUSTOMER SET CusUser = ? , CusPass =?, CusName =?, CusPhone =?, CusAdd =?, CusEmail =?, CusFacebook =?, CusSkyber =?, CusStatus =? WHERE CusID =?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,customer.getUser());
        statement.setString(2,customer.getPass());
        statement.setString(3,customer.getName());
        statement.setString(4,customer.getPhone());
        statement.setString(5,customer.getAdd());
        statement.setString(6,customer. getEmail());
        statement.setString(7,customer.getFacebook());
        statement.setString(8,customer.getSkyber());
        statement.setByte(9,customer.getStatus());
        statement.setInt(10,customer.getId());
        statement.executeUpdate();
    }

    public static void deleteCustomerByCusID(Connection conn , int CusID) throws SQLException{
        String sql= "DELETE FROM CUSTOMER WHERE CusID =?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,CusID);
        pstm.executeUpdate();
    }

}
