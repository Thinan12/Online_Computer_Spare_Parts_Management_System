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

public class AddOrdersServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public AddOrdersServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Orders orders = new Orders();

		orders.setCustomername(request.getParameter("customername"));
		orders.setProductid(request.getParameter("productid"));
		orders.setQuantity(request.getParameter("quantity"));
		orders.setPrice(request.getParameter("price"));
		orders.setTotal(request.getParameter("total"));
		orders.setDate(request.getParameter("date"));

		IOrdersService iOrdersService = new OrdersServiceImpl();
		iOrdersService.addOrders(orders);

		request.setAttribute("orders", orders);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListOrders.jsp");
		dispatcher.forward(request, response);
	}

}
