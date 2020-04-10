package com.gridscape.model.sep;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.gridscape.model.BaseEntity;

@Entity
@Table(name="sep_der_programs")
public class DERProgram extends BaseEntity implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "user_id")
	private String user_id;
	
	@Column(name="primacy")
	private Short primacy;
	
	@Column(name="m_rid", length = 50)
	private String m_rid;
	
	@Column(name="description", length = 50)
	private String description;
	
	@Column(name="version", columnDefinition = "int default 0")
	private Integer version;
	

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public Short getPrimacy() {
		return primacy;
	}

	public void setPrimacy(Short primacy) {
		this.primacy = primacy;
	}

	public String getM_rid() {
		return m_rid;
	}

	public void setM_rid(String m_rid) {
		this.m_rid = m_rid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public boolean equals(Object object){
		boolean status = false;
		if(object!= null){
			if(getClass() == object.getClass()){
				DERProgram derProgram = (DERProgram) object;
				if(this.id.longValue() == derProgram.id.longValue()){
					status = true;
				}
			}
		}
		return status;
	}
	
	public int hashCode(){
		return this.id.intValue();
	}

}
