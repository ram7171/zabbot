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
@Table(name = "productinfo")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)

public class ProductInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="pid", updatable=false, nullable=false)
	private Long pid;
	
	@Column(name="cid", updatable=false, nullable=false)
	private Long cid;
	
	@Column(name="sid", updatable=false, nullable=false)
	private Long sid;
	
	@NotBlank
	@Column(name = "imgurl", unique = true, nullable = false, columnDefinition = "VARCHAR(64)")
	private String imgURL;

	@NotBlank
	@Column(name = "price", nullable = false)
	private int price;

	@NotBlank
	@Column(name = "likecnt", nullable = false)
	private int likesCount;
	
	public Long getPid() {
		return pid;
	}

	public void setPid(Long pid) {
		this.pid = pid;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
