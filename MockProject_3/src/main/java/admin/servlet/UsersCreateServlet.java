package admin.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;

import Conn.ConnectionUtil;
import admin.Utils.UserUtils;
import admin.entity.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CreateUser")
public class UsersCreateServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CreateUser.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String errorString = null;
		  String fullName = request.getParameter("fullName");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String password = request.getParameter("password");
	        String address = request.getParameter("diachi");
	        boolean roleId = Boolean.parseBoolean(request.getParameter("roleid"));
	        // Lấy ngày hiện tại
	        Date currentDate = new Date();
	        
	        // Chuyển đổi java.util.Date thành java.sql.Date
	        java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

	        Users users = new Users(0, fullName, null, phone, email, password, sqlDate, false, address, roleId);
	        Connection conn = null;
	        try {
	           conn = ConnectionUtil.getMSSQLConnections();
	           UserUtils.insert(conn, users);
	           response.sendRedirect(request.getContextPath() + "/userlist");	
	        } catch (Exception ex) {
	        	errorString= ex.getMessage();
	        	request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CreateUser.jsp");
				dispatcher.forward(request, response);
	        }
	}

	
	
}
