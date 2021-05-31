<%@page import="com.product.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "ComputerSparePart.css" />
<meta charset="UTF-8">
<title>Product Details</title>
</head>
<body>


	<h2 class="h2">Modify Product Details</h2>

	<br>
	<br>
	<%
		Product product = (Product) request.getAttribute("product");
	%>

	<form method="POST" action="UpdateProductServlet">
		<table>
			<tr>
				<td>Product ID</td>
				<td><input type="text" name="productID" disabled="disabled"
					value="<%=product.getProductID()%>"  disabled="disabled"/></td>
			</tr>
			<tr>
				<td>Product Name</td>
				<td><input type="text" name="productName"
					value="<%=product.getProductName()%>" /></td>
			</tr>
			<tr>
				<td>Product Price</td>
				<td><input type="text" name="productPrice"
					value="<%=product.getProductPrice()%>" /></td>
			</tr>
			<tr>
				<td>Product Quantity</td>
				<td><input type="text" name="quantity"
					value="<%=product.getQuantity()%>" /></td>
			</tr>
			<tr>
				<td>Warranty Period</td>
				<td><input type="text" name="warrantyperiod"
					value="<%=product.getWarrantyperiod()%>" /></td>
			</tr>
			<tr>
				<td>Specialization</td>
				<td><input type="text" name="specification"
					value="<%=product.getSpecification()%>" /></td>
			</tr>
			<tr>
				<td>Status</td>
				<td><input type="text" name="status"
					value="<%=product.getStatus()%>" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="hidden" name="productID"
					value="<%=product.getProductID()%>" /> <input type="submit"
					value="Update Product" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteProductServlet">
					<input type="hidden" name="productID"
						value="<%=product.getProductID()%>" /> <input type="submit"
						value="Delete Product" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>


</body>
</html>