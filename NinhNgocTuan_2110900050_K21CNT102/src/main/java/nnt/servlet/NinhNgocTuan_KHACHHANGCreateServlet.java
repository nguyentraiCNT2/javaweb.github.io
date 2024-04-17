package nnt.servlet;

import java.io.IOException;
import java.sql.Connection;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nnt.conn.NinhNgocTuanConnectionUtils;
import nnt.dao.KHACHHANG_NinhNgocTuan_Utils;
import nnt.entity.KHACHHANG_NinhNgocTuan;


@WebServlet("/KHACHHANGCreate")
public class NinhNgocTuan_KHACHHANGCreateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/NinhNgocTuan/KHACHHANGCreate_NinhNgocTuan.jsp");
	        dispatcher.forward(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 req.setCharacterEncoding("UTF-8");
	        String errorString = null;
	        String makh = req.getParameter("makh");
	        String hoten = req.getParameter("hoten");
	        String ngaysinhStr = req.getParameter("ngaysinh");
	        String gioitinhstr = req.getParameter("gioitinh");
	        String anh = req.getParameter("anh");
	        String tinhtrangstr = req.getParameter("tinhtrang");
	     
	  
	        java.sql.Date Datesql = null;
	       Boolean gioitinh = null;
	       Boolean tinhtrang = null;
	        try {
	        	if(gioitinhstr == "true") {
	        		gioitinh = true;
	        	}else {
	        		gioitinh = false;
				}
	          	if(tinhtrangstr == "true") {
	          		tinhtrang = true;
	        	}else {
	        		tinhtrang = false;
				}
	            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	            Date parsed = format.parse(ngaysinhStr);
	           Datesql = new java.sql.Date(parsed.getTime());
	        	
	        }catch (Exception e){
	            errorString = e.getMessage();
	        }

	        KHACHHANG_NinhNgocTuan Khachhang = new KHACHHANG_NinhNgocTuan(makh,hoten,Datesql,gioitinh,anh,tinhtrang);
	        if (errorString != null) {
	            req.setAttribute("errorString", errorString);
	            req.setAttribute("Khachhang", Khachhang);
	            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/NinhNgocTuan/KHACHHANGCreate_NinhNgocTuan.jsp");
	            dispatcher.forward(req, resp);
	            return;
	        }

	        Connection conn = null;
	        try {
	            conn = NinhNgocTuanConnectionUtils.getMSSQLConnections();
	            KHACHHANG_NinhNgocTuan_Utils.insert(conn, Khachhang);
	            resp.sendRedirect(req.getContextPath() + "/KHACHHANGList");
	        } catch (Exception e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	            req.setAttribute("errorString", errorString);
	            RequestDispatcher dispatcher = req.getServletContext().getRequestDispatcher("/WEB-INF/NinhNgocTuan/KHACHHANGCreate_NinhNgocTuan.jsp");
	            dispatcher.forward(req, resp);
	        }
	}

}
