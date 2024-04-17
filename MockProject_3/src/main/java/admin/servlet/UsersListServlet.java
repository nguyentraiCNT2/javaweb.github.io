package admin.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import Conn.ConnectionUtil;
import admin.Utils.CategoriesUtils;
import admin.Utils.UserUtils;
import admin.entity.Categories;
import admin.entity.Users;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userlist")
public class UsersListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String errorString = null;
		List<Users> list = null;
		Connection conn = null;
			try {
				conn = ConnectionUtil.getMSSQLConnections();
				list = UserUtils.getAll(conn);
				req.setAttribute("errorString", errorString);
				req.setAttribute("userlist", list);
				// Forward to 
				RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/UsersList.jsp");
				dispatcher.forward(req, resp);
			} catch (Exception e) {
				errorString=e.getMessage();
				req.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/UsersList.jsp");
				dispatcher.forward(req, resp);
			}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
