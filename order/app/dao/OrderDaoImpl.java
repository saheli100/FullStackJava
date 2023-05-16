package org.order.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.order.app.model.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("orderDao")
public class OrderDaoImpl implements OrderDao {

	private final DataSource dataSource;
	int id = 0;

	@Autowired
	public OrderDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<Orders> getAllOrders() throws SQLException {
		List<Orders> list = new ArrayList<Orders>();
		try {
			Connection connection = dataSource.getConnection();

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from orders");
			while (resultSet.next()) {
				list.add(new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3)));
			}

		} catch (Exception e) {

		}
		return list;

	}

	@Override
	public Orders createOrder(Orders order) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into orders values(?,?,?)");

		preparedStatement.setInt(1, order.getOrderId());
		preparedStatement.setString(2, order.getOrder_name());
		preparedStatement.setInt(3, order.getOrderPrice());

		preparedStatement.executeUpdate();

		return order;
	}

	@Override
	public Orders findByOrderId(int orderId) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from orders where order_id=?");
		preparedStatement.setInt(1, orderId);
		ResultSet resultSet = preparedStatement.executeQuery();

		Orders order = null;
		while (resultSet.next()) {
			order = new Orders(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
		}

		return order;
	}

	@Override
	public int deleteByOrderId(int orderId) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from orders where order_id=?");
		preparedStatement.setInt(1, orderId);
		int count = preparedStatement.executeUpdate();

		return count;
	}

	@Override
	public void deleteAllOrders() throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement("delete from orders");

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateOrderByName(Orders orders) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update orders set order_name=? where order_id=?");

			preparedStatement.setString(1, orders.getOrder_name());
			preparedStatement.setInt(2, orders.getOrderId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateOrderByPrice(Orders orders) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection
					.prepareStatement("update orders set order_price=? where order_id=?");

			preparedStatement.setInt(1, orders.getOrderPrice());
			preparedStatement.setInt(2, orders.getOrderId());

			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public int maxOrderValue() throws SQLException {
		Connection connection = dataSource.getConnection();
		int price = 0;
		try {
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select MAX(order_price) as maxVal from orders");
			if (resultset.next()) {
				price = resultset.getInt("maxVal");
				System.out.println(price);
				// just return this int
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return price;
	}

	@Override
	public int minOrderValue() throws SQLException {
		Connection conn = dataSource.getConnection();
		int price = 0;
		try {

			Statement statement = conn.createStatement();
			ResultSet resultset = statement.executeQuery("select min(order_price) as minVal from orders");
			if (resultset.next()) {
				price = resultset.getInt("minVal");
				System.out.println(price);
				// just return this int
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return price;

	}
}