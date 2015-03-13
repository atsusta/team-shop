package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBHelper;
import vo.Customer;

public class CustomerDAO {
	private static CustomerDAO customerDaoInstance;
	
	private CustomerDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static CustomerDAO getInstance() {
		if (customerDaoInstance == null) {
			customerDaoInstance = new CustomerDAO();
		}
		
		return customerDaoInstance;
	}
	
	public int insertCustomer(Customer customer) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int sqlResult = 0;
		
		try {
			connection = DBHelper.getConnection(1);
			String sql = "insert into customer values (?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customer.getId());
			preparedStatement.setString(2, customer.getPassword());
			preparedStatement.setString(3, customer.getName());
			preparedStatement.setString(4, customer.getEmail());
			preparedStatement.setString(5, customer.getPhone());
			preparedStatement.setString(6, customer.getAddress());
			
			sqlResult = preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(preparedStatement);
			DBHelper.close(connection);
		}
		
		return sqlResult;
	}
	
	public Customer selectCustomer(String customerId) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Customer customer = null;
		
		try {
			connection = DBHelper.getConnection(1);
			String sql = "select * from customer where customer_id = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, customerId);
			
			resultSet = preparedStatement.executeQuery();
			
			if (resultSet.next()) {
				customer.setId(resultSet.getString("customer_id"));
				customer.setPassword(resultSet.getString("customer_password"));
				customer.setName(resultSet.getString("customer_name"));
				customer.setEmail(resultSet.getString("customer_email"));
				customer.setPhone(resultSet.getString("customer_phone"));
				customer.setAddress(resultSet.getString("customer_address"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}
}
