package com.example.lab06jspservletjdbc.servlet;

import com.example.lab06jspservletjdbc.Utils.CustomerUtils;
import com.example.lab06jspservletjdbc.beans.Customer;
import com.example.lab06jspservletjdbc.conn.ConnectionUtils;
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

@WebServlet("/customerList")
public class CustomerListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public CustomerListServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        String errorString = null;
        List<Customer> list = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            try {
            list = CustomerUtils.getAllCustomer(conn);
            }catch (SQLException e){
                e.printStackTrace();
                errorString = e.getMessage();
            }
            req.setAttribute("errorString", errorString);
            req.setAttribute("customerList", list);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp");
            dispatcher.forward(req, resp);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
            errorString = e1.getMessage();
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/customerList.jsp");
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
