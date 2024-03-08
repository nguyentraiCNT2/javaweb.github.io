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
import java.sql.SQLException;
import java.util.List;

@WebServlet("/CategoryList")
public class CategoryListServlet extends HttpServlet {

    public CategoryListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        String errorString = null;
        List<Category> list = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            try {
                list = CategoryUtils.getAllCategories(conn);
            }catch (SQLException e){
                e.printStackTrace();
                errorString = e.getMessage();
            }
            req.setAttribute("errorString", errorString);
            req.setAttribute("categoryList", list);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryList.jsp");
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
            errorString = e1.getMessage();
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CategoryList.jsp");
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
