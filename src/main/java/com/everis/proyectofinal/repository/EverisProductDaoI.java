package com.everis.proyectofinal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.proyectofinal.repository.EverisProduct;

@Repository
public interface EverisProductDaoI extends JpaRepository<EverisProduct, Long> {

	public List<EverisProduct> findByProductName(String name);

	public List<EverisProduct> findByCategory(String category);

	public List<EverisProduct> findBySellerName(String sellerName);

	public List<EverisProduct> findByRating(int rating);

	public List<EverisProduct> findByPlace(String place);
}
