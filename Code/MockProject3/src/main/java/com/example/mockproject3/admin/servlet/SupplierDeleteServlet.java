package com.example.mockproject3.admin.servlet;

import com.example.mockproject3.admin.DAO.SupplierDAOImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

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
		// TODO Auto-generated method stub
		String errorString = null;
		String supplierIdStr = (String) request.getParameter("sid");
		
		int supplierId = 0;
		try {
			supplierId = Integer.parseInt(supplierIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}

		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/SupplierDelete.jsp");
			dispatcher.forward(request, response);
		}else {
			
			boolean flag = new SupplierDAOImpl().deleteSupplier(supplierId);
			if(flag == true) {
				response.sendRedirect(request.getContextPath() + "/SupplierList");
			}
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
