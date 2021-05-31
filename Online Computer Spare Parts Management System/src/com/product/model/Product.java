package com.product.model;

public class Product {

	private String productID;
	private String productName;
	private String productPrice;
	private String quantity;
	private String warrantyperiod;
	private String specification;
	private String status;
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getWarrantyperiod() {
		return warrantyperiod;
	}
	public void setWarrantyperiod(String warrantyperiod) {
		this.warrantyperiod = warrantyperiod;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @param productID
	 * @param productName
	 * @param productPrice
	 * @param quantity
	 * @param warrantyperiod
	 * @param specification
	 * @param status
	 */
	public Product(String productID, String productName, String productPrice, String quantity, String warrantyperiod,
			String specification, String status) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productPrice = productPrice;
		this.quantity = quantity;
		this.warrantyperiod = warrantyperiod;
		this.specification = specification;
		this.status = status;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [productID=" + productID + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", quantity=" + quantity + ", warrantyperiod=" + warrantyperiod + ", specification=" + specification
				+ ", status=" + status + "]";
	}
	
	
	
}
