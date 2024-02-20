<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Customer Search</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_navTop.jsp"></jsp:include>
<section class="container">
    <h3>Customer List</h3>
    <a href="customerList"> Back</a>
    <form action="${pageContext.request.contextPath}/customerSearch" method="get">
        <label >Search by CusUser:</label>
        <input type="text" name="searchCusUser" />
        <input type="submit" value="Search" />
    </form>
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
        <c:forEach  var="customer" items="${customer}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.user}</td>
                <td>${customer.pass}</td>
                <td>${customer.name}</td>
                <td>${customer.phone}</td>
                <td>${customer.add}</td>
                <td>${customer.email}</td>
                <td>${customer.facebook}</td>
                <td>${customer.skyber}</td>
                <td>
                    <c:if test="${customer.status == 0}">
                        <p>inactive</p>
                    </c:if>
                    <c:if test="${customer.status == 1}">
                        <p>activate</p>
                    </c:if>
                </td>
                <td>
                    <a href="customerEdit?id=${customer.id}">Edit</a>
                </td>
                <td>
                    <a href="customerDelete?id=${customer.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="customerCreate"> Create Product</a>
</section>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
