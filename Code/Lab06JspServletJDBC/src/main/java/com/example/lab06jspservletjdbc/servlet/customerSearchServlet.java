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
import java.util.List;

@WebServlet("/customerSearch")
public class customerSearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public customerSearchServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = null;
        String errorString = null;
        String searchCusUser = req.getParameter("searchCusUser");
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/customerSearch.jsp");
        if (searchCusUser == null || searchCusUser == "") {
            errorString = "Bạn chưa nhập khách hàng cần tìm";
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
            return;
        }
        List<Customer> customers = null;
        errorString = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            customers = CustomerUtils.findByCusUser(conn, searchCusUser);
            if (customers.size() == 0) {
                errorString = "Không tìm thấy sản phẩm có CusUser " + searchCusUser;

            }

        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString == null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("customer", customers);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
