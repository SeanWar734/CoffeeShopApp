package co.grandcircus.CoffeeShopDB.Objects;

import java.io.Serializable;

public class UserPreference implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Products product;
	private String name;
	private String description;
	private Double price;
	private Double quantity;

	public Products getProduct() {
		return product;
	}

	public void setProduct(Products product) {
		this.product = product;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getQuantity() {
		return quantity;
	}

	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}

}
