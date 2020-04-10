
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SelectBeforeUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "users")
@JsonIgnoreProperties(ignoreUnknown = true)
@DynamicUpdate(value=true)
@SelectBeforeUpdate
public class User extends Address implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "userId", unique = true)
	private String userId;

	@Column(name = "fullname", length = 50)
	private String fullname;
	
	@Column(name = "email", length = 50)
	private String email;
	
	@Column(name = "login_count")
	private long login_count;
	
	@Column(name = "dynamicToken", length = 50)
	private String dynamicToken;
	
	@Column(name = "userName", length = 50)
	private String userName;
	
	@Column(name = "password", length = 50)
	private String password;
	
	@Column(name = "IS_ACTIVE", columnDefinition = "boolean default false")
	private boolean active;
	
	@Column(name = "IS_ADMIN", columnDefinition = "boolean default false")
	private boolean admin;
	
	@Column(name = "mobile",length=20)
	private String mobile;
	
	@Column(name="img_url",length=150)
	private String image;
	
	@Column(name="is_delete",columnDefinition = "boolean default false")
	private Boolean isDelete;
	
	@ManyToOne
	@JoinColumn(name = "orgId")
	private Organization orgId;
	
	@OneToOne
	@JoinColumn(name = "user_role_id")
	private UserRole userRole;
		
	@Column(name="sep_access", columnDefinition= "tinyint default false")
	private boolean sepAccess;
	
	@Column(name="sep_only", columnDefinition= "tinyint default false")
	private boolean sepOnly;
	
	@Column(name="analysis_access", columnDefinition = "tinyint default false")
	private boolean analysisAccess;
	
	@Column(name="analysis_only_access", columnDefinition = "tinyint default false")
	private boolean analysisOnlyAccess;
	
	
	public boolean isAnalysisAccess() {
		return analysisAccess;
	}

	public void setAnalysisAccess(boolean analysisAccess) {
		this.analysisAccess = analysisAccess;
	}

	public boolean isAnalysisOnlyAccess() {
		return analysisOnlyAccess;
	}

	public void setAnalysisOnlyAccess(boolean analysisOnlyAccess) {
		this.analysisOnlyAccess = analysisOnlyAccess;
	}

	public boolean isSepOnly() {
		return sepOnly;
	}

	public void setSepOnly(boolean sepOnly) {
		this.sepOnly = sepOnly;
	}

	public boolean isSepAccess() {
		return sepAccess;
	}

	public void setSepAccess(boolean sepAccess) {
		this.sepAccess = sepAccess;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getLogin_count() {
		return login_count;
	}

	public void setLogin_count(long login_count) {
		this.login_count = login_count;
	}

	public String getDynamicToken() {
		return dynamicToken;
	}

	public void setDynamicToken(String dynamicToken) {
		this.dynamicToken = dynamicToken;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Boolean isDelete) {
		this.isDelete = isDelete;
	}

	public Organization getOrgId() {
		return orgId;
	}

	public void setOrgId(Organization orgId) {
		this.orgId = orgId;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}	
}

