/**
 * 
 */
package com.osqure.zabbot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ram
 *
 */
@Entity
@Table(name = "userinfo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class UserInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid", updatable=false, nullable=false)
	private Long id;
	
	@NotBlank
	@Column(name = "uname", unique = true, nullable = false, columnDefinition = "VARCHAR(64)")
	private String userName;
	
	@NotBlank
	@Column(name = "mobile", unique = true, nullable = false, columnDefinition = "VARCHAR(10)")
	private String mobile;
	
	@NotBlank
	@Column(name = "email", unique = true, nullable = false, columnDefinition = "VARCHAR(64)")
	private String email;
	
	@NotBlank
	@Column(name = "address1", nullable = false, columnDefinition = "VARCHAR(80)")
	private String address1;
	
	@NotBlank
	@Column(name = "address2", nullable = true, columnDefinition = "VARCHAR(80)")
	private String address2;
	
	@Column(name="createdat", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
