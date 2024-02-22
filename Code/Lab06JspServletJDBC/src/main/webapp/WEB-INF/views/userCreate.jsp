<%--
  Created by IntelliJ IDEA.
  User: ninhn
  Date: 2/19/2024
  Time: 3:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Product</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_navTop.jsp"></jsp:include>
<section class="container">
    <h3>Create Product</h3>
    <p style="color:red " >${errorString}</p>
    <form method="post" action="${pageContext.request.contextPath}/userCreate">
        <table>
            <tr>
                <td>User Name</td>
                <td><input type="text" name="username" value="${user.username}"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="text" name="pass" value="${user.pass}"/></td>
            </tr>
            <tr>
                <td>Gender</td>
                <td><input type="text" name="sex" value="${user.sex}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Ghi lại " class="btn btn-success"/>
                    <a href="productList">Quay Lại</a>
                </td>
            </tr>
        </table>
    </form>
</section>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
