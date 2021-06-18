/**
 *
 */
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author virens
 *
 */
@Entity
@Table(name = "\"Order\"")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String productId;

	private String customerIp;

	private String productName;

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(final String productId) {
		this.productId = productId;
	}

	public String getCustomerIp() {
		return customerIp;
	}

	public void setCustomerIp(final String customerIp) {
		this.customerIp = customerIp;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(final String productName) {
		this.productName = productName;
	}

}
