package com.capg.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capg.DTO.OrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId;
	@Column(name = "order_Name")
	private String orderName;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "price")
	private Long price;
	
	@ManyToOne
	@JoinColumn(name = "customer_id_fk")
	private Customer customer;
	
	public Order(OrderDTO orderdto) {
		this.orderId = orderdto.getOrderId();
		this.orderName = orderdto.getOrderName();
		this.quantity = orderdto.getQuantity();
		this.price = orderdto.getPrice();
	}

}
