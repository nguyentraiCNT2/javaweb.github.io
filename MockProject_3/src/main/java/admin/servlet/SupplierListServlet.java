package admin.servlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import Conn.ConnectionUtil;
import admin.Utils.SuppliersUtil;
import admin.entity.Suppliers;

/**
 * Servlet implementation class SupplierListServlet
 */
@WebServlet("/SupplierList")
public class SupplierListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errorString = null;
		List<Suppliers> list = null;
		Connection conn = null;
			try {
				conn = ConnectionUtil.getMSSQLConnections();
				list = SuppliersUtil.getAll(conn);
				request.setAttribute("errorString", errorString);
				request.setAttribute("supplierList", list);
				// Forward to 
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/SupplierList.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
	
		// Store info in request attribute, before forward to views
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
