<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_navTop.jsp"></jsp:include>
<section class="container">
    <h3>Customer List</h3>
    <p style="color:red">${errorString}</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>CusID</th>
            <th>CusUser</th>
            <th>CusPass</th>
            <th>CusName</th>
            <th>CusPhone</th>
            <th>CusAdd</th>
            <th>CusEmail</th>
            <th>CusFacebook</th>
            <th>CusSkyber</th>
            <th>CusStatus</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach  var="customer" items="${customerList}">
            <tr>
                <td>${customer.CusID}</td>
                <td>${customer.CusUser}</td>
                <td>${customer.CusPass}</td>
                <td>${customer.CusName}</td>
                <td>${customer.CusPhone}</td>
                <td>${customer.CusAdd}</td>
                <td>${customer.CusEmail}</td>
                <td>${customer.CusFacebook}</td>
                <td>${customer.CusSkyber}</td>
                <td>
                    <c:if test="${customer.CusStatus == 0}">
                        <p>inactive</p>
                    </c:if>
                    <c:if test="${customer.CusStatus == 1}">
                        <p>activate</p>
                    </c:if>
                </td>
                <td>
                    <a href="customerEdit?CusID=${customer.CusID}">Edit</a>
                </td>
                <td>
                    <a href="customerDelete?CusID=${customer.CusID}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="productCreate"> Create Product</a>
</section>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
