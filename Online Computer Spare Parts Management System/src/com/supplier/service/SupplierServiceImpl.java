package com.supplier.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.supplier.model.Supplier;
import com.supplier.util.CommonUtil;
import com.supplier.util.DBConnectionUtil;

public class SupplierServiceImpl implements ISupplierService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(SupplierServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static {

		createSupplierTable();
	}

	private PreparedStatement preparedStatement;

	public static void createSupplierTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();

			//statement.executeUpdate("DROP TABLE IF EXISTS supplier");

			statement.executeUpdate(
					"CREATE TABLE supplier( supplierID varchar(255), supplierName varchar(255), CompanyName varchar(255), ContactNo varchar(255), Address varchar(255), Types  varchar(255), primary key (supplierID))");

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addSupplier(Supplier supplier) {

		String supplierID = CommonUtil.generateIDs(getSupplierIDs());

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(
					"insert into supplier (supplierID, supplierName, CompanyName, ContactNo, Address, Types) values (?, ?, ?, ?, ?, ?)");
			connection.setAutoCommit(false);

			supplier.setSupplierID(supplierID);
			preparedStatement.setString(1, supplier.getSupplierID());
			preparedStatement.setString(2, supplier.getSupplierName());
			preparedStatement.setString(3, supplier.getCompanyName());
			preparedStatement.setString(4, supplier.getContactNo());
			preparedStatement.setString(5, supplier.getAddress());
			preparedStatement.setString(6, supplier.getTypes());

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
	public Supplier getSupplierByID(String supplierID) {

		return actionOnSupplier(supplierID).get(0);
	}

	@Override
	public ArrayList<Supplier> getSuppliers() {

		return actionOnSupplier(null);
	}

	@Override
	public void removeSupplier(String supplierID) {

		if (supplierID != null && !supplierID.isEmpty()) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement("delete from supplier where supplier.supplierID = ?");
				preparedStatement.setString(1, supplierID);
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

	private ArrayList<Supplier> actionOnSupplier(String supplierID) {

		ArrayList<Supplier> supplierList = new ArrayList<Supplier>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (supplierID != null && !supplierID.isEmpty()) {

				preparedStatement = connection.prepareStatement("select * from supplier where supplier.supplierID = ?");
				preparedStatement.setString(1, supplierID);
			}

			else {
				preparedStatement = connection.prepareStatement("select * from supplier");
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Supplier supplier = new Supplier();
				supplier.setSupplierID(resultSet.getString(1));
				supplier.setSupplierName(resultSet.getString(2));
				supplier.setCompanyName(resultSet.getString(3));
				supplier.setContactNo(resultSet.getString(4));
				supplier.setAddress(resultSet.getString(5));
				supplier.setTypes(resultSet.getString(6));
				supplierList.add(supplier);
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
		return supplierList;
	}

	@Override
	public Supplier updateSuppliers(String supplierID, Supplier supplier) {
		System.out.println("Inside"+supplier.getSupplierName());
		System.out.println("impl 1 "+ supplierID);
		if (supplierID != null && !supplierID.isEmpty()) {
			System.out.println("impl 2 "+ supplierID);
			try {
				System.out.println("Inside2"+supplier.getSupplierName());
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(
						"update supplier as e set e.supplierName = ?, e.CompanyName = ?, e.ContactNo = ?, e.Address = ?, e.Types = ?  where e.supplierID = ?");
				preparedStatement.setString(1, supplier.getSupplierName());
				preparedStatement.setString(2, supplier.getCompanyName());
				preparedStatement.setString(3, supplier.getContactNo());
				preparedStatement.setString(4, supplier.getAddress());
				preparedStatement.setString(5, supplier.getTypes());
				preparedStatement.setString(6, supplier.getSupplierID());
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
		// Get the updated supplier
		return getSupplierByID(supplierID);
	}

	private ArrayList<String> getSupplierIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement("select e.supplierID from supplier as e");
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
