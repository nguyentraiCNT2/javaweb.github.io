<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="topLayout.jsp"></jsp:include>
	<section class="container">
		<h3>Create User</h3>
		<p style="color: red">${errorString}</p>
		<form method="post" action="${pageContext.request.contextPath}/CreateUser">
			<table class="table table-bordered">
					<tr>
						<td>Họ tên</td>
						<td><input type="text" name="fullName" value="${user.name}" required /></td>
					</tr>
					<tr>
						<td>Email</td>
						<td><input type="email" name="email" value="${user.name}" required /></td>
					</tr>
					<tr>
						<td>phone</td>
						<td><input type="text" name="phone" value="${user.name}" required /></td>
					</tr>
					<tr>
						<td>password</td>
						<td><input type="password" name="password" value="${user.name}" required /></td>
					</tr>
						<tr>
						<td>địa chỉ</td>
						<td><textarea rows="5" name="diachi" cols="50" style="resize: none" >${user.name}</textarea></td>
					</tr>
					<tr>
						<td>Role</td>
						<td>
						<select name="roleid">
						<option value="">Chọn Quyền hạn</option>
						<option value="true">Admin</option>
						<option value="false">User</option>
						</select>
					</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lại" class="btn btn-success">
						<a href="userlist" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
<jsp:include page="botLayout.jsp"></jsp:include>