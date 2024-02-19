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

@WebServlet("/productCreate")
public class productCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public productCreateServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
        dispatcher.forward(req,resp);
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
       String regex = "\\w+";
       if (code == null || !code.matches(regex)){
           errorString = "Product Code invalid";
       }
       if (errorString != null){
req.setAttribute("errorString", errorString);
req.setAttribute("product",product);
RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
dispatcher.forward(req,resp);
return;
       }
        Connection conn = null;
       try {
           conn = ConnectionUtils.getMSSQLConnections();
           ProductUtils.insertProduct(conn,product);
           resp.sendRedirect(req.getContextPath()+"/productList");
       }catch (Exception e){
           e.printStackTrace();
           errorString = e.getMessage();
           req.setAttribute("errorString",errorString);
           RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/views/productCreate.jsp");
           dispatcher.forward(req,resp);
       }
    }
}
