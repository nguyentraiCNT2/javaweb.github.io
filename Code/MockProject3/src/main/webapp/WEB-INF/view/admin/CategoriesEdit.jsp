<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="topLayout.jsp"></jsp:include>
	<section class="container">
		<h3>Edit Category</h3>
		<p style="color: red;">${errorString}</p>
		<c:if test="${empty category}">
			<a href="CategoriesList"> Quay lại</a>
		</c:if>
		<c:if test="${not empty category}">
			<form method="POST" action="${pageContext.request.contextPath}/CategoriesEdit">
				<table class="table table-bordered">
					<tr>
						<td>Mã danh mục</td>
						<td><input type="text" name="categoryId" value="${category.cid}" readOnly/></td>
					</tr>
					<tr>
						<td>Tên danh mục</td>
						<td><input type="text" name="categoryName" value="${category.name}" required /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Ghi lại" class="btn btn-success">
							<a href="CategoriesList" class="btn btn-danger"> Quay lại</a>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
	</section>
<jsp:include page="botLayout.jsp"></jsp:include>