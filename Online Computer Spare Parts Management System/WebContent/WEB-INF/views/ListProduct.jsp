<%@page import="com.product.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.product.service.ProductServiceImpl"%>
<%@page import="com.product.service.IProductService"%>
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
<title>Products List</title>
</head>
<body>
	<h3>Products List</h3>
	<br>
	<br>
	  <div align="left">
		<table border="1" cellpadding="12">
		 <caption><h2>List of Products</h2></caption>
		 <a href="InsertProduct.jsp">Add Product</a>
		  <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Product Price</th>
                <th>Quantity</th>
                <th>Warranty Period</th>
                <th>Specification</th>
                <th>Status</th>
                <th>Select</th>
            </tr>
            <%
            IProductService iProductService = new ProductServiceImpl();
			ArrayList<Product> arrayList = iProductService.getProducts();
			
			for(Product product : arrayList){
			%>
			 <tr>
				<td> <%=product.getProductID() %> </td>
				<td> <%=product.getProductName() %> </td>
				<td> <%=product.getProductPrice() %> </td>
				<td> <%=product.getQuantity() %> </td>
				<td> <%=product.getWarrantyperiod() %> </td>
				<td> <%=product.getSpecification() %> </td>
				<td> <%=product.getStatus() %> </td>
				<td> 
				<form method="POST" action="GetProductServlet">
				<input type="hidden" name="productID" value="<%=product.getProductID()%>"/>
				 <input type="submit" value= "Select Product" class="select-button" /> 
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