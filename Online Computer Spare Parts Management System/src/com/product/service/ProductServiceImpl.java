package com.product.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.product.util.CommonUtil;
import com.product.util.DBConnectionUtil;
import com.product.model.Product;

public class ProductServiceImpl implements IProductService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(ProductServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static {

		createProductTable();
	}

	private PreparedStatement preparedStatement;

	public static void createProductTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();

			//statement.executeUpdate("DROP TABLE IF EXISTS employee");

			statement.executeUpdate(
					"CREATE TABLE product( productID varchar(255), productName varchar(255), productPrice varchar(255), quantity varchar(255), warrantyperiod varchar(255), specification  varchar(255), status varchar(255), primary key (productID))");

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addProduct(Product product) {

		String productID = CommonUtil.generateIDs(getProductIDs());

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(
					"insert into product (productID, productName, productPrice, quantity, warrantyperiod, specification, status) values (?, ?, ?, ?, ?, ?, ?)");
			connection.setAutoCommit(false);

			product.setProductID(productID);
			preparedStatement.setString(1, product.getProductID());
			preparedStatement.setString(2, product.getProductName());
			preparedStatement.setString(3, product.getProductPrice());
			preparedStatement.setString(4, product.getQuantity());
			preparedStatement.setString(5, product.getWarrantyperiod());
			preparedStatement.setString(6, product.getSpecification());
			preparedStatement.setString(7, product.getStatus());

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
	public Product getProductByID(String productID) {

		return actionOnProduct(productID).get(0);
	}

	@Override
	public ArrayList<Product> getProducts() {

		return actionOnProduct(null);
	}

	@Override
	public void removeProduct(String productID) {

		if (productID != null && !productID.isEmpty()) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement("delete from product where product.productID = ?");
				preparedStatement.setString(1, productID);
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

	private ArrayList<Product> actionOnProduct(String productID) {

		ArrayList<Product> productList = new ArrayList<Product>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (productID != null && !productID.isEmpty()) {

				preparedStatement = connection.prepareStatement("select * from product where product.productID = ?");
				preparedStatement.setString(1, productID);
			}

			else {
				preparedStatement = connection.prepareStatement("select * from product");
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Product product = new Product();
				product.setProductID(resultSet.getString(1));
				product.setProductName(resultSet.getString(2));
				product.setProductPrice(resultSet.getString(3));
				product.setQuantity(resultSet.getString(4));
				product.setWarrantyperiod(resultSet.getString(5));
				product.setSpecification(resultSet.getString(6));
				product.setStatus(resultSet.getString(7));
				productList.add(product);
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
		return productList;
	}

	@Override
	public Product updateProduct(String productID, Product product) {

		if (productID != null && !productID.isEmpty()) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(
						"update product as e set e.productName = ?, e.productPrice = ?, e.quantity = ?, e.warrantyperiod = ?, e.specification = ?, e.status = ?  where e.productID = ?");
				preparedStatement.setString(1, product.getProductName());
				preparedStatement.setString(2, product.getProductPrice());
				preparedStatement.setString(3, product.getQuantity());
				preparedStatement.setString(4, product.getWarrantyperiod());
				preparedStatement.setString(5, product.getSpecification());
				preparedStatement.setString(6, product.getStatus());
				preparedStatement.setString(7, product.getProductID());
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
		// Get the updated product
		return getProductByID(productID);
	}

	private ArrayList<String> getProductIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement("select e.productID from product as e");
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
