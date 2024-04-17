package admin.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

import Conn.ConnectionUtil;
import admin.Utils.CategoriesUtils;
import admin.entity.Categories;

/**
 * Servlet implementation class CategoriesCreateServlet
 */
@WebServlet("/CategoriesCreate")
public class CategoriesCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesCreate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		//Lấy dữ liệu trên form
		String categoryName =  request.getParameter("categoryName");
		Categories newCategory = new Categories(0,categoryName);
		// Kiểm tra code ít nhất 1 ký tự là 0-9]
		Connection conn = null;
		
		try {
			conn = ConnectionUtil.getMSSQLConnections();
			CategoriesUtils.insert(conn, newCategory);
			response.sendRedirect(request.getContextPath()+"/CategoriesCreate");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
