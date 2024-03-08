package com.example.ninhngoctuan_2110900050.servlet;

import com.example.ninhngoctuan_2110900050.beans.Book;
import com.example.ninhngoctuan_2110900050.beans.Category;
import com.example.ninhngoctuan_2110900050.conn.ConnectionUtils;
import com.example.ninhngoctuan_2110900050.utils.BookUtils;
import com.example.ninhngoctuan_2110900050.utils.CategoryUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/EditCategory")
public class CategoryEditServlet extends HttpServlet {
    public CategoryEditServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditCategory.jsp");
        String idStr = req.getParameter("id");
        Integer id = 0;
        try{
            id = Integer.parseInt(idStr);
        }catch (Exception e){
            e.printStackTrace();
        }
        if (id == 0) {
            errorString = "bạn chưa chọn sản phẩm cần sửa ";
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        Category category = null;
        errorString = null;

        try {
            conn = ConnectionUtils.getMSSQLConnections();
            category = CategoryUtils.findCategoryById(conn, id);
            if (category == null) {
                errorString = "Không tìm thấy sản phẩm có mã " + id;

            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();

        }
        if (errorString == null || category == null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("category", category);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String categoryId = req.getParameter("categoryId");
        String categoryName = req.getParameter("categoryName");
        Integer id = 0;
        try{
            id = Integer.parseInt(categoryId);
        }catch (Exception e){
            e.printStackTrace();
        }
        Category category = new Category(id,categoryName);
        if (errorString != null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("category", category);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditCategory.jsp");
            dispatcher.forward(req, resp);

        }

        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            CategoryUtils.updateCategory(conn, category);
            resp.sendRedirect(req.getContextPath() + "/CategoryList");

        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            req.setAttribute("category", category);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/EditCategory.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
