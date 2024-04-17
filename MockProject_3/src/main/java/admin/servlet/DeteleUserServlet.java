package admin.servlet;

import java.io.IOException;
import java.sql.Connection;

import Conn.ConnectionUtil;
import admin.Utils.CategoriesUtils;
import admin.Utils.SuppliersUtil;
import admin.Utils.UserUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeteleUserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  String errorString = null;
	        String idS = req.getParameter("id");
	            Integer id = 0;
	            try {
	                id = Integer.parseInt(idS);
	            }catch (Exception e){
	                e.printStackTrace();
	            }
	        Connection conn = null;
	        try {
	            conn = ConnectionUtil.getMSSQLConnections();
	            UserUtils.delete(conn,id);

	        }catch (Exception e){
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        if (errorString != null){
	            req.setAttribute("errorString", errorString);
	            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/DeleteCategoryError.jsp");
	            dispatcher.forward(req,resp);
	        }
	        else {
	            resp.sendRedirect(req.getContextPath()+"/userlist");
	        }
		// TODO Auto-generated method stub
	
	}
	

}
