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

@WebServlet("/userEdit")
public class UserEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserEditServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userEdit.jsp");
        String username = req.getParameter("username");
        if (username == null || username == "") {
            errorString = "bạn chưa chọn tài khoản cần sửa ";
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        UserAccount userAccount = null;
        errorString = null;

        try {
            conn = ConnectionUtils.getMSSQLConnections();
            userAccount = LoginUtils.findUser(conn, username);
            if (userAccount == null) {
                errorString = "Không tìm thấy tài khoản có tên " + username;

            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();

        }
        if (errorString == null || userAccount == null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("user", userAccount);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String username = req.getParameter("username");
        String password = req.getParameter("pass");
        String gender = req.getParameter("sex");
        UserAccount userAccount = new UserAccount(username, gender, password);
        if (errorString != null ){
            req.setAttribute("errorString", errorString);
            req.setAttribute("user", userAccount);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userEdit.jsp");
            dispatcher.forward(req,resp);
        }
        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            LoginUtils.updateUser(conn,userAccount);
            resp.sendRedirect(req.getContextPath()+"/userList");

        }catch (Exception e){
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            req.setAttribute("user", userAccount);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/userEdit.jsp");
            dispatcher.forward(req,resp);
        }
    }
    }

