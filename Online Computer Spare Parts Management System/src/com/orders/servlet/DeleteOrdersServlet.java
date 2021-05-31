package com.orders.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.orders.model.Orders;
import com.orders.service.OrdersServiceImpl;
import com.orders.service.IOrdersService;


public class DeleteOrdersServlet extends HttpServlet {


	private static final long serialVersionUID = 1871871796669342804L;


	public DeleteOrdersServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String ordersID = request.getParameter("ordersID");			
		
		IOrdersService iOrdersService = new OrdersServiceImpl();
		iOrdersService.removeOrders(ordersID);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListOrders.jsp");
		dispatcher.forward(request, response);
	}

}
