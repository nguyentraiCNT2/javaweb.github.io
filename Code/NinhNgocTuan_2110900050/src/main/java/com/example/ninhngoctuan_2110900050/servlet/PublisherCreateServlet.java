package com.example.ninhngoctuan_2110900050.servlet;

import com.example.ninhngoctuan_2110900050.beans.Category;
import com.example.ninhngoctuan_2110900050.beans.Publisher;
import com.example.ninhngoctuan_2110900050.conn.ConnectionUtils;
import com.example.ninhngoctuan_2110900050.utils.CategoryUtils;
import com.example.ninhngoctuan_2110900050.utils.PubLisherUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/AddPublisherServlet")
public class PublisherCreateServlet extends HttpServlet {
    public PublisherCreateServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreatePublisher.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String publisherName = req.getParameter("publisherName");
        String phone = req.getParameter("phone");
        String address = req.getParameter("address");

        Publisher publisher = new Publisher(0,publisherName,phone,address);
        if (errorString != null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("publisher", publisher);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreatePublisher.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            PubLisherUtils.addPublisher(conn, publisher);
            resp.sendRedirect(req.getContextPath() + "/PublisherList");
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/CreatePublisher.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
