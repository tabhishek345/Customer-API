package com.capg.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capg.DTO.OrderDTO;
import com.capg.entity.Order;
import com.capg.exception.OrderNotFoundException;
import com.capg.repository.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService {

	
	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public List<OrderDTO> getOrders() {
		List<Order> orders= orderRepository.findAll();
		return orders.stream().map(OrderDTO::new).collect(Collectors.toList());
	}

	@Override
	public OrderDTO getOrder(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order Does Not Exist With Given Id : "+orderId));
		return new OrderDTO(order);

	}

	@Override
	@Transactional
	public OrderDTO updateOrder(Integer orderId, OrderDTO orderDTO) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order Does Not Exist With Given Id : "+orderId));
		order.setOrderName(orderDTO.getOrderName());
		order.setPrice(orderDTO.getPrice());
		order.setQuantity(orderDTO.getQuantity());
		return new OrderDTO(order);
	}

	@Override
	public void deleteOrder(Integer orderId) {
		Order order = orderRepository.findById(orderId).orElseThrow(() -> new OrderNotFoundException("Order Does Not Exist With Given Id : "+orderId));
		orderRepository.delete(order);
		
	}

	//@Override
	//public void deleteOrderbyCustomerId(String query) {
		// TODO Auto-generated method stub
		
	//}

	


}
