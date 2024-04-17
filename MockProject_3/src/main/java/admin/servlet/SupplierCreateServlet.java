package admin.servlet;



import Conn.ConnectionUtil;
import admin.Utils.CategoriesUtils;
import admin.Utils.SuppliersUtil;
import admin.entity.Categories;
import admin.entity.Suppliers;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class SupplierCreateServlet
 */
@WebServlet("/SupplierCreate")
public class SupplierCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierCreateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/SupplierCreate.jsp");
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
		String supplierName = (String) request.getParameter("supplierName");
		
		
		
		Suppliers newSupplier = new Suppliers(0,supplierName);
		// Kiểm tra code ít nhất 1 ký tự là 0-9]

		// Kiểm tra code ít nhất 1 ký tự là 0-9]
		Connection conn = null;
		
		try {
			conn = ConnectionUtil.getMSSQLConnections();
			SuppliersUtil.insert(conn, newSupplier);
			response.sendRedirect(request.getContextPath()+"/SupplierCreate");
			
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesCreate.jsp");
			dispatcher.forward(request, response);
		}
	}

}
