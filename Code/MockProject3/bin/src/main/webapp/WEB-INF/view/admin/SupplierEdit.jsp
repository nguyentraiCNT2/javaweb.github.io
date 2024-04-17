<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="topLayout.jsp"></jsp:include>
	<section class="container">
		<h3>Edit Supplier</h3>
		<p style="color: red;">${errorString}</p>
		<c:if test="${empty supplier}">
			<a href="SupplierList"> Quay lại</a>
		</c:if>
		<c:if test="${not empty supplier}">
			<form method="POST" action="${pageContext.request.contextPath}/SupplierEdit">
				<table class="table table-bordered">
					<tr>
						<td>Mã nhà cung cấp</td>
						<td><input type="text" name="supplierId" value="${supplier.sid}" readOnly/></td>
					</tr>
					<tr>
						<td>Tên nhà cung cấp</td>
						<td><input type="text" name="supplierName" value="${supplier.name}" required /></td>
					</tr>
					<tr>
						<td></td>
						<td>
							<input type="submit" value="Ghi lại" class="btn btn-success">
							<a href="SupplierList" class="btn btn-danger"> Quay lại</a>
						</td>
					</tr>
				</table>
			</form>
		</c:if>
	</section>
<jsp:include page="botLayout.jsp"></jsp:include>