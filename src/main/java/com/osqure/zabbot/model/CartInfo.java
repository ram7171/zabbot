/**
 * 
 */
package com.osqure.zabbot.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ram
 *
 */
@Entity
@Table(name = "cartinfo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)

public class CartInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cartid", updatable=false, nullable=false)
	private Long cartid;
	
	@Id
	@Column(name="uid", updatable=false, nullable=false)
	private Long uid;//foriegn key of user info
	
	@Id
	@Column(name="cid", updatable=false, nullable=false)
	private Long cid;//foriegn key of user info
	
	@Id
	@Column(name="scid", updatable=false, nullable=false)
	private Long scid;//foriegn key of user info

	public Long getCartid() {
		return cartid;
	}

	public void setCartid(Long cartid) {
		this.cartid = cartid;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getScid() {
		return scid;
	}

	public void setScid(Long scid) {
		this.scid = scid;
	}
}
