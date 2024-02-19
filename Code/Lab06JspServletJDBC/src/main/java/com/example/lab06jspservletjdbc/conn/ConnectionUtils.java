package com.example.lab06jspservletjdbc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtils {
    public static Connection getMSSQLConnections() throws SQLException, ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       String url = "jdbc:sqlserver://DESKTOP-MOTUJCG\\SQLSERVER:1433;databaseName=Lab04JspServletJDBC;encrypt=false";
       String user = "sa";
       String password = "1412";

        Connection conn = DriverManager.getConnection(url, user,password);
        return conn;
    }
    public static void closeQuietly(Connection conn){
        try {
        conn.close();
        }catch (Exception e){

        }
    }

    public  static void rollbackQuietly(Connection conn){
        try {
conn.rollback();
        }catch (Exception e){

        }
    }

    public static void main(String[] args) throws SQLException,ClassNotFoundException {
        Connection conn = getMSSQLConnections();
        System.out.println("connection " + conn);
        System.out.println("done");

    }
}
