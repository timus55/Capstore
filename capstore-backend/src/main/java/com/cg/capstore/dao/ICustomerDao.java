package com.cg.capstore.dao;

import java.util.Set;
import com.cg.capstore.entities.Order;

public interface ICustomerDao {
	
	Long countOfCustomers() throws Exception;
	Set<Order>getOrders(String username);
	String getStatus(String username,Integer orderId);
}
