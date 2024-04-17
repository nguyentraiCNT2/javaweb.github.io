package nnt.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class NinhNgocTuanConnectionUtils {
	 public static Connection getMSSQLConnections() throws SQLException, ClassNotFoundException {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String url = "jdbc:sqlserver://DESKTOP-MOTUJCG\\SQLSERVER:1433;databaseName=QLKH_NinhNgocTuan;encrypt=false";
	        String user = "sa";
	        String password = "1412";

	        Connection conn = DriverManager.getConnection(url, user, password);
	        return conn;
	    }
	   public static void main(String[] args) throws SQLException, ClassNotFoundException {
	        Connection conn = getMSSQLConnections();
	        System.out.println("connection " + conn);

	        System.out.println("done");

	    }
}
