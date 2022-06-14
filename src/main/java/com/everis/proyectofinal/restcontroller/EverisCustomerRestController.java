package com.everis.proyectofinal.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.proyectofinal.repository.EverisProduct;
import com.everis.proyectofinal.services.EverisProductServiceI;

@RestController
@RequestMapping("/products")
public class EverisCustomerRestController {

	/** Servicio: gestión de productos */
	@Autowired
	private EverisProductServiceI productService;

	@GetMapping
	public List<EverisProduct> getAllProducts() {
		return productService.getAllProducts();
	}

	@DeleteMapping("/{identifProduct}")
	public void deleteProduct(@PathVariable Long identifProduct) {
		productService.removeProductById(identifProduct);
	}

	@GetMapping("/{atrProduct}/{valueProduct}")
	public List<EverisProduct> searchByCategory(@PathVariable String atrProduct, @PathVariable String valueProduct) throws Exception {

		// Posibilidad de multiples resultados
		List<EverisProduct> productsList = new ArrayList<EverisProduct>();

		// Buscamos segun el atributo por su valor
		switch (atrProduct) {
		case "productName":
			productsList.addAll(productService.getProductByProductName(valueProduct));
			break;
		case "category":
			productsList.addAll(productService.getProductByCategory(valueProduct));
			break;
		case "place":
			productsList.addAll(productService.getProductByPlace(valueProduct));
			break;
		case "rating":
			productsList.addAll(productService.getProductByRating(Integer.parseInt(valueProduct)));
			break;
		}

		return productsList;
	}

	/*
	 * @GetMapping("/product") public List<EverisProduct> searchBy(@RequestBody EverisProduct searchedProduct) throws Exception {
	 * 
	 * // Posibilidad de múltiples resultados. List<EverisProduct> productsList = new ArrayList<EverisProduct>();
	 * 
	 * final String category = searchedProduct.getCategory();
	 * 
	 * final String customerFirstSurname = searchedCustomer.getFirstSurname(); final String customerSecondSurname = searchedCustomer.getSecondSurname();
	 * 
	 * if (StringUtils.hasText(category)) {
	 * 
	 * // Búsqueda por categoria final EverisProduct product = productService.getProductByCategory(category).get(0);
	 * 
	 * if (product != null) { productsList.add(product); }
	 * 
	 * } else { throw new Exception("Parámetros de búsqueda erróneos."); }
	 * 
	 * return productsList;
	 * 
	 * }
	 */

	@PutMapping("/product")
	public void deleteProduct(@RequestBody EverisProduct newProduct) {
		productService.addProduct(newProduct);
	}

}
