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
    import java.util.List;

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
			
		list = new CategoriesDAOImpl().getAllCategory();
		// Store info in request attribute, before forward to views
		request.setAttribute("errorString", errorString);
		request.setAttribute("categoryList", list);
		// Forward to 
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/view/admin/CategoriesList.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
