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
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ram
 *
 */
@Entity
@Table(name = "orderinfo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)

public class OrderInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="oid", updatable=false, nullable=false)
	private Long orderId;
	
	@Column(name="cid", updatable=false, nullable=false)
	private Long categoryId;
	
	@Column(name="sid", updatable=false, nullable=false)
	private Long subCatId;

	@Column(name="pid", updatable=false, nullable=false)
	private Long productId;
	
	@NotBlank
	@Column(name = "price", nullable = false)
	private double price;
	
	@NotBlank
	@Column(name = "size", nullable = false)
	private int size;
	
	@NotBlank
	@Column(name = "color", nullable = true, columnDefinition = "VARCHAR(64)")
	private String color;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public Long getSubCatId() {
		return subCatId;
	}

	public void setSubCatId(Long subCatId) {
		this.subCatId = subCatId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
