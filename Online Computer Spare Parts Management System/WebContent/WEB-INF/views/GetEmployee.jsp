<%@page import="com.employee.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel = "stylesheet"
   type = "text/css"
   href = "ComputerSparePart.css" />
<meta charset="UTF-8">
<title>Employee Details</title>
</head>
<body>

	<jsp:include page="/WEB-INF/views/header.jsp"></jsp:include>

	<h2 class="h2">Employee Details</h2>

	<br>
	<br>
	<%
		Employee employee = (Employee) request.getAttribute("employee");
	%>

	<form method="POST" action="UpdateEmployeeServlet">
		<table>
			<tr>
				<td>Employee ID</td>
				<td><input type="text" name="employeeID" disabled="disabled"
					value="<%=employee.getEmployeeID()%>" /></td>
			</tr>
			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="employeeName"
					value="<%=employee.getName()%>" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address"
					value="<%=employee.getAddress()%>" /></td>
			</tr>
			<tr>
				<td>Employee Designation</td>
				<td><input type="text" name="designation"
					value="<%=employee.getDesignation()%>" /></td>
			</tr>
			<tr>
				<td>Branch</td>
				<td><input type="text" name="branch"
					value="<%=employee.getBranch()%>" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobilenumber"
					value="<%=employee.getMobileNumber()%>" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="Password"
					value="<%=employee.getPassword()%>" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><input type="radio" name="gender" value="male"
					checked="checked" tabindex="1" /> Male</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="radio" name="gender" value="female"
					tabindex="2" /> Female</td>
			</tr>
			<tr>
				<td colspan="2"><input type="hidden" name="employeeID"
					value="<%=employee.getEmployeeID()%>" /> <input type="submit"
					value="Update Employee" class="update-button"/></td>
			</tr>
		</table>
	</form>

	<table>
		<tr>
			<td colspan="2">
				<form method="POST" action="DeleteEmployeeServlet">
					<input type="hidden" name="employeeID"
						value="<%=employee.getEmployeeID()%>" /> <input type="submit"
						value="Delete Employee" class="delete-button"/>
				</form>
			</td>
		</tr>
	</table>

	<jsp:include page="/WEB-INF/views/footer.jsp"></jsp:include>

</body>
</html>