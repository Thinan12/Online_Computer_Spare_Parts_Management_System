package com.employee.model;

public class Employee {

	private String EmployeeID;
	
	private String Name;

	private String Designation;

	private String Branch;

	private String MobileNumber;

	private String Address;
	
	private String Password;
	
	private String Gender;

	public String getEmployeeID() {
		return EmployeeID;
	}

	public void setEmployeeID(String employeeID) {
		EmployeeID = employeeID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}

	public String getBranch() {
		return Branch;
	}

	public void setBranch(String branch) {
		Branch = branch;
	}

	public String getMobileNumber() {
		return MobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		MobileNumber = mobileNumber;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	@Override
	public String toString() {
		return "Employee [EmployeeID=" + EmployeeID + ", Name=" + Name + ", Designation=" + Designation + ", Branch="
				+ Branch + ", MobileNumber=" + MobileNumber + ", Address=" + Address + ", Password="
				+ Password + ", Gender=" + Gender + "]";
	}


	
}
