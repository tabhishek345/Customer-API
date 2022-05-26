package com.capg.service;

import java.util.List;


import com.capg.DTO.CustomerDTO;



public interface CustomerService {
	
	List<CustomerDTO> getAll();
	
	CustomerDTO CustomerbyId(Integer customerId);
	
	CustomerDTO CustomerbyEmail(String customerEmail );
	
	CustomerDTO createCustomer(CustomerDTO customerDTO);
	
	CustomerDTO updateCustomer(Integer customerId, CustomerDTO customerDTO);
	
	List<CustomerDTO> searchCustomers(String query);
	
	void deleteCustomer(Integer customerId);
	
	void deleteAll();
	
	CustomerDTO partialCustomer(Integer customerId, String email);
	CustomerDTO partialCustomerfirstname(Integer customerId, String firstname);
	CustomerDTO partialCustomerlastname(Integer customerId, String lastname);
	
	

}
