package com.gridscape.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.CustomerDao;
import com.gridscape.model.Customers;

@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public Customers save(Customers entity) {
		return customerDao.save(entity);
	}

	public Customers findOneCustomerByEmail(String email) {
		return customerDao.findOneCustomerByEmail(email);
	}
}
