package com.gridscape.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gridscape.dao.UtilityImportCustomerDao;
import com.gridscape.model.UtilityImportCustomer;

@Service
public class UtilityImportCustomerService {

	@Autowired
	private UtilityImportCustomerDao utilityImportCustomerDao;

	public UtilityImportCustomer save(UtilityImportCustomer entity) {
		return utilityImportCustomerDao.save(entity);
	}

	public List<UtilityImportCustomer> findAll() {
		return utilityImportCustomerDao.findAll();
	}

	public UtilityImportCustomer findOneByMeterName(String meterName) {
		return utilityImportCustomerDao.findOneByMeterName(meterName);
	}

	public void saveAllEntityInBatch(UtilityImportCustomer customer) {
		// TODO Auto-generated method stub
		utilityImportCustomerDao.saveAllEntityInBatch(customer);
	}
}
