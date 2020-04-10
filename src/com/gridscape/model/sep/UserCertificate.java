package com.gridscape.model.sep;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gridscape.model.BaseEntity;

@Entity
@Table(name="sep_user_certificates")
public class UserCertificate extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8970062371538637805L;
	
	@Column(name="user_id")
	private Long user_id;
	
	@Column(name="cer_name")
	private String cer_name;
	
	@Column(name="serial_number")
	private String serial_number;
	
	@Column(name="client_alias")
	private String clientAlias;	
	
	@Column(name="signature", length=600)
	private String signature;
	
	@Column(name="file", columnDefinition="longblob")
	private byte[] file;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getCer_name() {
		return cer_name;
	}

	public void setCer_name(String cer_name) {
		this.cer_name = cer_name;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getClientAlias() {
		return clientAlias;
	}

	public void setClientAlias(String clientAlias) {
		this.clientAlias = clientAlias;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public byte[] getFile() {
		return file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}
	
	

	
	
}

