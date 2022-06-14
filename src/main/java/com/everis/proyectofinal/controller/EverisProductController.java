package com.everis.proyectofinal.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.everis.proyectofinal.repository.EverisProduct;
import com.everis.proyectofinal.services.EverisProductServiceI;

/**
 * Formación Spring.
 * 
 * @author Everis
 *
 */
@Controller
public class EverisProductController {

	/**
	 * Servicio: gestión de Productos.
	 */
	@Autowired
	private EverisProductServiceI productsService;

	/**
	 * Muestra todos los productos.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/")
	public String showProducts(Model model) {

		// Obtención de productos.
		final List<EverisProduct> productsList = productsService.getAllProducts();

		// Carga de datos al modelo.
		model.addAttribute("productsListView", productsList);
		// model.addAttribute("btnDropProductEnabled", Boolean.FALSE);

		return "index";
	}

	/**
	 * Muestra todos los productos de una categoria.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/{category}")
	public String getProductsByCategory(@PathVariable String category, Model model) {

		// Obtención de productos.
		final List<EverisProduct> productsList = productsService.getProductByCategory(category);

		// Carga de datos al modelo.
		model.addAttribute("productsListView", productsList);
		// model.addAttribute("btnDropProductEnabled", Boolean.FALSE);

		return "productos";
	}

	/**
	 * Muestra todos los productos de una categoria.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/myProductsAdmin/{sellerName}")
	public String getProductsBySellerName(@PathVariable String sellerName, Model model) {

		// Obtención de productos.
		final List<EverisProduct> productsList = productsService.getProductBySellerName(sellerName);

		// Carga de datos al modelo.
		model.addAttribute("productsListView", productsList);
		model.addAttribute("btnDropProductEnabled", Boolean.FALSE);

		return "gestionProductosVendedor";
	}

	/**
	 * Muestra todos los productos de una categoria.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/location/{place}")
	public String getProductsByPlace(@PathVariable String place, Model model) {

		// Obtención de productos.
		final List<EverisProduct> productsList = productsService.getProductByPlace(place);

		// Carga de datos al modelo.
		model.addAttribute("productsListView", productsList);
		// model.addAttribute("btnDropProductEnabled", Boolean.FALSE);

		return "productos";
	}

	/**
	 * Muestra todos los productos de una categoria.
	 * 
	 * @param model
	 * @return String
	 */
	// @GetMapping("/product/{name}")
	// public String getProductsByProductName(@PathVariable String name, Model model) {
	//
	// // Obtención de productos.
	// final List<EverisProduct> productsList = productsService.getProductByProductName(name);
	//
	// // Carga de datos al modelo.
	// model.addAttribute("productsListView", productsList);
	// // model.addAttribute("btnDropProductEnabled", Boolean.FALSE);
	//
	// return "productos";
	// }

	/**
	 * Elimina un producto
	 * 
	 * @param productId
	 * @param model
	 * @return
	 */
	@PostMapping("/myProductsAdmin")
	public String deleteProduct(@RequestParam String productId, Model model) {

		// Eliminación de productos.
		productsService.removeProductById(Long.valueOf(productId));

		return "gestionProductosVendedor";
	}

	/**
	 * Método de consulta.
	 * 
	 * @param searchedProduct
	 * @param model
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/actSearchProduct")
	public String submitSearchProductForm(@ModelAttribute EverisProduct searchedProduct, Model model) throws Exception {

		// Posibilidad de múltiples resultados.
		List<EverisProduct> productsList = new ArrayList<EverisProduct>();

		// final String name = searchedProduct.getProductName();
		final String productName = searchedProduct.getProductName();

		if (StringUtils.hasText(productName)) { // Aqui iria name

			// Búsqueda por nombre.
			final List<EverisProduct> products = productsService.getProductByProductName(productName); // Aqui lista de productos

			if (!products.isEmpty()) {
				productsList.addAll(products);
			}

		} else {
			throw new Exception("Parámetros de búsqueda erróneos.");
		}

		// Carga de datos al modelo.
		model.addAttribute("productsListView", productsList);
		// model.addAttribute("btnDropProductEnabled", Boolean.TRUE);

		return "productos";
	}

	/**
	 * Método de inserción del producto.
	 * 
	 * @param newProduct
	 * @param result
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/actAddProduct")
	private String submitAddProductForm(@Valid @ModelAttribute EverisProduct newProduct, BindingResult result) throws Exception {

		newProduct.setImage("img/notfound.jpg");
		// Se añade el nuevo producto.
		productsService.addProduct(newProduct);

		return "gestionProductosVendedor";
	}
	
	/**
	 * Método de actualizacion del producto.
	 * 
	 * @param newProduct
	 * @param result
	 * @return String
	 * @throws Exception
	 */
	@PostMapping("/actUpdProduct")
	private String submitUpdProductForm(@Valid @ModelAttribute EverisProduct newProduct, BindingResult result) throws Exception {

		// Se actualiza el nuevo producto.
		productsService.updProduct(newProduct);

		return "gestionProductosVendedor";
	}

}
