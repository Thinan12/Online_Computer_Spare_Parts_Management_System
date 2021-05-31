<%@page import="com.employee.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
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


<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>
	<%
	Employee employee = (Employee) request.getAttribute("employee");
	%>
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
				<a class="navbar-brand" href="index.jsp"> <img
					src="images/6.png" width="150px" height="50px" alt="LOGO">
				</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li><a href="#" data-placement="bottom" data-toggle="tooltip"
					href="#" data-original-title="Stats"><i
						class="fa fa-bar-chart-o"></i> </a></li>
				<li class="dropdown"><a href="login.jsp"
					class="dropdown-toggle" data-toggle="dropdown">Logout <b
						class="fa fa-angle-down"></b></a>
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
			<!-- /.navbar-collapse -->
		</nav>

	</nav>

		<div id="page-wrapper">
			<div class="container-fluid">
				<!-- Page Heading -->
				<div class="row" id="main">
					<div class="col-sm-12 col-md-12 well" id="content">
						<h1>Employee Details</h1>

						<form method="POST" action="UpdateEmployeeServlet">

							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Employee ID</label>
								<div class="col-sm-10">
									<input type="text" class="form-control" name="employeeID"
										value="<%=employee.getEmployeeID()%>" disabled="disabled">
								</div>
							</div>

							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Employee Name</label>
								<div class="col-sm-10">
									<input value="<%=employee.getName()%>" type="text"
										class="form-control" name="employeeName">
								</div>
							</div>

							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Address</label>
								<div class="col-sm-10">
									<input value="<%=employee.getAddress()%>" type="text"
										class="form-control" name="address">
								</div>

							</div>

							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Employee Designation</label>
								<div class="col-sm-10">
									<input value="<%=employee.getDesignation()%>" type="text"
										class="form-control" name="designation">
								</div>

							</div>

							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Branch</label>
								<div class="col-sm-10">
									<input value="<%=employee.getBranch()%>" type="text"
										class="form-control" name="branch">
								</div>

							</div>

							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Mobile Number</label>
								<div class="col-sm-10">
									<input value="<%=employee.getMobileNumber()%>" type="tel"
										class="form-control" name="mobilenumber">
								</div>

							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Password</label>
								<div class="col-sm-10">
									<input value="<%=employee.getPassword()%>" type="text"
										class="form-control" name="Password">
								</div>

							</div>
							<div class="form-group row">
								<label class="col-sm-2 col-form-label">Gender</label>
								<div class="form-check">
									<div class="col-sm-10">
										<input class="form-check-input" type="radio" name="gender"
											value="male" checked tabindex="1"> <label
											class="form-check-label" for="exampleRadios1"> Male</label> <input
											class="form-check-input" type="radio" name="gender"
											value="female" tabindex="2"> <label
											class="form-check-label" for="exampleRadios2"> Female</label>
									</div>
								</div>

							</div>

							<button type="update" class="update-button"
								value="<%=employee.getEmployeeID()%>">Update</button>
						</form>
						<form method="POST" action="DeleteEmployeeServlet">
							<button type="submit" class="btn btn-primary" name="employeeID2"
								value="<%=employee.getEmployeeID()%>">Delete</button>
						</form>
						<br>
						<div></div>



					</div>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->
	</div>
	<!-- /#wrapper -->





	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>
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