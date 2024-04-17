<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="topLayout.jsp"></jsp:include>
	<section class="container border my-2" style="min-height:150px">
		<h3 class="my-5">Delete Category</h3>
		<p style="color: red">${errorString}</p>
		<a href="CategoriesList" class="btn btn-danger">Category List</a>
	</section>
<jsp:include page="botLayout.jsp"></jsp:include>