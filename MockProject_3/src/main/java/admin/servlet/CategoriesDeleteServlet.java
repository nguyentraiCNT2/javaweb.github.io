package admin.servlet;



import Conn.ConnectionUtil;
import admin.Utils.CategoriesUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

/**
 * Servlet implementation class CategoriesDeleteServlet
 */
@WebServlet("/CategoriesDelete")
public class CategoriesDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errorString = null;
		Integer categoryId = Integer.parseInt(request.getParameter("cid")) ;
		
		Connection conn = null;

		if(errorString !=null) {
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesDelete.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
			conn = ConnectionUtil.getMSSQLConnections();
			CategoriesUtils.delete(conn, categoryId);
		} catch (Exception e) {
			errorString=e.getMessage();
			request.setAttribute("errorString", errorString);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesDelete.jsp");
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
