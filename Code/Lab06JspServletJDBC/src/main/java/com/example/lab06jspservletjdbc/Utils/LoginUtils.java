package com.example.lab06jspservletjdbc.Utils;

import com.example.lab06jspservletjdbc.beans.Product;
import com.example.lab06jspservletjdbc.beans.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginUtils {
    public static List<UserAccount> getAll(Connection conn ) throws SQLException{
        String sql = "SELECT a.USER_NAME , a.PASSWORD, a.GENDER FROM USER_ACCOUNT a";
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<UserAccount> list = new ArrayList<UserAccount>();
        while (rs.next()){
            String gender = rs.getString("GENDER");
            String userName = rs.getString("USER_NAME");
            String password = rs.getString("PASSWORD");
            UserAccount user = new UserAccount();
            user.setUsername(userName);
            user.setPass(password);
            user.setSex(gender);
            list.add(user);
        }
        return list;
    }
    public static UserAccount findUser(Connection conn , String userName, String password) throws SQLException{
        String sql = "SELECT USER_NAME , PASSWORD, GENDER FROM USER_ACCOUNT WHERE USER_NAME = ? AND PASSWORD = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
            String gender = rs.getString("GENDER");
            UserAccount user = new UserAccount();
            user.setUsername(userName);
            user.setPass(password);
            user.setSex(gender);
            return user;

        }
        return null;
    }
    public static UserAccount findUser(Connection conn, String userName )throws SQLException{
        String sql = "SELECT USER_NAME , PASSWORD, GENDER FROM USER_ACCOUNT WHERE USER_NAME = ? ";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
            String gender = rs.getString("GENDER");
            String password = rs.getString("PASSWORD");
            UserAccount user = new UserAccount();
            user.setUsername(userName);
            user.setPass(password);
            user.setSex(gender);
            return user;

        }
        return null;
    }

    public static void  insertUser(Connection conn, UserAccount userAccount) throws SQLException{
        String sql ="INSERT INTO USER_ACCOUNT (USER_NAME, PASSWORD, GENDER) VALUES (?,?,?);";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userAccount.getUsername());
        pstm.setString(2, userAccount.getPass());
        pstm.setString(3, userAccount.getSex());
        pstm.executeUpdate();
    }
    public  static void updateUser (Connection conn , UserAccount userAccount) throws  SQLException{
        String sql= "UPDATE USER_ACCOUNT SET PASSWORD = ? , GENDER =? WHERE USER_NAME =?";
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, userAccount.getPass() );
        pstm.setString(2,  userAccount.getSex());
        pstm.setString(3, userAccount.getUsername()) ;
        pstm.executeUpdate();
    }
    public  static void deleteUser (Connection conn , String userName) throws  SQLException{
        String sql= "DELETE FROM USER_ACCOUNT WHERE USER_NAME =?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,userName);
        pstm.executeUpdate();
    }
}
