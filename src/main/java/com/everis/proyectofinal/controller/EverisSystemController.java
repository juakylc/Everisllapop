package com.everis.proyectofinal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Formación Spring.
 * 
 * @author Everis
 *
 */
@Controller
@RequestMapping("*")
public class EverisSystemController {

	/**
	 * Capta cualquier solicitud.
	 * 
	 * @return String
	 */
	@GetMapping
	public String showIndex() {
		return "index";
	}

	/**
	 * Redirecciona al controlador de gestión de productos.
	 * 
	 * @return String
	 */
	@GetMapping("/myProductsAdmin")
	public String redirectToAdminController() {
		return "gestionProductosVendedor";
	}

	@GetMapping("/edit")
	public String redirectToEdit(Model model) {
		return "editarProducto";
	}

	/**
	 * Redirecciona al controlador de gestión de productos.
	 * 
	 * @return String
	 */
	@GetMapping("/productsView")
	public String redirectToProductController() {
		return "redirect:showProductsView";
	}

	/**
	 * Redirecciona a la plantilla de insercción.
	 * 
	 * @return String
	 */
	@GetMapping("/newProductView")
	public String redirectToNewProductTemplate() {
		return "newProduct";
	}

}
