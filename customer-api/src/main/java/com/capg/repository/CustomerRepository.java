package com.capg.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Optional<Customer> findByEmail(String customerEmail);
	
	@Query("SELECT p FROM Customer p join p.address a WHERE "+
			"p.firstname LIKE CONCAT('%', :query, '%') "+
			"OR p.lastname LIKE CONCAT('%', :query, '%') "+
			"OR p.email LIKE CONCAT('%', :query, '%')"+
			"OR a.city LIKE CONCAT('%', :query, '%')"+
			"OR a.state LIKE CONCAT('%', :query, '%')")
	List<Customer> searchCustomers(String query);
	
	

}
