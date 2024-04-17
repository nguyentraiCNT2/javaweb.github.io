<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="topLayout.jsp"></jsp:include>
	<section class="container">
	
		<h3>Category List</h3>
		<p style="color: red;">${errorString}</p>
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Mã danh mục</th>
					<th>Tên danh mục</th>
					<th>Tác vụ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categoryList}" var="category">
					<tr>
						<td>${category.cid}</td>
						<td>${category.name}</td>
						<td>
							<a class="btn btn-success" href="CategoriesEdit?cid=${category.cid}">Edit</a>
							<a class="btn btn-danger" href="CategoriesDelete?cid=${category.cid}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="CategoriesCreate">Create Category</a>
	</section>
<jsp:include page="botLayout.jsp"></jsp:include>