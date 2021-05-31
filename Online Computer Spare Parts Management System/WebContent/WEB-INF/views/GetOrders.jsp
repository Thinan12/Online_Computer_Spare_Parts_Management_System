<%@page import="com.orders.model.Orders"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "ComputerSparePart.css" />
<meta charset="UTF-8">
<title>Orders Details</title>
</head>
<body>


	<h2 class="h2">Modify Orders Details</h2>

	<br>
	<br>
	<%
		Orders orders = (Orders) request.getAttribute("orders");
	%>

	<form method="POST" action="UpdateOrdersServlet">
		<table>
			<tr>
				<td>Orders ID</td>
				<td><input type="text" name="ordersID" disabled="disabled"
					value="<%=orders.getOrdersID()%>" /></td>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td><input type="text" name="customername" 
					value="<%=orders.getCustomername()%>" /></td>
			</tr>
			<tr>
				<td>Product ID</td>
				<td><input type="text" name="productid"
					value="<%=orders.getProductid()%>" /></td>
			</tr>
			<tr>
				<td>No. of units</td>
				<td><input type="text" name="quantity"
					value="<%=orders.getQuantity()%>" /></td>
			</tr>
			<tr>
				<td>Unit Price</td>
				<td><input type="text" name="price"
					value="<%=orders.getPrice()%>" /></td>
			</tr>
			<tr>
				<td>Total Price</td>
				<td><input type="text" name="total"
					value="<%=orders.getTotal()%>" /></td>
			</tr>
			<tr>
				<td>Order Date</td>
				<td><input type="date" name="date"
					value="<%=orders.getDate()%>" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="hidden" name="ordersID"
					value="<%=orders.getOrdersID()%>" /> <input type="submit"
					value="Update Orders" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteOrdersServlet">
					<input type="hidden" name="ordersID"
						value="<%=orders.getOrdersID()%>" /> <input type="submit"
						value="Delete Orders" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>


</body>
</html>