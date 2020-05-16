package com.cg.capstore.service;

import java.util.List;
import java.util.Set;

import com.cg.capstore.entities.CustomerDetails;
import com.cg.capstore.entities.Order;

public interface CustomerService {
	
	Long countOfCustomers() throws Exception;
	Set<Order>getOrders(String username);
	String getStatus(String username,Integer orderId);

}
