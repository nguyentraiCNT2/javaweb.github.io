<%--
  Created by IntelliJ IDEA.
  User: ninhn
  Date: 2/19/2024
  Time: 2:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>User List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_navTop.jsp"></jsp:include>
<section class="container">
    <h3>Product List</h3>
    <p style="color:red " >${errorString}</p>
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Username</th>
            <th>Gender</th>
            <th>Password</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>

        </thead>
        <tbody>
        <c:forEach items="${userList}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>
                    <c:if test="${user.sex == 'M'}" >
                        MALE
                    </c:if>
                    <c:if test="${user.sex == 'F'}" >
                        FEMALE
                    </c:if>
                </td>
                <td>${user.pass}</td>
                <td>
                    <a href="userEdit?username=${user.username}">Edit</a>
                </td>
                <td>
                    <a href="userDelete?username=${user.username}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="userCreate"> Create User</a>
</section>
<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>
