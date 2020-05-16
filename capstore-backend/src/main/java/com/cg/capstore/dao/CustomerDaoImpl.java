package com.cg.capstore.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cg.capstore.entities.CustomerDetails;
import com.cg.capstore.entities.Order;
import com.cg.capstore.repository.CustomerRepository;

@Repository("CustomerDaoImpl")
public class CustomerDaoImpl implements ICustomerDao{

	
	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public Long countOfCustomers() throws Exception {
		
		return (Long) customerRepository.count();
	}

	@Override
	public Set<Order> getOrders(String username) {
		if(customerRepository.existsById(username)) 
		{
			CustomerDetails cd = customerRepository.getOne(username);
			return cd.getOrders();
		}
		else 
		{
			return null;
		}	
	}
	@Override
	public String getStatus(String username,Integer orderId) {
		if(customerRepository.existsById(username)) 
		{
			CustomerDetails customer = customerRepository.getOne(username);
			Set<Order> orders = customer.getOrders();
			for (Order order : orders) {
				if(order.getOrderId()==orderId) {
					return order.getOrderStatus();
				}
			}
		}
		return null;	
	}
	
	
}
