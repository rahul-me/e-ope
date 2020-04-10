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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_role")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRole extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	@Column(name="role")
	private String role;
		
	@Column(name="roll_detail")
	private String roleDetail;

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRoleDetail() {
		return roleDetail;
	}

	public void setRoleDetail(String roleDetail) {
		this.roleDetail = roleDetail;
	}

	@Override
	public String toString() {
		return "UserRole [role=" + role + ", roleDetail=" + roleDetail + "]";
	}
		
}
