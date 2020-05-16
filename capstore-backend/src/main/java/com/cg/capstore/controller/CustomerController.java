package com.cg.capstore.controller;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.cg.capstore.entities.Order;
import com.cg.capstore.service.CustomerService;

@RestController
@CrossOrigin("*")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/helloCust")
	public ResponseEntity<Object> checkWorking(){
		return new ResponseEntity<Object>("Hello Customer..", HttpStatus.OK);
	}
	
	@GetMapping("/countOfCustomers")
	public ResponseEntity<Long> countOfCustomers() throws Exception{
		return new ResponseEntity<Long>(customerService.countOfCustomers(), HttpStatus.OK);
	}
	
	@GetMapping("/myorders/{username}")
	public ResponseEntity<Set<Order>> getOrders(@PathVariable("username")String username) throws Exception{
		return new ResponseEntity<Set<Order>>(customerService.getOrders(username), HttpStatus.OK);
	}
	
	@GetMapping("/status/{username}/{orderId}")
	public ResponseEntity<String> getStatus(@PathVariable("username")String username,@PathVariable("orderId")Integer orderId) throws Exception{
		return new ResponseEntity<String>(customerService.getStatus(username,orderId), HttpStatus.OK);
	}
	
	@GetMapping("/status/{username}/{orderId}")
	public ResponseEntity<String> setStatus(@PathVariable("username")String username,@PathVariable("orderId")Integer orderId) throws Exception{
		return new ResponseEntity<String>(customerService.getStatus(username,orderId), HttpStatus.OK);
	}
}
