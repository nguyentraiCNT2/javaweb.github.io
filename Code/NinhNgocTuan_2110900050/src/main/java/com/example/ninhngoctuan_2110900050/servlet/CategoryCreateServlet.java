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

@WebServlet("/AddCategoryServlet")
public class CategoryCreateServlet extends HttpServlet {
    public CategoryCreateServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreateCategory.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String categoryName = req.getParameter("categoryName");

        Category category = new Category(0,categoryName);
        if (errorString != null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("category", category);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreateCategory.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            CategoryUtils.addCategory(conn, category);
            resp.sendRedirect(req.getContextPath() + "/CategoryList");
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreateCategory.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
