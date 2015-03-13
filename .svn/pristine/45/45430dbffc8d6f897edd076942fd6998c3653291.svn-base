package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.List;

import util.DBHelper;
import vo.OrderInfo;

public class OrderInfoDAO {
	private static OrderInfoDAO orderInfoDaoInstance;

	private OrderInfoDAO() {
		// TODO Auto-generated constructor stub
	}

	public static OrderInfoDAO getInstance() {
		if (orderInfoDaoInstance == null) {
			orderInfoDaoInstance = new OrderInfoDAO();
		}

		return orderInfoDaoInstance;
	}

	public OrderInfo selectOrderInfo(int orderNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		OrderInfo anOrderInfo = null;

		try {
			connection = DBHelper.getConnection(1);
			String sql = "select * from order_info where order_no = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderNo);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				anOrderInfo = new OrderInfo();

				anOrderInfo.setOrderDate(resultSet.getDate("order_date"));
				anOrderInfo
						.setOrderQuantity(resultSet.getInt("order_quantity"));
				anOrderInfo.setCustomerId(resultSet.getString("customer_id"));
				anOrderInfo.setProductNo(resultSet.getInt("product_no"));
				anOrderInfo.setProductSize(resultSet.getString("product_size"));
				anOrderInfo.setPaymentType(resultSet.getString("payment_type"));
				anOrderInfo
						.setPaymentType(resultSet.getString("payment_check"));
				anOrderInfo.setShippingMessage(resultSet
						.getString("shipping_message"));
				anOrderInfo.setShippingStatus(resultSet
						.getString("shipping_status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(resultSet);
			DBHelper.close(preparedStatement);
			DBHelper.close(connection);
		}

		return anOrderInfo;
	}

	public List<OrderInfo> selectOrderInfoList() {

		return null;
	}

	public OrderInfo selectLastestOrderInfo() {
		// TODO Auto-generated method stub
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		OrderInfo orderInfo = new OrderInfo();

		try {
			connection = DBHelper.getConnection(1);
			statement = connection.createStatement();
			String sql = "select * from order_info order by order_no "
					+ "desc limit 0, 1";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				orderInfo.setOrderNo(resultSet.getInt("order_no"));
				orderInfo.setOrderDate(resultSet.getDate("order_date"));
				orderInfo.setOrderQuantity(resultSet.getInt("order_quantity"));
				orderInfo.setCustomerId(resultSet.getString("customer_id"));
				orderInfo.setProductNo(resultSet.getInt("product_no"));
				orderInfo.setProductSize(resultSet.getString("product_size"));
				orderInfo.setPaymentType(resultSet.getString("payment_type"));
				orderInfo
						.setPaymentCheck(resultSet.getBoolean("payment_check"));
				orderInfo.setShippingMessage(resultSet
						.getString("shipping_message"));
				orderInfo.setShippingStatus(resultSet
						.getString("shipping_status"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBHelper.close(resultSet);
			DBHelper.close(statement);
			DBHelper.close(connection);
		}

		return orderInfo;

	}

	public int insertOrderInfo(OrderInfo orderInfo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int sqlResult = 0;

		try {
			connection = DBHelper.getConnection(1);
			String sql = "insert into order_info (order_date, order_quantity, "
					+ "customer_id, product_no, product_size, payment_type, "
					+ "payment_check, shipping_message, shipping_status) "
					+ "values (?, ?, ?, ?, ? ,? ,?, ?, ?)";
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setTimestamp(1, new Timestamp(orderInfo
					.getOrderDate().getTime()));
			preparedStatement.setInt(2, orderInfo.getOrderQuantity());
			preparedStatement.setString(3, orderInfo.getCustomerId());
			preparedStatement.setInt(4, orderInfo.getProductNo());
			preparedStatement.setString(5, orderInfo.getProductSize());
			preparedStatement.setString(6, orderInfo.getPaymentType());
			preparedStatement.setBoolean(7, orderInfo.isPaymentCheck());
			preparedStatement.setString(8, orderInfo.getShippingMessage());
			preparedStatement.setString(9, orderInfo.getShippingStatus());

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

	public int deleteOrderInfo(int orderNo) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int sqlResult = 0;

		try {
			connection = DBHelper.getConnection(1);
			String sql = "delete * from order_info where order_no = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderNo);

			sqlResult = preparedStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sqlResult;
	}

	public int updateOrderInfo(int orderNo, int orderQuantity,
			String paymentType, boolean paymentCheck, String shippingMessage,
			String shippingStatus) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int sqlResult = 0;

		try {
			connection = DBHelper.getConnection(1);
			String sql = "update order_info set order_quantity = ?, "
					+ "payment_type = ?, payment_check = ?,"
					+ "shipping_message = ?, shipping_status = ?"
					+ "where order_no = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, orderQuantity);
			preparedStatement.setString(2, paymentType);
			preparedStatement.setBoolean(3, paymentCheck);
			preparedStatement.setString(4, shippingMessage);
			preparedStatement.setString(5, shippingStatus);
			preparedStatement.setInt(6, orderNo);

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

}
