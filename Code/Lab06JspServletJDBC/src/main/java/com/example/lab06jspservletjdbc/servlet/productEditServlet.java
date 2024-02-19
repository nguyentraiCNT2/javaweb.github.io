package com.example.lab06jspservletjdbc.servlet;

import com.example.lab06jspservletjdbc.Utils.ProductUtils;
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

@WebServlet("/productEdit")
public class productEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public productEditServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
        String code = req.getParameter("code");
        if (code == null || code == "") {
            errorString = "bạn chưa chọn sản phẩm cần sửa ";
            req.setAttribute("errorString", errorString);
            dispatcher.forward(req, resp);
            return;
        }
        Connection conn = null;
        Product product = null;
        errorString = null;

        try {
            conn = ConnectionUtils.getMSSQLConnections();
            product = ProductUtils.queryProduct(conn, code);
            if (product == null) {
                errorString = "Không tìm thấy sản phẩm có mã " + code;

            }
        } catch (Exception e) {
            e.printStackTrace();
            errorString = e.getMessage();

        }
        if (errorString == null || product == null) {
            req.setAttribute("errorString", errorString);
            req.setAttribute("product", product);
            dispatcher.forward(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String errorString = null;
        String code = req.getParameter("code");
        String name = req.getParameter("name");
        String priceStr = req.getParameter("price");
        float price =  0;
        try {
            price = Float.parseFloat(priceStr);

        }catch (Exception e){
            errorString = e.getMessage();

        }
        Product product = new Product(code, name, price);
        if (errorString != null ){
            req.setAttribute("errorString", errorString);
            req.setAttribute("product", product);
            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
            dispatcher.forward(req,resp);
        }
        Connection conn = null;
        try {
            conn = ConnectionUtils.getMSSQLConnections();
            ProductUtils.updateProduct(conn,product);
            resp.sendRedirect(req.getContextPath()+"/productList");

        }catch (Exception e){
        e.printStackTrace();
        errorString = e.getMessage();
        req.setAttribute("errorString", errorString);
        req.setAttribute("product", product);
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/productEdit.jsp");
        dispatcher.forward(req,resp);
        }
    }
}
