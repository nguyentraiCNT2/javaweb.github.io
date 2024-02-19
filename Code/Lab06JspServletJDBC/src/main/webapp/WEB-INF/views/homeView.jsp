<%--
  Created by IntelliJ IDEA.
  User: ninhn
  Date: 2/19/2024
  Time: 12:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Home page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
<jsp:include page="_header.jsp" ></jsp:include>
<jsp:include page="_navTop.jsp" ></jsp:include>
<section class="container border my-2 " style="min-height: 150px">
<h1 class="text-center my-5">Welcome to HOMEPAGE</h1>
</section>
<jsp:include page="_footer.jsp" ></jsp:include>

</body>
</html>
