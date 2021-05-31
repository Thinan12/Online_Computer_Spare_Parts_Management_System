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


public class GetOrdersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;


	public GetOrdersServlet() {
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
		Orders orders = iOrdersService.getOrdersByID(ordersID);

		request.setAttribute("orders", orders);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/GetOrders.jsp");
		dispatcher.forward(request, response);
	}

}
