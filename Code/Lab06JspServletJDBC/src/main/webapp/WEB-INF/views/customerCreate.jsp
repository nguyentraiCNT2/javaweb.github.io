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
    <title>Create Customer</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="_header.jsp"></jsp:include>
<jsp:include page="_navTop.jsp"></jsp:include>
<section class="container">
    <h3>Create Product</h3>
    <p style="color:red " >${errorString}</p>
    <form method="post" action="${pageContext.request.contextPath}/customerCreate">
        <table>
            <tr>
                <td>CusUser</td>
                <td><input type="text" name="user" value="${customer.user}"/></td>
            </tr>
            <tr>
                <td>CusPass</td>
                <td><input type="text" name="pass" value="${customer.pass}"/></td>
            </tr>
            <tr>
                <td>CusName</td>
                <td><input type="text" name="name" value="${customer.name}"/></td>
            </tr>
            <tr>
                <td>CusPhone</td>
                <td><input type="text" name="phone" value="${customer.phone}"/></td>
            </tr>
            <tr>
                <td>CusAdd</td>
                <td><input type="text" name="add" value="${customer.add}"/></td>
            </tr>
            <tr>
                <td>CusEmail</td>
                <td><input type="text" name="email" value="${customer.email}"/></td>
            </tr>
            <tr>
                <td>CusFacebook</td>
                <td><input type="text" name="facebook" value="${customer.facebook}"/></td>
            </tr>
            <tr>
                <td>CusSkyber</td>
                <td><input type="text" name="skyber" value="${customer.skyber}"/></td>
            </tr>
            <tr>
                <td>CusStatus</td>
                <td><input type="text" name="status" value="${customer.status}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Ghi lại " class="btn btn-success"/>
                    <a href="customerList">Quay Lại</a>
                </td>
            </tr>
        </table>
    </form>
</section>
<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
