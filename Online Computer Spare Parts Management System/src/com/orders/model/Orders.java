package com.orders.model;

public class Orders {

	private String ordersID;
	
	private String customername;

	private String productid;

	private String quantity;

	private String price;

	private String total;
	
	private String date;

	public String getOrdersID() {
		return ordersID;
	}

	public void setOrdersID(String ordersID) {
		this.ordersID = ordersID;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername;
	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @param ordersID
	 * @param customername
	 * @param productid
	 * @param quantity
	 * @param price
	 * @param total
	 * @param date
	 */
	public Orders(String ordersID, String customername, String productid, String quantity, String price, String total,
			String date) {
		super();
		ordersID = ordersID;
		this.customername = customername;
		this.productid = productid;
		this.quantity = quantity;
		this.price = price;
		this.total = total;
		this.date = date;
	}

	/**
	 * 
	 */
	public Orders() {
		super();
	}

	@Override
	public String toString() {
		return "Orders [OrdersID=" + ordersID + ", customername=" + customername + ", productid=" + productid
				+ ", quantity=" + quantity + ", price=" + price + ", total=" + total + ", date=" + date + "]";
	}
	



	
}
