package com.capg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.capg.DTO.OrderDTO;
import com.capg.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController  {
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/getall")
	public List<OrderDTO> order(){
		return orderService.getOrders();
	}
	
	@GetMapping("/get/{orderId}")
	public OrderDTO CustomerbyId(@PathVariable Integer orderId) {
		return orderService.getOrder(orderId);
	}
	
	@PutMapping("/update/{orderId}")
	public ResponseEntity<OrderDTO> update(@PathVariable Integer orderId, @RequestBody OrderDTO prod) {
		return new ResponseEntity<OrderDTO>(orderService.updateOrder(orderId, prod), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{orderId}")
	public String delete(@PathVariable Integer orderId) {
		orderService.deleteOrder(orderId);
		return "Product with ID "+ orderId + " Was Delete Successfully!!";
	}
	
	

}
