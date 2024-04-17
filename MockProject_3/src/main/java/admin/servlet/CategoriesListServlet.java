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
import admin.Utils.CategoriesUtils;
import admin.entity.Categories;

/**
 * Servlet implementation class CategoriesListServlet
 */
@WebServlet("/CategoriesList")
public class CategoriesListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoriesListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String errorString = null;
		List<Categories> list = null;
		Connection conn = null;
			try {
				conn = ConnectionUtil.getMSSQLConnections();
				list = CategoriesUtils.getAll(conn);
				request.setAttribute("errorString", errorString);
				request.setAttribute("categoryList", list);
				// Forward to 
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesList.jsp");
				dispatcher.forward(request, response);
			} catch (Exception e) {
				errorString=e.getMessage();
				request.setAttribute("errorString", errorString);
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesDelete.jsp");
				dispatcher.forward(request, response);
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
