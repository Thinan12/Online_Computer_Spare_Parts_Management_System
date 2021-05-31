package com.product.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.employee.service.EmployeeServiceImpl;
import com.orders.service.OrdersServiceImpl;
import com.product.service.IProductService;
import com.product.service.ProductServiceImpl;
import com.supplier.service.SupplierServiceImpl;

public class MyServletContextListener implements ServletContextListener {

	  @Override
	  public void contextDestroyed(ServletContextEvent arg0) {
	    //Notification that the servlet context is about to be shut down.   
	  }

	  @Override
	  public void contextInitialized(ServletContextEvent arg0) {
	    // do all the tasks that you need to perform just after the server starts

	    //Notification that the web application initialization process is starting
		  ProductServiceImpl iProductService = new ProductServiceImpl();
		  ProductServiceImpl.createProductTable();
		  
		  EmployeeServiceImpl iEmployeeServiceImpl = new EmployeeServiceImpl();
		  EmployeeServiceImpl.createEmployeeTable();
		  
		  SupplierServiceImpl iSupplierService = new SupplierServiceImpl();
		  SupplierServiceImpl.createSupplierTable();
		  
		  OrdersServiceImpl iOrdersService = new OrdersServiceImpl();
		  OrdersServiceImpl.createOrdersTable();
	  }

	}
