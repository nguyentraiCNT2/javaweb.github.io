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
import admin.Utils.SuppliersUtil;
import admin.entity.Suppliers;

/**
 * Servlet implementation class SupplierEditServlet
 */
@WebServlet("/SupplierEdit")
public class SupplierEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierEditServlet() {
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
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/SupplierEdit.jsp");
		String supplierIdStr = (String) request.getParameter("sid");
		if(supplierIdStr == null || supplierIdStr == "") {
			errorString="Bạn chưa chọn danh mục cần sửa";
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
			return;
		}
		Suppliers supplier = null;
		errorString = null;
		
		int supplierId = 0;
		try {
			supplierId = Integer.parseInt(supplierIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		Connection conn = null;
		try {
			conn = ConnectionUtil.getMSSQLConnections();
			supplier = SuppliersUtil.getById(conn,supplierId);
			if(supplier==null) {
				errorString="Không tìm thấy danh mục nào có mã" + supplierIdStr;
			}
		}catch(Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		// Khi có lỗi
		if(errorString != null || supplier == null) {
			request.setAttribute("errorString", errorString);
			dispatcher.forward(request, response);
		return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("supplier", supplier);
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
		String supplierName = (String) request.getParameter("supplierName");
		String supplierIdStr = (String) request.getParameter("supplierId");
		
		int supplierId = 0;
		try {
			supplierId = Integer.parseInt(supplierIdStr);
		} catch (Exception e) {
			errorString=e.getMessage();
		}
		
		Suppliers supplier = new Suppliers(supplierId, supplierName);

		
		if (errorString != null) {
			request.setAttribute("errorString", errorString);
			request.setAttribute("supplier", supplier);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/SupplierEdit.jsp");
			dispatcher.forward(request, response);
		}
		Connection conn = null;
		try {
			conn = ConnectionUtil.getMSSQLConnections();
			SuppliersUtil.update(conn,supplier);
			response.sendRedirect(request.getContextPath()+"/SupplierList");
		} catch (Exception e) {
			e.printStackTrace();
			errorString = e.getMessage();
			request.setAttribute("errorString", errorString);
			request.setAttribute("supplier", supplier);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/SupplierEdit.jsp");
			dispatcher.forward(request, response);
		}
	}

}
