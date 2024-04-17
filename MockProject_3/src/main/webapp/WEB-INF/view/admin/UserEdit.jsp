<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="topLayout.jsp"></jsp:include>
<section class="container">
    <h3>Edit User</h3>
    <p style="color: red">${errorString}</p>
    <form action="${pageContext.request.contextPath}/EditUser" method="post" >
        <table class="table table-bordered">
         <tr>
                <td>id</td>
                <td><input type="text" name="id" value="${user.uid}" required readonly /></td>
            </tr>
            <tr>
                <td>Họ tên</td>
                <td><input type="text" name="fullName" value="${user.fullName}" required /></td>
            </tr>
            <tr>
                <td>Email</td>
                <td><input type="email" name="email" value="${user.email}" required /></td>
            </tr>
            <tr>
                <td>Phone</td>
                <td><input type="text" name="phone" value="${user.userPhone}" required /></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value="${user.password}" required /></td>
            </tr>
            <tr>
                <td>Địa chỉ</td>
                
                <td><textarea rows="5" name="address" cols="50" style="resize: none"  required>${user.address}</textarea>
                </td>
            </tr>
            <tr>
                <td>Role</td>
                <td>
                    <select name="roleid">
                        <option value="">Chọn Quyền hạn</option>
                        <option value="true" ${user.roleId ? "selected" : ""}>Admin</option>
                        <option value="false" ${!user.roleId ? "selected" : ""}>User</option>
                    </select>
                </td>
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
