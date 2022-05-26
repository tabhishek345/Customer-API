package com.capg.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.capg.DTO.CustomerDTO;
import com.capg.entity.Customer;
import com.capg.exception.CustomerNotFoundException;
import com.capg.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<CustomerDTO> getAll() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
	}

	@Override
	public CustomerDTO CustomerbyId(Integer customerId) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Does Not Exist With Given Id :"+customerId));
		return new CustomerDTO(customer);
	}

	

	@Override
	public CustomerDTO createCustomer(CustomerDTO customerDTO) {
		Customer customer = new Customer(customerDTO);
		return new CustomerDTO(customerRepository.save(customer));
	}

	@Override
	@Transactional
	public CustomerDTO updateCustomer(Integer customerId, CustomerDTO customerDTO) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Does Not Exist With Given Id :"+customerId));
		customer.setFirstname(customerDTO.getFirstname());
		customer.setLastname(customerDTO.getLastname());
		customer.setEmail(customerDTO.getEmail());
		customer.setAddress(customerDTO.getAddress());
		customer.setOrder(customerDTO.getOrder());
		return new CustomerDTO(customer);
	}

	@Override
	public List<CustomerDTO> searchCustomers(String query) {
		List<Customer> customers= customerRepository.searchCustomers(query);
		return customers.stream().map(CustomerDTO::new).collect(Collectors.toList());
	}

	@Override
	public void deleteCustomer(Integer customerId) {
		
        Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Does Not Exist With Given Id :"+customerId));
		
        customerRepository.delete(customer);
		
	}

	@Override
	@Transactional
	public CustomerDTO partialCustomer(Integer customerId, String email) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Does Not Exist With Given Id :"+customerId));
		customer.setEmail(email);;
		return new  CustomerDTO(customer);
	}

	@Override
	public void deleteAll() {
		customerRepository.deleteAll();
		
	}

	@Override
	public CustomerDTO CustomerbyEmail(String customerEmail) {
		Customer customer = customerRepository.findByEmail(customerEmail).orElseThrow(() -> new CustomerNotFoundException("Customer Does Not Exist With Given Email :"+customerEmail));
		return new CustomerDTO(customer);
	}

	@Override
	public CustomerDTO partialCustomerfirstname(Integer customerId, String firstname) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Does Not Exist With Given First Name :"+firstname));
		customer.setFirstname(firstname);
		return new  CustomerDTO(customer);
	}

	@Override
	public CustomerDTO partialCustomerlastname(Integer customerId, String lastname) {
		Customer customer = customerRepository.findById(customerId).orElseThrow(() -> new CustomerNotFoundException("Customer Does Not Exist With Given Last Name :"+lastname));
		customer.setLastname(lastname);
		return new  CustomerDTO(customer);
	}
	
	

}
