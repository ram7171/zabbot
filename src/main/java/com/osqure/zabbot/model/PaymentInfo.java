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
@Table(name = "paymentinfo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class PaymentInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", updatable=false, nullable=false)
	private Long id;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="uid", updatable=false, nullable=false)
	private Long uid;//foriegn key of user info
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String getCardNum() {
		return cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getCcvNum() {
		return ccvNum;
	}

	public void setCcvNum(String ccvNum) {
		this.ccvNum = ccvNum;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@NotBlank
	@Column(name = "cardnum", unique = true, nullable = false, columnDefinition = "VARCHAR(16)")
	private String cardNum;
	
	@NotBlank
	@Column(name = "cardtype", unique = true, nullable = false, columnDefinition = "VARCHAR(16)")
	private String cardType;
	
	@NotBlank
	@Column(name = "expiredate", unique = true, nullable = false, columnDefinition = "VARCHAR(16)")
	private String expireDate;
	
	@NotBlank
	@Column(name = "ccvnum", unique = true, nullable = false, columnDefinition = "VARCHAR(16)")
	private String ccvNum;
	
	@Column(name="createdat", nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

}
