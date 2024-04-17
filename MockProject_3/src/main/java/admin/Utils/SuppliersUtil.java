package admin.Utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.entity.Suppliers;
public class SuppliersUtil {
	public static List<Suppliers> getAll(Connection conn) throws SQLException {
	    String sql = "SELECT * FROM Suppliers";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    ResultSet rs = statement.executeQuery();
	    List<Suppliers> suppliersList = new ArrayList<>();
	    while (rs.next()) {
	        Suppliers supplier = new Suppliers();
	        supplier.setSid(rs.getInt("Sid"));
	        supplier.setName(rs.getString("Name"));
	        suppliersList.add(supplier);
	    }
	    return suppliersList;
	}
	public static Suppliers getById(Connection conn, int sid) throws SQLException {
	    String sql = "SELECT * FROM Suppliers WHERE Sid = ?";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setInt(1, sid);
	    ResultSet rs = statement.executeQuery();
	    Suppliers supplier = null;
	    if (rs.next()) {
	        supplier = new Suppliers();
	        supplier.setSid(rs.getInt("Sid"));
	        supplier.setName(rs.getString("Name"));
	    }
	    return supplier;
	}

	public static void insert(Connection conn, Suppliers supplier) throws SQLException {
	    String sql = "INSERT INTO Suppliers (Name) VALUES (?)";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setString(1, supplier.getName());
	    statement.executeUpdate();
	}
	public static void update(Connection conn, Suppliers supplier) throws SQLException {
	    String sql = "UPDATE Suppliers SET Name = ? WHERE Sid = ?";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setString(1, supplier.getName());
	    statement.setInt(2, supplier.getSid());
	    statement.executeUpdate();
	}
	public static void delete(Connection conn, int sid) throws SQLException {
	    String sql = "DELETE FROM Suppliers WHERE Sid = ?";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setInt(1, sid);
	    statement.executeUpdate();
	}

}
