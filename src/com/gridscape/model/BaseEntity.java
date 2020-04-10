/*******************************************************************************
 * Gridscape Solutions, Inc. - CONFIDENTIAL & PROPRIETARY
 * --------------------------
 * [2015] - [2020] Gridscape Solutions, Inc.
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Gridscape Solutions, Inc.
 * The intellectual and technical concepts contained
 * herein are proprietary to Gridscape Solutions, Inc.
 * and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Gridscape Solutions.
 *******************************************************************************/
 
  
  
package com.gridscape.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public class BaseEntity implements Serializable{
	/**
	 * 
	 */
	public BaseEntity(){
		
	}
	public BaseEntity(Long id){
		this.id=id;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	protected Long id;
	
	@Column(name="created_at", insertable = false, updatable = false,columnDefinition = "timestamp default current_timestamp")
    @Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
		
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at", insertable = true, updatable = true,columnDefinition = "timestamp default current_timestamp")
	private Date updated_at;
    	
	
	@Column(name="updated_by")
	private String updated_by;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}
	
	public void setUpdated_at(Date dt) {
		this.updated_at = dt;
	}

	public String getUpdated_by() {
		return updated_by;
	}

	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}

	@Override
	public String toString() {
		return "BaseEntity [id=" + id + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + ", updated_by=" + updated_by
				+ "]";
	}
}
