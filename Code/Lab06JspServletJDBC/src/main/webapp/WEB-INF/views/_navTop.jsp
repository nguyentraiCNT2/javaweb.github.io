<%--
  Created by IntelliJ IDEA.
  User: ninhn
  Date: 2/19/2024
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    nav{
        background-color: #3578E5;
    }
    nav ul{
        display: flex;
        justify-content: flex-start;
        align-items: center;
        list-style: none;
    }
    nav ul li a {
        color: #fff;
        display: block;
        padding: 1rem;
        text-decoration: none;
    }
    nav ul li:first-child a{
        padding-left: 0 !important;
    }
    nav ul li a:hover{
        color: yellow;
    }
</style>
<nav>
    <ul class="container">
        <li>
            <a href="${pageContext.request.contextPath}/home">
                Home
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/productList">
            Product List
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/userList">
                User List
            </a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/customerList">
                Customer List
            </a>
        </li>
    </ul>
</nav>