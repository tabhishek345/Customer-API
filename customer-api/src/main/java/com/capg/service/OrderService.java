package com.capg.service;

import java.util.List;

import com.capg.DTO.OrderDTO;

public interface OrderService {
	
	List<OrderDTO> getOrders();
	
	OrderDTO getOrder(Integer orderId);
	
	OrderDTO updateOrder(Integer orderId, OrderDTO orderDTO);
	
	void deleteOrder(Integer orderId);
	
	//void deleteOrderbyCustomerId(String query);

}
