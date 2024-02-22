package com.example.lab06jspservletjdbc.servlet;

import com.example.lab06jspservletjdbc.Utils.LoginUtils;
import com.example.lab06jspservletjdbc.Utils.ProductUtils;
import com.example.lab06jspservletjdbc.beans.Product;
import com.example.lab06jspservletjdbc.beans.UserAccount;
import com.example.lab06jspservletjdbc.conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/userCreate")
public class userCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public userCreateServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userCreate.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String username = req.getParameter("username");
        String password = req.getParameter("pass");
        String gender = req.getParameter("sex");

        UserAccount userAccount = new UserAccount(username, gender, password);
        String regex = "\\w+";
        if (username == null || !username.matches(regex)) {
            errorString = "User  UserName invalid";
        }
        if (errorString != null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("user", userAccount);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userCreate.jsp");
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            LoginUtils.insertUser(conn, userAccount);
            resp.sendRedirect(req.getContextPath() + "/userList");
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userCreate.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
