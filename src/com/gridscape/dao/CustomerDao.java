package com.gridscape.dao;

import com.gridscape.model.Customers;

public interface CustomerDao {
	public Customers save(Customers entity);
	public Customers findOneCustomerByEmail(String email);
}
