package admin.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import admin.entity.Users;
public class UserUtils {
	 public static List<Users> getAll(Connection conn) throws SQLException {
	        String sql = "SELECT * FROM Users";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        ResultSet rs = statement.executeQuery();
	        List<Users> userList = new ArrayList<>();
	        while (rs.next()) {
	            Users user = new Users();
	            user.setUid(rs.getInt("Uid"));
	            user.setFullName(rs.getString("Full_Name"));
	            user.setAvatarUrl(rs.getString("Avatar_Url"));
	            user.setUserPhone(rs.getString("User_Phone"));
	            user.setEmail(rs.getString("Email"));
	            user.setPassword(rs.getString("Password"));
	            user.setCreateDate(rs.getDate("Create_Date"));
	            user.setDelete(rs.getBoolean("Is_Delete"));
	            user.setAddress(rs.getString("Address"));
	            user.setRoleId(rs.getBoolean("Role_id"));
	            userList.add(user);
	        }
	        return userList;
	    }

	    public static Users getById(Connection conn, int uid) throws SQLException {
	        String sql = "SELECT * FROM Users WHERE Uid = ?";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1, uid);
	        ResultSet rs = statement.executeQuery();
	        Users user = null;
	        if (rs.next()) {
	            user = new Users();
	            user.setUid(rs.getInt("Uid"));
	            user.setFullName(rs.getString("Full_Name"));
	            user.setAvatarUrl(rs.getString("Avatar_Url"));
	            user.setUserPhone(rs.getString("User_Phone"));
	            user.setEmail(rs.getString("Email"));
	            user.setPassword(rs.getString("Password"));
	            user.setCreateDate(rs.getDate("Create_Date"));
	            user.setDelete(rs.getBoolean("Is_Delete"));
	            user.setAddress(rs.getString("Address"));
	            user.setRoleId(rs.getBoolean("Role_id"));
	        }
	        return user;
	    }

	    public static void insert(Connection conn, Users user) throws SQLException {
	        String sql = "INSERT INTO Users (Full_Name, Avatar_Url, User_Phone, Email, Password, Create_Date, Is_Delete, Address, Role_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, user.getFullName());
	        statement.setString(2, user.getAvatarUrl());
	        statement.setString(3, user.getUserPhone());
	        statement.setString(4, user.getEmail());
	        statement.setString(5, user.getPassword());
	        statement.setDate(6, new java.sql.Date(user.getCreateDate().getTime()));
	        statement.setBoolean(7, user.isDelete());
	        statement.setString(8, user.getAddress());
	        statement.setBoolean(9, user.isRoleId());
	        statement.executeUpdate();
	    }

	    public static void update(Connection conn, Users user) throws SQLException {
	        String sql = "UPDATE Users SET Full_Name = ?, Avatar_Url = ?, User_Phone = ?, Email = ?, Password = ?, Create_Date = ?, Is_Delete = ?, Address = ?, Role_id = ? WHERE Uid = ?";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, user.getFullName());
	        statement.setString(2, user.getAvatarUrl());
	        statement.setString(3, user.getUserPhone());
	        statement.setString(4, user.getEmail());
	        statement.setString(5, user.getPassword());
	        statement.setDate(6, new java.sql.Date(user.getCreateDate().getTime()));
	        statement.setBoolean(7, user.isDelete());
	        statement.setString(8, user.getAddress());
	        statement.setBoolean(9, user.isRoleId());
	        statement.setInt(10, user.getUid());
	        statement.executeUpdate();
	    }

	    public static void delete(Connection conn, int uid) throws SQLException {
	        String sql = "DELETE FROM Users WHERE Uid = ?";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setInt(1, uid);
	        statement.executeUpdate();
	    }

}
