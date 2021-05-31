package com.orders.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.orders.model.Orders;
import com.orders.util.CommonUtil;
import com.orders.util.DBConnectionUtil;

public class OrdersServiceImpl implements IOrdersService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(OrdersServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static {

		createOrdersTable();
	}

	private PreparedStatement preparedStatement;

	public static void createOrdersTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();

			//statement.executeUpdate("DROP TABLE IF EXISTS orders");

			statement.executeUpdate(
					"CREATE TABLE orders( ordersID varchar(255), customername varchar(255), productid varchar(255), quantity varchar(255), price varchar(255), total  varchar(255), date varchar(255), primary key (ordersID))");

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addOrders(Orders orders) {

		String ordersID = CommonUtil.generateIDs(getOrdersIDs());
		System.out.println(ordersID);

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(
					"insert into orders (ordersID, customername, productid, quantity, price, total, date) values (?, ?, ?, ?, ?, ?, ?)");
			connection.setAutoCommit(false);

			orders.setOrdersID(ordersID);
			preparedStatement.setString(1, orders.getOrdersID());
			preparedStatement.setString(2, orders.getCustomername());
			preparedStatement.setString(3, orders.getProductid());
			preparedStatement.setString(4, orders.getQuantity());
			preparedStatement.setString(5, orders.getPrice());
			preparedStatement.setString(6, orders.getTotal());
			preparedStatement.setString(7, orders.getDate());

			preparedStatement.execute();
			connection.commit();

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
	}

	@Override
	public Orders getOrdersByID(String ordersID) {

		return actionOnOrders(ordersID).get(0);
	}

	@Override
	public ArrayList<Orders> getOrders() {

		return actionOnOrders(null);
	}

	@Override
	public void removeOrders(String ordersID) {

		if (ordersID != null && !ordersID.isEmpty()) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement("delete from orders where orders.ordersID = ?");
				preparedStatement.setString(1, ordersID);
				preparedStatement.executeUpdate();
			} catch (SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {

				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
	}

	private ArrayList<Orders> actionOnOrders(String ordersID) {

		ArrayList<Orders> ordersList = new ArrayList<Orders>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (ordersID != null && !ordersID.isEmpty()) {

				preparedStatement = connection.prepareStatement("select * from orders where orders.ordersID = ?");
				preparedStatement.setString(1, ordersID);
			}

			else {
				preparedStatement = connection.prepareStatement("select * from orders");
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Orders orders = new Orders();
				orders.setOrdersID(resultSet.getString(1));
				orders.setCustomername(resultSet.getString(2));
				orders.setProductid(resultSet.getString(3));
				orders.setQuantity(resultSet.getString(4));
				orders.setPrice(resultSet.getString(5));
				orders.setTotal(resultSet.getString(6));
				orders.setDate(resultSet.getString(7));
				ordersList.add(orders);
			}

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of transaction
			 */
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return ordersList;
	}

	@Override
	public Orders updateOrders(String ordersID, Orders orders) {

		if (ordersID != null && !ordersID.isEmpty()) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(
						"update orders as e set e.customername = ?, e.productid = ?, e.quantity = ?, e.price = ?, e.total = ?, e.date = ?  where e.ordersID = ?");
				preparedStatement.setString(1, orders.getCustomername());
				preparedStatement.setString(2, orders.getProductid());
				preparedStatement.setString(3, orders.getQuantity());
				preparedStatement.setString(4, orders.getPrice());
				preparedStatement.setString(5, orders.getTotal());
				preparedStatement.setString(6, orders.getDate());
				preparedStatement.setString(7, orders.getOrdersID());
				preparedStatement.executeUpdate();

			} catch (SQLException | ClassNotFoundException e) {
				log.log(Level.SEVERE, e.getMessage());
			} finally {
				/*
				 * Close prepared statement and database connectivity at the end of transaction
				 */
				try {
					if (preparedStatement != null) {
						preparedStatement.close();
					}
					if (connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
		}
		// Get the updated orders
		return getOrdersByID(ordersID);
	}

	private ArrayList<String> getOrdersIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement("select e.ordersID from orders as e");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				arrayList.add(resultSet.getString(1));
			}
		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		} finally {

			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return arrayList;
	}
}
