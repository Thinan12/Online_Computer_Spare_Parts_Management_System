package com.employee.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.employee.model.Employee;
import com.employee.util.CommonUtil;
import com.employee.util.DBConnectionUtil;

public class EmployeeServiceImpl implements IEmployeeService {

	/** Initialize logger */
	public static final Logger log = Logger.getLogger(EmployeeServiceImpl.class.getName());

	private static Connection connection;

	private static Statement statement;

	static {

		createEmployeeTable();
	}

	private PreparedStatement preparedStatement;

	public static void createEmployeeTable() {

		try {
			connection = DBConnectionUtil.getDBConnection();
			statement = connection.createStatement();

			//statement.executeUpdate("DROP TABLE IF EXISTS employee");

			statement.executeUpdate(
					"CREATE TABLE employee( employeeID varchar(255), employeeName varchar(255), designation varchar(255), branch varchar(255), mobilenumber varchar(255), address  varchar(255), password varchar(255), gender varchar(225) DEFAULT 'Male', primary key (employeeID))");

		} catch (SQLException | ClassNotFoundException e) {
			log.log(Level.SEVERE, e.getMessage());
		}
	}

	@Override
	public void addEmployee(Employee employee) {

		String employeeID = CommonUtil.generateIDs(getEmployeeIDs());

		try {
			connection = DBConnectionUtil.getDBConnection();

			preparedStatement = connection.prepareStatement(
					"insert into employee (employeeID, employeeName, designation, branch, mobilenumber, address, password, gender) values (?, ?, ?, ?, ?, ?, ?, ?)");
			connection.setAutoCommit(false);

			employee.setEmployeeID(employeeID);
			preparedStatement.setString(1, employee.getEmployeeID());
			preparedStatement.setString(2, employee.getName());
			preparedStatement.setString(3, employee.getDesignation());
			preparedStatement.setString(4, employee.getBranch());
			preparedStatement.setString(5, employee.getMobileNumber());
			preparedStatement.setString(6, employee.getAddress());
			preparedStatement.setString(7, employee.getPassword());
			preparedStatement.setString(8, employee.getGender());

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
	public Employee getEmployeeByID(String employeeID) {

		return actionOnEmployee(employeeID).get(0);
	}

	@Override
	public ArrayList<Employee> getEmployees() {

		return actionOnEmployee(null);
	}

	@Override
	public void removeEmployee(String employeeID) {

		if (employeeID != null && !employeeID.isEmpty()) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement("delete from employee where employee.employeeID = ?");
				preparedStatement.setString(1, employeeID);
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

	private ArrayList<Employee> actionOnEmployee(String employeeID) {

		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		try {
			connection = DBConnectionUtil.getDBConnection();

			if (employeeID != null && !employeeID.isEmpty()) {

				preparedStatement = connection.prepareStatement("select * from employee where employee.employeeID = ?");
				preparedStatement.setString(1, employeeID);
			}

			else {
				preparedStatement = connection.prepareStatement("select * from employee");
			}
			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployeeID(resultSet.getString(1));
				employee.setName(resultSet.getString(2));
				employee.setAddress(resultSet.getString(3));
				employee.setBranch(resultSet.getString(4));
				employee.setMobileNumber(resultSet.getString(5));
				employee.setDesignation(resultSet.getString(6));
				employee.setPassword(resultSet.getString(7));
				employee.setGender(resultSet.getString(8));
				employeeList.add(employee);
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
		return employeeList;
	}

	@Override
	public Employee updateEmployee(String employeeID, Employee employee) {

		if (employeeID != null && !employeeID.isEmpty()) {

			try {
				connection = DBConnectionUtil.getDBConnection();
				preparedStatement = connection.prepareStatement(
						"update employee as e set e.employeeName = ?, e.designation = ?, e.branch = ?, e.mobilenumber = ?, e.address = ?, e.password = ?, e.gender = ?  where e.employeeID = ?");
				preparedStatement.setString(1, employee.getName());
				preparedStatement.setString(2, employee.getDesignation());
				preparedStatement.setString(3, employee.getBranch());
				preparedStatement.setString(4, employee.getMobileNumber());
				preparedStatement.setString(5, employee.getAddress());
				preparedStatement.setString(6, employee.getPassword());
				preparedStatement.setString(7, employee.getGender());
				preparedStatement.setString(8, employee.getEmployeeID());
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
		// Get the updated employee
		return getEmployeeByID(employeeID);
	}

	private ArrayList<String> getEmployeeIDs() {

		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			connection = DBConnectionUtil.getDBConnection();
			preparedStatement = connection.prepareStatement("select e.employeeID from employee as e");
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
