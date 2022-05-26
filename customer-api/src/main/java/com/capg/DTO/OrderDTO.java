package com.capg.DTO;



import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.capg.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
	private Integer orderId;
	@NotBlank(message="Order Name Can't Be Blank or Null!!")
	@Size(min = 1,max = 100)
	private String orderName;
	private Integer quantity;
	private Long price;
	
	public OrderDTO(Order order) {
		this.orderId = order.getOrderId();
		this.orderName = order.getOrderName();
		this.quantity = order.getQuantity();
		this.price = order.getPrice();
	}
	

}
