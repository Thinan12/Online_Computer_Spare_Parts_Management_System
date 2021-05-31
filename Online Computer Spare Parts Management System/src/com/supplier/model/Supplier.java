package com.supplier.model;

public class Supplier {

	private String SupplierID;
	
	private String SupplierName;

	private String CompanyName;

	private String ContactNo;

	private String Address;

	private String Types;

	public String getSupplierID() {
		return SupplierID;
	}

	public void setSupplierID(String supplierID) {
		SupplierID = supplierID;
	}

	public String getSupplierName() {
		return SupplierName;
	}

	public void setSupplierName(String supplierName) {
		SupplierName = supplierName;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public String getContactNo() {
		return ContactNo;
	}

	public void setContactNo(String contactNo) {
		ContactNo = contactNo;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getTypes() {
		return Types;
	}

	public void setTypes(String types) {
		Types = types;
	}

	/**
	 * 
	 */
	public Supplier() {
		super();
	}

	@Override
	public String toString() {
		return "Supplier [SupplierID=" + SupplierID + ", SupplierName=" + SupplierName + ", CompanyName=" + CompanyName
				+ ", ContactNo=" + ContactNo + ", Address=" + Address + ", Types=" + Types + "]";
	}
	


	
}
