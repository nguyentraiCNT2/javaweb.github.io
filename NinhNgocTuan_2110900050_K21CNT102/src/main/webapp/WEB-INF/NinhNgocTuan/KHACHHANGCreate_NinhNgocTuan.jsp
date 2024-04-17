<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create New </title>
</head>
<body>
<h1>Create New Khách hàng</h1>
<form action="${pageContext.request.contextPath}/KHACHHANGCreate" method="post">
    Mã khách hàng: <input type="text" name="makh"><br>
    họ và tên : <input type="text" name="hoten"><br>
    ngày sinh : <input type="date" name="ngaysinh"><br>
    giới tính:
    			<select name="gioitinh">
    				<option value="">Chọn giới tính</option>
    				<option value="true"> Nam</option>
    				<option value="false"> Nữ</option>
    			</select><br>
    Ảnh: <input type="text" name="anh"><br>
    Tình trạng:<select name="tinhtrang">
    				<option value="">Chọn trạng thái </option>
    				<option value="true">Hiển thị </option>
    				<option value="false"> Đang ẩn </option>
    			</select><br>
    <input type="submit" value="Create">
</form>
<a href="KHACHHANGList">Back toList</a>
</body>
</html>
