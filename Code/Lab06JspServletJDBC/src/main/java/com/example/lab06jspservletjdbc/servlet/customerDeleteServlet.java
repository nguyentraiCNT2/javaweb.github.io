package com.example.lab06jspservletjdbc.servlet;

import com.example.lab06jspservletjdbc.Utils.CustomerUtils;
import com.example.lab06jspservletjdbc.Utils.ProductUtils;
import com.example.lab06jspservletjdbc.conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/customerDelete")
public class customerDeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public customerDeleteServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorString = null;
        String idStr = req.getParameter("id");
        int id = 0;
        try{
            id = Integer.parseInt(idStr);
        }catch (Exception e){
            errorString = e.getMessage();
        }
        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            CustomerUtils.deleteCustomerByCusID(conn,id);
        }catch (Exception e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null){
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/customerDeleteWError.jsp");
            dispatcher.forward(req,resp);
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/customerList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
