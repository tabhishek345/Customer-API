package com.capg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capg.entity.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	
	//@Query("DELETE o, c from orders o inner join customer c on c.id = o.customer_id_fk where o.customer_id_fk = :id")
	//void deleteOrderbyCustomerId(String id);

}
