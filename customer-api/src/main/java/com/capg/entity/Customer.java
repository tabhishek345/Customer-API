package com.capg.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.capg.DTO.CustomerDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(name="customer_firstname")
	private String firstname;
	@Column(name="customer_lastname")
	private String lastname;
	@Column(name="customer_email")
	private String email;
	@Column(name="customer_salary")
	private Double salary;
	@Embedded
	private Address address;
	
	@OneToMany(
			mappedBy = "customer",
			cascade = CascadeType.ALL,
            orphanRemoval = true)
	private List<Order> order = new ArrayList<>();
	
	
	
	public Customer(CustomerDTO customerdto) {
		this.id = customerdto.getId();
		this.firstname =customerdto.getFirstname();
		this.lastname = customerdto.getLastname();
		this.email = customerdto.getEmail();
		this.salary = customerdto.getSalary();
		this.address = customerdto.getAddress();
		this.order = customerdto.getOrder();
	}

}
