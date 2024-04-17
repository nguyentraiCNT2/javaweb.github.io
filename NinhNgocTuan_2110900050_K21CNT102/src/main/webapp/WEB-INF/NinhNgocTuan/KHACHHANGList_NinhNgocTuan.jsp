<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Khách hàng Ninh Ngọc Tuấn List</title>
</head>
<body>
<h1>Khách hàng Ninh Ngọc Tuấn List</h1>
<p>${errorString}</p>
<table border="1">
    <tr>
        <th>Mã Khách hàng </th>
        <th>họ tên khách hàng </th>
        <th>ngày sinh</th>
        <th>giới tính </th>
        <th>ảnh </th>
        <th>trạng thái </th>
    </tr>
    <%-- Loop through the list of books and display each book --%>
    <c:forEach var="khachhang" items="${khachhangList}">
        <tr>
            <td>${khachhang.makh}</td>
            <td>${khachhang.hoten}</td>
            <td>${khachhang.ngaysinh}</td>
            <c:if test="${khachhang.gioitinh == true}">
             <td>Nam</td>
            </c:if>
            <c:if test="${khachhang.gioitinh == false}">
               <td>Nữ</td>
            </c:if>
            <td>${khachhang.anh}</td>
            
             <c:if test="${khachhang.tinhtrang == false}">
               <td>Đang ẩn </td>
            </c:if>
                <c:if test="${khachhang.tinhtrang == true}">
               <td>Hiển thị</td>
            </c:if>
        </tr>
    </c:forEach>
</table>
<br>
<a href="KHACHHANGCreate">Create New Book</a>
</body>
</html>
