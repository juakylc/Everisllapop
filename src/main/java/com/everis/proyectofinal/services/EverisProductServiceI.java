package com.everis.proyectofinal.services;

import java.util.List;

import com.everis.proyectofinal.repository.EverisProduct;

public interface EverisProductServiceI {
	/**
	 * Obtiene el listado de productos
	 * 
	 * @return List<EverisProduct>
	 */
	public List<EverisProduct> getAllProducts();

	/**
	 * 
	 * @param productName
	 * @return
	 */
	public List<EverisProduct> getProductByProductName(String productName);

	/**
	 * 
	 * @param category
	 * @return
	 */
	public List<EverisProduct> getProductByCategory(String category);

	/**
	 * 
	 * @param sellerName
	 * @return
	 */
	public List<EverisProduct> getProductBySellerName(String sellerName);

	/**
	 * 
	 * @param rating
	 * @return
	 */
	public List<EverisProduct> getProductByRating(int rating);

	/**
	 * 
	 * @param place
	 * @return
	 */
	public List<EverisProduct> getProductByPlace(String place);

	/**
	 * Elimina un producto por ID.
	 * 
	 * @param productId
	 */
	public void removeProductById(final Long productId);

	/**
	 * Añade un producto.
	 * 
	 * @param product
	 */
	public void addProduct(final EverisProduct product);

	/**
	 * Actualiza un producto.
	 * 
	 * @param product
	 */
	public void updProduct(final EverisProduct product);
}
