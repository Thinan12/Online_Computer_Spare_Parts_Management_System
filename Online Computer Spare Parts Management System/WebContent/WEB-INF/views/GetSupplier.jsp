<%@page import="com.supplier.model.Supplier"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "ComputerSparePart.css" />
<meta charset="UTF-8">
<title>Supplier Details</title>
</head>
<body>


	<h2 class="h2">Modify Supplier Details</h2>

	<br>
	<br>
	<%
		Supplier supplier = (Supplier) request.getAttribute("supplier");
	%>

	<form method="POST" action="UpdateSupplierServlet">
		<table>
			<tr>
				<td>Supplier ID</td>
				<td><input type="text" name="supplierID" disabled="disabled"
					value="<%=supplier.getSupplierID()%>" /></td>
			</tr>
			<tr>
				<td>Supplier Name</td>
				<td><input type="text" name="supplierName"
					value="<%=supplier.getSupplierName()%>" /></td>
			</tr>
			<tr>
				<td>Company Name</td>
				<td><input type="text" name="companyname"
					value="<%=supplier.getCompanyName()%>" /></td>
			</tr>
			<tr>
				<td>Contact No</td>
				<td><input type="text" name="contactno"
					value="<%=supplier.getContactNo()%>" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value="<%=supplier.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Supplier Type</td>
				<td><input type="text" name="type"
					value="<%=supplier.getTypes()%>" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="hidden" name="supplierID"
					value="<%=supplier.getSupplierID()%>" /> <input type="submit"
					value="Update Supplier" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteSupplierServlet">
					<input type="hidden" name="supplierID"
						value="<%=supplier.getSupplierID()%>" /> <input type="submit"
						value="Delete Supplier" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>


</body>
</html>