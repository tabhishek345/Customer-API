package com.capg.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capg.DTO.CustomerDTO;


import com.capg.service.CustomerService;



@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/getall")
	public List<CustomerDTO> customer(){
		return customerService.getAll();
	}
	
	@PostMapping("/save")
	public ResponseEntity<CustomerDTO> save(@Valid @RequestBody CustomerDTO prod) {
		return new ResponseEntity<CustomerDTO>(customerService.createCustomer(prod), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/deleteAll")
	public String deleteAll() {
		customerService.deleteAll();
		return "All customers deleted Successfully!!!";
	}
	
	@GetMapping("/get/{customerId}")
	public CustomerDTO CustomerbyId(@PathVariable Integer customerId) {
		return customerService.CustomerbyId(customerId);
	}
	
	@GetMapping("/search")
	public List<CustomerDTO> searchProduct(@RequestParam("query") String query){
		return customerService.searchCustomers(query);
	}
	
	@GetMapping("/getmail/{customerEmail}")
	public CustomerDTO CustomerbyEmail(@PathVariable String customerEmail) {
	return customerService.CustomerbyEmail(customerEmail);
	}
	
	@DeleteMapping("/delete/{customerId}")
	public String delete(@PathVariable Integer customerId) {
		customerService.deleteCustomer(customerId);
		return "Product with ID "+ customerId + "Was Delete Successfully!!";
	}
	
	@PatchMapping("/partialupdate/{customerId}/{email}")
	public ResponseEntity<CustomerDTO> partialUpdateCustomer(@PathVariable Integer customerId,@PathVariable String email){
		
		return new ResponseEntity<>(customerService.partialCustomer(customerId, email),HttpStatus.OK);
	}
	
	@PutMapping("/update/{customerId}")
	public ResponseEntity<CustomerDTO> update(@PathVariable Integer customerId, @RequestBody CustomerDTO prod) {
		return new ResponseEntity<CustomerDTO>(customerService.updateCustomer(customerId, prod), HttpStatus.ACCEPTED);
	}
	
	@PatchMapping("/partialupdatefirstname/{customerId}/{firstname}")
	public ResponseEntity<CustomerDTO> partialUpdateCustomerfirstname(@PathVariable Integer customerId,@PathVariable String firstname){
		
		return new ResponseEntity<>(customerService.partialCustomerfirstname(customerId, firstname),HttpStatus.OK);
	}
	
	@PatchMapping("/partialupdatelastname/{customerId}/{lastname}")
	public ResponseEntity<CustomerDTO> partialUpdateCustomerlastname(@PathVariable Integer customerId,@PathVariable String lastname){
		
		return new ResponseEntity<>(customerService.partialCustomerlastname(customerId, lastname),HttpStatus.OK);
	}
	
	

}
