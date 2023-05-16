package org.order.app.service;

import java.sql.SQLException;
import java.util.List;

import org.order.app.dao.OrderDao;
import org.order.app.model.Orders;
import org.springframework.stereotype.Component;

@Component("orderService")
public class OrderServiceImpl implements OrderService{

	
	private final OrderDao orderDao;
	
	

	public OrderServiceImpl(OrderDao orderDao) {
		super();
		this.orderDao = orderDao;
	}



	@Override
	public List<Orders> getAllOrders() throws SQLException {
		// TODO Auto-generated method stub
		return orderDao.getAllOrders();
	}



	@Override
	public Orders createOrder(Orders order) throws SQLException {
		// TODO Auto-generated method stub
		return orderDao.createOrder(order);
	}



	@Override
	public Orders findByOrderId(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		return orderDao.findByOrderId(orderId);
	}



	@Override
	public int deleteByOrderId(int orderId) throws SQLException {
		// TODO Auto-generated method stub
		return orderDao.deleteByOrderId(orderId);
	}



	@Override
	public void deleteAllOrders() throws SQLException {
		// TODO Auto-generated method stub
		orderDao.deleteAllOrders();
	}



	@Override
	public void updateOrderByName(Orders orders) throws SQLException {
		orderDao.updateOrderByName(orders);
		
	}



	@Override
	public void updateOrderByPrice(Orders orders) throws SQLException {
		orderDao.updateOrderByPrice(orders);
		
	}



	@Override
	public int maxOrderValue() throws SQLException {
		return orderDao.maxOrderValue();
		
	}



	@Override
	public int minOrderValue() throws SQLException {
		return orderDao.minOrderValue();
		
	}

	

	

}