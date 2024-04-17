<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="topLayout.jsp"></jsp:include>
	<section class="container">
		<h3>Create Supplier</h3>
		<p style="color: red">${errorString}</p>
		<form method="post" action="${pageContext.request.contextPath}/SupplierCreate">
			<table class="table table-bordered">
					<tr>
						<td>Tên nhà cung cấp</td>
						<td><input type="text" name="supplierName" value="${supplier.name}" required /></td>
					</tr>
				<tr>
					<td></td>
					<td>
						<input type="submit" value="Ghi lại" class="btn btn-success">
						<a href="SupplierList" class="btn btn-danger">Quay lại</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
<jsp:include page="botLayout.jsp"></jsp:include>