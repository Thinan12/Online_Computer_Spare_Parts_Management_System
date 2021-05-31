<%@page import="com.orders.model.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.orders.service.OrdersServiceImpl"%>
<%@page import="com.orders.service.IOrdersService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "ComputerSparePart.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Orders List</title>
</head>
<body>
	<h3>Orders List</h3>
	<br>
	<br>
	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of Orders</h2></caption>
		 <a href="InsertOrders.jsp">Add Orders</a>
		  <tr>
                <th>Orders ID</th>
                <th>Customer Name</th>
                <th>Product ID</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th>Total Price</th>
                <th>Order Date</th>
                <th>Select</th>
            </tr>
            <%
            IOrdersService iOrdersService = new OrdersServiceImpl();
			ArrayList<Orders> arrayList = iOrdersService.getOrders();
		
			for(Orders orders : arrayList){
			%>
			 <tr>
				<td> <%=orders.getOrdersID() %> </td>
				<td> <%=orders.getCustomername() %> </td>
				<td> <%=orders.getProductid() %> </td>
				<td> <%=orders.getQuantity() %> </td>
				<td> <%=orders.getPrice() %> </td>
				<td> <%=orders.getTotal() %> </td>
				<td> <%=orders.getDate() %> </td>
				<td> 
				<form method="POST" action="GetOrdersServlet">
				<input type="hidden" name="ordersID" value="<%=orders.getOrdersID()%>"/>
				 <input type="submit" value= "Select Orders" class="select-button" /> 
				 </form>
				 </td>	
				</tr>			
			<%	
			   }
            %>     
		</table>
		</div>
		
</body>
</html>