package admin.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.entity.Categories;
public class CategoriesUtils {
	public static List<Categories> getAll(Connection conn) throws SQLException {
        String sql = "SELECT * FROM Categories";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        List<Categories> CategoriesList = new ArrayList<>();
        while (rs.next()) {
        	Categories categories = new Categories();
        	categories.setCid(rs.getInt("Cid"));
        	categories.setName(rs.getString("Name"));
           
        	CategoriesList.add(categories);
        }
        return CategoriesList;
    }
	
	public static Categories getById(Connection conn, int cid) throws SQLException {
	    String sql = "SELECT * FROM Categories WHERE Cid = ?";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setInt(1, cid);
	    ResultSet rs = statement.executeQuery();
	    Categories categories = null;
	    if (rs.next()) {
	        categories = new Categories();
	        categories.setCid(rs.getInt("Cid"));
	        categories.setName(rs.getString("Name"));
	    }
	    return categories;
	}
	
	public static void insert(Connection conn, Categories category) throws SQLException {
	    String sql = "INSERT INTO Categories (Name) VALUES (?)";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setString(1, category.getName());
	    statement.executeUpdate();
	}
	public static void update(Connection conn, Categories category) throws SQLException {
	    String sql = "UPDATE Categories SET Name = ? WHERE Cid = ?";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setString(1, category.getName());
	    statement.setInt(2, category.getCid());
	    statement.executeUpdate();
	}

	public static void delete(Connection conn, int cid) throws SQLException {
	    String sql = "DELETE FROM Categories WHERE Cid = ?";
	    PreparedStatement statement = conn.prepareStatement(sql);
	    statement.setInt(1, cid);
	    statement.executeUpdate();
	}


}
