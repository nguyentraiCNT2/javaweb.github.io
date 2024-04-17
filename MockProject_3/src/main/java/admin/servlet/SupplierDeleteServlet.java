package admin.servlet;



import Conn.ConnectionUtil;
import admin.Utils.SuppliersUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class SupplierDeleteServlet
 */
@WebServlet("/SupplierDelete")
public class SupplierDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int supplierId = Integer.parseInt(request.getParameter("supplierId")) ;
		// TODO Auto-generated method stub
		String errorString = null;
		String supplierIdStr = (String) request.getParameter("sid");
		
	

		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/SupplierDelete.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = ConnectionUtil.getMSSQLConnections();
			SuppliersUtil.delete(conn, supplierId);
		} catch (Exception e) {
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/SupplierDelete.jsp");
			dispatcher.forward(request, response);
		}
			
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
