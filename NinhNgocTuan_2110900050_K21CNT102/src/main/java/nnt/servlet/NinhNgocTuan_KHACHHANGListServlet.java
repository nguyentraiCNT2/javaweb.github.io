package nnt.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nnt.conn.NinhNgocTuanConnectionUtils;
import nnt.dao.KHACHHANG_NinhNgocTuan_Utils;
import nnt.entity.KHACHHANG_NinhNgocTuan;

@WebServlet("/KHACHHANGList")
public class NinhNgocTuan_KHACHHANGListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 Connection conn = null;
	        String errorString = null;
	        List<KHACHHANG_NinhNgocTuan> list = null;
	        try {
	            conn = NinhNgocTuanConnectionUtils.getMSSQLConnections();
	            try {
	                list = KHACHHANG_NinhNgocTuan_Utils.getAll(conn);
	            }catch (SQLException e){
	                e.printStackTrace();
	                errorString = e.getMessage();
	            }
	            req.setAttribute("errorString", errorString);
	            req.setAttribute("khachhangList", list);
	            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/NinhNgocTuan/KHACHHANGList_NinhNgocTuan.jsp");
	            dispatcher.forward(req, resp);
	        } catch (ClassNotFoundException | SQLException e1) {
	            e1.printStackTrace();
	            errorString = e1.getMessage();
	            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/NinhNgocTuan/KHACHHANGList_NinhNgocTuan.jsp");
	            req.setAttribute("errorString", errorString);
	            dispatcher.forward(req, resp);
	        }
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	

}
