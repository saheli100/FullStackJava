package org.order.app.dao;

import java.sql.SQLException;
import java.util.List;

import org.order.app.model.Orders;

public interface OrderDao {

	public List<Orders> getAllOrders() throws SQLException;

	public Orders createOrder(Orders order) throws SQLException;

	public Orders findByOrderId(int orderId) throws SQLException;

	public int deleteByOrderId(int orderId) throws SQLException;

	public void deleteAllOrders() throws SQLException;

	public void updateOrderByName(Orders orders) throws SQLException;

	public void updateOrderByPrice(Orders orders) throws SQLException;

	public int maxOrderValue() throws SQLException;

	public int minOrderValue() throws SQLException;
}