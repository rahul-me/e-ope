package com.gridscape.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "customers")
public class Customers extends BaseEntity {

	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "contact_no")
	private String contactNo;
	@Column(name = "utility_format")
	private Long utilityFormat;
	@Column(name = "is_data_in_kw")
	private boolean isDataInkw;
	@Column(name = "document_name")
	private String documentName;
	@Column(name = "customer_type")
	private String customerType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Long getUtilityFormat() {
		return utilityFormat;
	}

	public void setUtilityFormat(Long utilityFormat) {
		this.utilityFormat = utilityFormat;
	}

	public boolean isDataInkw() {
		return isDataInkw;
	}

	public void setDataInkw(boolean isDataInkw) {
		this.isDataInkw = isDataInkw;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

}
