package com.gridscape.dao;

import java.util.List;

import com.gridscape.model.UtilityImportCustomer;

public interface UtilityImportCustomerDao {
	public UtilityImportCustomer save(UtilityImportCustomer entity);

	public List<UtilityImportCustomer> findAll();

	public void saveAllEntityInBatch(UtilityImportCustomer customer);

	public UtilityImportCustomer findOneByMeterName(String meterName);
}
