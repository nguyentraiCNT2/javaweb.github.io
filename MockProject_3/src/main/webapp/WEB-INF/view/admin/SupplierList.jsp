<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<jsp:include page="topLayout.jsp"></jsp:include>
	<section class="container">
	
		<h3>Supplier List</h3>
		<p style="color: red;">${errorString}</p>
		<table class="table table-bordered">
			<thead style="background: #f1f1f1">
				<tr>
					<th>Mã nhà cung cấp</th>
					<th>Tên nhà cung cấp</th>
					<th>Tác vụ</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${supplierList}" var="supplier">
					<tr>
						<td>${supplier.sid}</td>
						<td>${supplier.name}</td>
						<td>
							<a class="btn btn-success" href="SupplierEdit?sid=${supplier.sid}">Edit</a>
							<a class="btn btn-danger" href="SupplierDelete?sid=${supplier.sid}">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="SupplierCreate">Create Supplier</a>
	</section>
<jsp:include page="botLayout.jsp"></jsp:include>