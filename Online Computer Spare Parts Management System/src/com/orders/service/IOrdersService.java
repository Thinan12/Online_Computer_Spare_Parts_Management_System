package com.orders.service;

import java.util.ArrayList;
import java.util.logging.Logger;

import com.orders.model.Orders;


public interface IOrdersService {


	public static final Logger log = Logger.getLogger(IOrdersService.class.getName());


	public void addOrders(Orders orders);


	public Orders getOrdersByID(String ordersID);
	

	public ArrayList<Orders> getOrders();
	
	public Orders updateOrders(String ordersID, Orders orders);

	public void removeOrders(String ordersID);

}
