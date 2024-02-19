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
            customer.setCusID(CusID);
            customer.setCusUser(CusUser);
            customer.setCusPass(CusPass);
            customer.setCusName(CusName);
            customer.setCusPhone(CusPhone);
            customer.setCusAdd(CusAdd);
            customer.setCusEmail(CusEmail);
            customer.setCusFacebook(CusFacebook);
            customer.setCusSkyber(CusSkyber);
            customer.setCusStatus(CusStatus);
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
                customer.setCusID(CusID);
            customer.setCusUser(CusUser);
            customer.setCusPass(CusPass);
            customer.setCusName(CusName);
            customer.setCusPhone(CusPhone);
            customer.setCusAdd(CusAdd);
            customer.setCusEmail(CusEmail);
            customer.setCusFacebook(CusFacebook);
            customer.setCusSkyber(CusSkyber);
            customer.setCusStatus(CusStatus);
            return customer;


        }
        return null;

    }
    public static void createCustomer(Connection conn, Customer customer) throws SQLException{
        String sql = "INSERT INTO CUSTOMER (CusUser, CusPass, CusName, CusPhone, CusAdd, CusEmail, CusFacebook, CusSkyber, CusStatus) "
                + "VALUES (?,?,?,?,?,?,?,?,?) ";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,customer.getCusUser());
        statement.setString(2,customer.getCusPass());
        statement.setString(3,customer.getCusName());
        statement.setString(4,customer.getCusPhone());
        statement.setString(5,customer.getCusAdd());
        statement.setString(6,customer.getCusEmail());
        statement.setString(7,customer.getCusFacebook());
        statement.setString(8,customer.getCusSkyber());
        statement.setByte(9,customer.getCusStatus());
        statement.executeUpdate();
    }
    public static void updateCustomer(Connection conn, Customer customer) throws SQLException{
        String sql= "UPDATE CUSTOMER SET CusUser = ? , CusPass =?, CusName =?, CusPhone =?, CusAdd =?, CusEmail =?, CusFacebook =?, CusSkyber =?, CusStatus =? WHERE CusID =?";

        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,customer.getCusUser());
        statement.setString(2,customer.getCusPass());
        statement.setString(3,customer.getCusName());
        statement.setString(4,customer.getCusPhone());
        statement.setString(5,customer.getCusAdd());
        statement.setString(6,customer.getCusEmail());
        statement.setString(7,customer.getCusFacebook());
        statement.setString(8,customer.getCusSkyber());
        statement.setByte(9,customer.getCusStatus());
        statement.setInt(10,customer.getCusID());
        statement.executeUpdate();
    }

    public static void deleteCustomerByCusID(Connection conn , int CusID) throws SQLException{
        String sql= "DELETE FROM CUSTOMER WHERE CusID =?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1,CusID);
        pstm.executeUpdate();
    }

}
