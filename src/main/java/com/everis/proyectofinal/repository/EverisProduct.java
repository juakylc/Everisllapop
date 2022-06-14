package com.everis.proyectofinal.repository;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Access(AccessType.FIELD)
@Table(name = "t_customers")
public class EverisProduct implements Serializable {

	/** SERIAL ID */
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador del producto
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long productId;

	/**
	 * Nombre del producto
	 */
	@Column(name = "productName", nullable = false)
	private String productName;

	/**
	 * Categoria
	 */
	@Column(name = "category", nullable = false)
	private String category;

	/**
	 * Descripcion
	 */
	@Column(name = "description", nullable = true)
	private String description;

	/**
	 * Localidad de venta
	 */
	@Column(name = "place", nullable = false)
	private String place;

	/**
	 * Nombre Vendedor
	 */
	@Column(name = "sellerName", nullable = false)
	private String sellerName;

	/**
	 * Telefono
	 */
	@Column(name = "phoneNumber", nullable = false)
	private int phoneNumber;

	/**
	 * Precio
	 */
	@Column(name = "price", nullable = false)
	private float price;

	/**
	 * Rating
	 */
	@Column(name = "rating", nullable = false)
	private int rating;

	/**
	 * Path de la imagen
	 */
	@Column(name = "image", nullable = true)
	private String image;

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "EverisProduct [productId=" + productId + ", productName=" + productName + ", category=" + category + ", description=" + description + ", place="
		        + place + ", sellerName=" + sellerName + ", phoneNumber=" + phoneNumber + ", price=" + price + ", rating=" + rating + ", image=" + image + "]";
	}

}
