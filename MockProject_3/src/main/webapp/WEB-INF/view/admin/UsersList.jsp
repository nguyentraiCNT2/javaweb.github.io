<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="topLayout.jsp"></jsp:include>
	<section class="container">
	
		<h3>User List</h3>
		<p style="color: red;">${errorString}</p>
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Mã tài khoản</th>
					<th>Tên email</th>
					<th>Họ tên </th>
					<th>Quền hạn </th>
					<th>Tác vụ </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${userlist}" var="user">
					<tr>
						<td>${user.uid}</td>
							<td>${user.email}</td>
						<td>${user.fullName}</td>
							<td>${user.roleId}</td>
						<td>
							<a class="btn btn-success" href="EditUser?id=${user.uid}">Edit</a>
							<a class="btn btn-danger" href="deleteUser?id=${user.uid}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="CreateUser" class="btn btn-primary">Create User</a>
	</section>
<jsp:include page="botLayout.jsp"></jsp:include>