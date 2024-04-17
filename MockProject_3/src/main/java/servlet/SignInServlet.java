package servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Conn.ConnectionUtil;
import admin.entity.Users;

@WebServlet("/sign-in")
public class SignInServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/view/sign_in.jsp");
        dispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html;charset=UTF-8");
	        String errorString  = null;
	        String email = req.getParameter("email");
	        String password = req.getParameter("password");
	        HttpSession session = req.getSession();
	        try {
	            if (email != null && password != null) {
	                Connection connection = ConnectionUtil.getMSSQLConnections();
	                String sql = "SELECT * FROM Users WHERE email = ? AND password = ?";
	                try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	                    preparedStatement.setString(1, email);
	                    preparedStatement.setString(2, password);

	                    try (ResultSet rs = preparedStatement.executeQuery()) {
	                        if (rs.next()) {
	                        	Users user = new Users();
	            	        	user.setUid(rs.getInt("Uid"));
	            	        	user.setEmail(rs.getString("Full_Name"));
	            	           	user.setAvatarUrl(rs.getString("Avatar_Url"));
	            	           	user.setUserPhone(rs.getString("User_Phone"));
	            	          	user.setEmail(rs.getString("Email"));
	            	          	user.setPassword(rs.getString("Password"));
	            	          	user.setCreateDate(rs.getDate("Create_Date"));
	            	        	user.setDelete(rs.getBoolean("Is_Delete"));
	            	        	user.setAddress(rs.getString("Address"));
	            	        	user.setRoleId(rs.getBoolean("Role_id"));	
	            	        	if(user.isRoleId()==true) {
	            	        		session.setAttribute("users", user);
		            	        	req.setAttribute("email", user.getEmail());
		                        	resp.sendRedirect(req.getContextPath() + "/adminIndex");	
	            	        	}
	            	        	else {
	            	        		session.setAttribute("users", user);
		            	        	req.setAttribute("email", user.getEmail());
		                        	resp.sendRedirect(req.getContextPath() + "/index_logined");	
								}
	            	        	
	                        } else {
	                        	errorString = "Tài khoản không tồn tại.";
	                            req.setAttribute("errorString", errorString);
	                            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/view/sign_in.jsp");
	                            dispatcher.forward(req, resp);
	                        }
	                    }
	                }

	                connection.close();
	            } else {
	            	errorString = "có lỗi ";
                 req.setAttribute("errorString", errorString);
                 RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/view/sign_in.jsp");
                 dispatcher.forward(req, resp);
	            }
	        } catch (Exception ex) {
	        	errorString = ex.getMessage();
	        	
	        	req.setAttribute("errorString", errorString);
                RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/view/sign_in.jsp");
                dispatcher.forward(req, resp);
	        }
	}
	

}
