package nnt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import nnt.entity.KHACHHANG_NinhNgocTuan;



public class KHACHHANG_NinhNgocTuan_Utils {
	 public static List<KHACHHANG_NinhNgocTuan> getAll(Connection conn) throws SQLException {
	        String sql = "SELECT * FROM KHACHHANG_NinhNgocTuan";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        ResultSet rs = statement.executeQuery();
	        List<KHACHHANG_NinhNgocTuan> list = new ArrayList<>();
	        while (rs.next()) {
	        	KHACHHANG_NinhNgocTuan kh = new KHACHHANG_NinhNgocTuan();
	        	kh.setMakh(rs.getString("MAKH_2110900050"));
	        	kh.setHoten(rs.getString("HOTEN_2110900050"));
	        	kh.setNgaysinh(rs.getDate("NGAYSINH_2110900050"));
	        	kh.setGioitinh(rs.getBoolean("GIOITINH_2110900050"));
	        	kh.setAnh(rs.getString("ANH_2110900050"));
	            kh.setTinhtrang(rs.getBoolean("TINHTRANG_2110900050"));
	            list.add(kh);
	        }
	        return list;
	    }
	    public static void insert(Connection conn, KHACHHANG_NinhNgocTuan khachshang) throws SQLException {
	        String sql = "insert into KHACHHANG_NinhNgocTuan (MAKH_2110900050,HOTEN_2110900050, NGAYSINH_2110900050,GIOITINH_2110900050,ANH_2110900050,TINHTRANG_2110900050) VALUES (?, ?, ?, ?, ?, ?);";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1, khachshang.getMakh());
	        statement.setString(2, khachshang.getHoten());
	        statement.setDate(3, khachshang.getNgaysinh());
	        statement.setBoolean(4, khachshang.getGioitinh());
	        statement.setString(5,khachshang.getAnh());
	        statement.setBoolean(6, khachshang.getTinhtrang());
	        statement.executeUpdate();
	    }
	 

}
