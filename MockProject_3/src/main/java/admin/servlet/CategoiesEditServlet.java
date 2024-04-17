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
 * Servlet implementation class CategoiesEditServlet
 */
@WebServlet("/CategoriesEdit")
public class CategoiesEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoiesEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesEdit.jsp");
		String categoryIdStr = (String) request.getParameter("cid");
		if(categoryIdStr == null || categoryIdStr == "") {
			errorString="Bạn chưa chọn danh mục cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Categories category = null;
		errorString = null;
		Connection conn = null;
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		try {
			conn = ConnectionUtil.getMSSQLConnections();
			category = CategoriesUtils.getById(conn, categoryId);
			if(category==null) {
				errorString="Không tìm thấy danh mục nào có mã" + categoryIdStr;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || category == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("category", category);
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String errorString = null;
		// Lấy dữ liệu trên form
		String categoryName = (String) request.getParameter("categoryName");
		String categoryIdStr = (String) request.getParameter("categoryId");
		
		int categoryId = 0;
		try {
			categoryId = Integer.parseInt(categoryIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		
		Categories category = new Categories(categoryId, categoryName);

		
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("category", category);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = ConnectionUtil.getMSSQLConnections();
			CategoriesUtils.update(conn, category);
			response.sendRedirect(request.getContextPath()+"/CategoriesList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("category", category);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
