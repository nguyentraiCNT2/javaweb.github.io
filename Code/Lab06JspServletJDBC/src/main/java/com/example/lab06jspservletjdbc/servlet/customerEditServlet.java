package com.example.lab06jspservletjdbc.servlet;

import com.example.lab06jspservletjdbc.Utils.CustomerUtils;
import com.example.lab06jspservletjdbc.Utils.ProductUtils;
import com.example.lab06jspservletjdbc.beans.Customer;
import com.example.lab06jspservletjdbc.beans.Product;
import com.example.lab06jspservletjdbc.conn.ConnectionUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;

@WebServlet("/customerEdit")
public class customerEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public customerEditServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/customerEdit.jsp");
        String idStr = req.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        }catch (Exception e){
            errorString = e.getMessage();
        }

        if ( id == 0) {
            errorString = "bạn chưa chọn sản phẩm cần sửa ";
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        Customer customer = null;
        errorString = null;

        try {
            conn = ConnectionUtils.getMSSQLConnections();
            customer = CustomerUtils.findByCusID(conn, id);
            if (customer == null) {
                errorString = "Không tìm thấy sản phẩm có mã " + id;

            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();

        }
        if (errorString == null || customer == null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("customer", customer);
            dispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String user = req.getParameter("user");
        String pass = req.getParameter("pass");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String add = req.getParameter("add");
        String email = req.getParameter("email");
        String facebook = req.getParameter("facebook");
        String skyber = req.getParameter("skyber");
        String statusStr = req.getParameter("status");
        Byte status = 0;
        String idStr = req.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        }catch (Exception e){
            errorString = e.getMessage();
        }
        try {
            status = Byte.parseByte(statusStr);

        }catch (Exception e){
            errorString = e.getMessage();

        }
        Customer customer = new Customer(id,user,pass,name,phone,add,email,facebook,skyber,status);
        if (errorString != null ){
            req.setAttribute("errorString", errorString);
            req.setAttribute("customer", customer);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/customerEdit.jsp");
            dispatcher.forward(req,resp);
        }
        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            CustomerUtils.updateCustomer(conn,customer);
            resp.sendRedirect(req.getContextPath()+"/customerList");

        }catch (Exception e){
            e.printStackTrace();
            errorString = e.getMessage();
            req.setAttribute("errorString", errorString);
            req.setAttribute("customer", customer);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/customerEdit.jsp");
            dispatcher.forward(req,resp);
        }
    }

}
