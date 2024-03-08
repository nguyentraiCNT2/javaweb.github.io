package com.ninhngoctuan.day10_ontap_jdbc.servlet;

import com.ninhngoctuan.day10_ontap_jdbc.dao.DEPARTMENTDAO;
import com.ninhngoctuan.day10_ontap_jdbc.dao.IMPL.DEPARTMENTDAOIMPL;
import com.ninhngoctuan.day10_ontap_jdbc.entity.DEPARTMENT;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

@WebServlet("/DepartmentList")
public class DepartmentServlet extends HttpServlet {
    private final DEPARTMENTDAO departmentDAO = new DEPARTMENTDAOIMPL();
    public DepartmentServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<DEPARTMENT> departments = departmentDAO.getAll();
        req.setAttribute("departments", departments);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/DepartmentList.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
