package com.example.mockproject3.admin.servlet;

import com.example.mockproject3.admin.DAO.CategoriesDAOImpl;
import com.example.mockproject3.admin.entity.Categories;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
		String categoryName = (String) request.getParameter("categoryName");
		
		
		
		Categories newCategory = new Categories(categoryName);
		// Kiểm tra code ít nhất 1 ký tự là 0-9]
		
		
		try {
			boolean flag = new CategoriesDAOImpl().insertCategory(newCategory);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/CategoriesList");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
