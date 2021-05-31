<%@page import="com.product.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.product.service.ProductServiceImpl"%>
<%@page import="com.product.service.IProductService"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="computerspare.css" />

<style>
@CHARSET "ISO-8859-1";

@import
	url('https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css')
	;

@media ( min-width :768px) {
	body {
		margin-top: 50px;
	}
	/
	html, body, #wrapper, #page-wrapper {
		height: 100%;
		overflow: hidden;
	}
	/
}

#wrapper {
	padding-left: 0;
}

#page-wrapper {
	width: 100%;
	padding: 0;
	background-color: #fff;
	background-image: url(images/13.jpg)
}

@media ( min-width :768px) {
	#wrapper {
		padding-left: 225px;
	}
	#page-wrapper {
		padding: 22px 10px;
	}
}

/* Top Navigation */
.top-nav {
	padding: 0 15px;
}

.top-nav>li {
	display: inline-block;
	float: left;
}

.top-nav>li>a {
	padding-top: 20px;
	padding-bottom: 20px;
	line-height: 20px;
	color: #fff;
}

.top-nav>li>a:hover, .top-nav>li>a:focus, .top-nav>.open>a, .top-nav>.open>a:hover,
	.top-nav>.open>a:focus {
	color: #fff;
	background-color: #1a242f;
}

.top-nav>.open>.dropdown-menu {
	float: left;
	position: absolute;
	margin-top: 0; /
	border: 1px solid rgba(0, 0, 0, .15); /
	border-top-left-radius: 0;
	border-top-right-radius: 0;
	background-color: #fff;
	-webkit-box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
	box-shadow: 0 6px 12px rgba(0, 0, 0, .175);
}

.top-nav>.open>.dropdown-menu>li>a {
	white-space: normal;
}

/* Side Navigation */
@media ( min-width :768px) {
	.side-nav {
		position: fixed;
		top: 60px;
		left: 225px;
		width: 225px;
		margin-left: -225px;
		border: none;
		border-radius: 0;
		border-top: 1px rgba(0, 0, 0, .5) solid;
		overflow-y: auto;
		background-color: #222; /
		background-color: #5A6B7D; /
		bottom: 0;
		overflow-x: hidden;
		padding-bottom: 40px;
	}
	.side-nav>li>a {
		width: 225px;
		border-bottom: 1px rgba(0, 0, 0, .3) solid;
	}
	.side-nav li a:hover, .side-nav li a:focus {
		outline: none;
		background-color: #1a242f !important;
	}
}

.side-nav>li>ul {
	padding: 0;
	border-bottom: 1px rgba(0, 0, 0, .3) solid;
}

.side-nav>li>ul>li>a {
	display: block;
	padding: 10px 15px 10px 38px;
	text-decoration: none; /
	color: #999; /
	color: #fff;
}

.side-nav>li>ul>li>a:hover {
	color: #fff;
}

.navbar .nav>li>a>.label {
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
	position: absolute;
	top: 14px;
	right: 6px;
	font-size: 10px;
	font-weight: normal;
	min-width: 15px;
	min-height: 15px;
	line-height: 1.0em;
	text-align: center;
	padding: 2px;
}

.navbar .nav>li>a:hover>.label {
	top: 10px;
}

.navbar-brand {
	padding: 5px 15px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Products List</title>
</head>
<body>

	div id="throbber" style="display: none; min-height: 120px;">
	</div>
	<div id="noty-holder"></div>
	<div id="wrapper">
		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.jsp"> <img src="images/6.png"
				width="150px" height="50px" alt="LOGO">
			</a>
		</div>
		<!-- Top Menu Items -->
		<ul class="nav navbar-right top-nav">
			<li><a href="#" data-placement="bottom" data-toggle="tooltip"
				href="#" data-original-title="Stats"><i
					class="fa fa-bar-chart-o"></i> </a></li>
			<li class="dropdown"><a href="login.jsp" class="dropdown-toggle"
				data-toggle="dropdown">Logout <b class="fa fa-angle-down"></b></a>
		</ul>
		<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav side-nav">

				<li><a href="InsertEmployee.jsp"><i
						class="fa fa-fw fa-user-plus"></i>Add Employee</a></li>
				<li><a href="ListEmployees.jsp"><i
						class="fa fa-fw fa-paper-plane-o"></i>List Employee</a></li>
				<li><a href="InsertProduct.jsp"><i
						class="fa fa-fw fa-user-plus"></i>Add Product</a></li>
				<li><a href="ListProduct.jsp"><i
						class="fa fa-fw fa-paper-plane-o"></i>List Product</a></li>
				<li><a href="InsertSupplier.jsp"><i
						class="fa fa-fw fa-user-plus"></i>Add Suppliers</a></li>
				<li><a href="ListSupplier.jsp"><i
						class="fa fa-fw fa-paper-plane-o"></i>List Suppliers</a></li>
				<li><a href="InsertOrders.jsp"><i
						class="fa fa-fw fa-user-plus"></i>Add Orders</a></li>
				<li><a href="ListOrders.jsp"><i
						class="fa fa-fw fa-paper-plane-o"></i>List Orders</a></li>
			</ul>
		</div>
		<!-- /.navbar-collapse --> </nav>


		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row" id="main">
					<div class="col-sm-12 col-md-12 well" id="content">
						<h1>Products List</h1>

						<table class="table table-striped">
							<thead>
								<tr>
									<th scope="col">Product ID</th>
									<th scope="col">Product Name</th>
									<th scope="col">Product Price</th>
									<th scope="col">Quantity</th>
									<th scope="col">Warranty Period</th>
									<th scope="col">Specification</th>
									<th scope="col">Status</th>
									<th scope="col">Select</th>


								</tr>
							</thead>

							<%
							IProductService iProductService = new ProductServiceImpl();
							ArrayList<Product> arrayList = iProductService.getProducts();

							for (Product product : arrayList) {
							%>
							<tbody>
								<tr>

									<td><%=product.getProductID()%></td>
									<td><%=product.getProductName()%></td>
									<td><%=product.getProductPrice()%></td>
									<td><%=product.getQuantity()%></td>
									<td><%=product.getWarrantyperiod()%></td>
									<td><%=product.getSpecification()%></td>
									<td><%=product.getStatus()%></td>

									<td>
										<div>
											<form method="POST" action="GetProductServlet">
												<input type="hidden" name="productID"
													value="<%=product.getProductID()%>" />
												<button type="submit" name="productID"
													class="btn btn-primary" value="Select Orders">Select
													Orders</button>
											</form>
										</div>
										<div>
											<form method="POST" action="DeleteProductServlet">
												<input type="hidden" name="productID"
													value="<%=product.getProductID()%>" />
												<button type="submit" class="btn btn-primary"
													value="<%=product.getProductID()%>">Delete</button>
											</form>
										</div>
									</td>

								</tr>
							</tbody>

							<%
							}
							%>
						</table>

					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->

	<script>
		$(function() {
			$('[data-toggle="tooltip"]').tooltip();
			$(".side-nav .collapse").on(
					"hide.bs.collapse",
					function() {
						$(this).prev().find(".fa").eq(1).removeClass(
								"fa-angle-right").addClass("fa-angle-down");
					});
			$('.side-nav .collapse').on(
					"show.bs.collapse",
					function() {
						$(this).prev().find(".fa").eq(1).removeClass(
								"fa-angle-down").addClass("fa-angle-right");
					});
		})
	</script>




</body>
</html>