package com.example.lab06jspservletjdbc.servlet;

import com.example.lab06jspservletjdbc.Utils.LoginUtils;
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

@WebServlet("/userDelete")
public class userDeleteServet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public userDeleteServet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String errorString = null;
        String username = req.getParameter("username");
        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            LoginUtils.deleteUser(conn,username);
        }catch (Exception e){
            e.printStackTrace();
            errorString = e.getMessage();
        }
        if (errorString != null){
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userDeleteError.jsp");
            dispatcher.forward(req,resp);
        }
        else {
            resp.sendRedirect(req.getContextPath()+"/userList");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
