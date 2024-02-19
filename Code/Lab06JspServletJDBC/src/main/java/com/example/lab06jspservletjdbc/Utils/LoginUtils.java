package com.example.lab06jspservletjdbc.Utils;

import com.example.lab06jspservletjdbc.beans.UserAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginUtils {
    public static UserAccount findUser(Connection conn , String userName, String password) throws SQLException{
        String sql = "SELECT a.USER_NAME , a.PASSWORD, a.GENDER FROM USER_ACCOUNT"
                + "WHERE a.USER_NAME = ? AND a.PASSWORD= ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        pstm.setString(2, password);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
            String gender = rs.getString("GENDER");
            UserAccount user = new UserAccount();
            user.setUsername(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;

        }
        return null;
    }
    public static UserAccount findUser(Connection conn, String userName )throws SQLException{
        String sql = "SELECT a.USER_NAME , a.PASSWORD, a.GENDER FROM USER_ACCOUNT a"
                + "WHERE a.USER_NAME = ?";
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, userName);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()){
            String gender = rs.getString("GENDER");
            String password = rs.getString("PASSWORD");
            UserAccount user = new UserAccount();
            user.setUsername(userName);
            user.setPassword(password);
            user.setGender(gender);
            return user;

        }
        return null;
    }
}
