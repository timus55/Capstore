package com.cg.capstore.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.capstore.dao.ICustomerDao;
import com.cg.capstore.entities.CustomerDetails;
import com.cg.capstore.entities.Order;

@Transactional
@Service("CustomerServiceImpl")
public class CustomerServiceImpl implements CustomerService{
	
	@Autowired
	private ICustomerDao customerDao;
	
	@Override
	public Long countOfCustomers() throws Exception {
		return customerDao.countOfCustomers();
	}

	@Override
	public Set<Order> getOrders(String username) {
		return customerDao.getOrders(username);
	}

	@Override
	public String getStatus(String username,Integer orderId) {
		return customerDao.getStatus(username,orderId);
	}

}
