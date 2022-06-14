package com.everis.proyectofinal.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.everis.proyectofinal.repository.EverisProduct;
import com.everis.proyectofinal.repository.EverisProductDaoI;
import com.everis.proyectofinal.services.EverisProductServiceI;

@Service
public class EverisProductServiceImpl implements EverisProductServiceI {

	/** Repositorio: products */
	@Autowired
	private EverisProductDaoI productRepository;

	@Override
	public List<EverisProduct> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public void removeProductById(final Long productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public void addProduct(final EverisProduct product) {
		productRepository.save(product);
	}

	@Override
	public void updProduct(final EverisProduct product) {
		productRepository.save(product);
	}

	@Override
	public List<EverisProduct> getProductByProductName(final String productName) {
		return productRepository.findByProductName(productName);
	}

	@Override
	public List<EverisProduct> getProductByCategory(final String category) {
		return productRepository.findByCategory(category);
	}

	@Override
	public List<EverisProduct> getProductBySellerName(final String sellerName) {
		return productRepository.findBySellerName(sellerName);
	}

	@Override
	public List<EverisProduct> getProductByRating(final int rating) {
		return productRepository.findByRating(rating);
	}

	@Override
	public List<EverisProduct> getProductByPlace(final String place) {
		return productRepository.findByPlace(place);
	}
}
