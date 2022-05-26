package com.capg.DTO;

import java.util.List;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.capg.entity.Address;
import com.capg.entity.Customer;
import com.capg.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO {
	
	private Integer id;
	@NotBlank(message="First Name Can't Be Blank or Null!!")
	@Size(min = 1,max = 100)
	private String firstname;
	@NotBlank(message="Last Name Can't Be Blank or Null!!")
	@Size(min = 1,max = 100)
	private String lastname;
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}")
	@Column(unique = true)
	private String email;
	private Double salary;
	private Address address;
	private List<Order> order;
	
	public CustomerDTO(Customer customer) {
		this.id = customer.getId();
		this.firstname = customer.getFirstname();
		this.lastname = customer.getLastname();
		this.email = customer.getEmail();
		this.salary = customer.getSalary();
		this.address = customer.getAddress();
		this.order = customer.getOrder();
	}

}
