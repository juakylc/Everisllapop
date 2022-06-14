package com.everis.proyectofinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.everis.proyectofinal.repository.EverisProduct;
import com.everis.proyectofinal.services.EverisProductServiceI;

@SpringBootApplication
public class ProyectoFinalApplication implements CommandLineRunner {

	/**
	 * Servicio de gestión del producto
	 */
	@Autowired
	private EverisProductServiceI productService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoFinalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Creacion de los productos
		EverisProduct product1 = new EverisProduct();
		product1.setProductName("GTA V");
		product1.setCategory("Electronica");
		product1.setDescription("Videojuego de Rockstar");
		product1.setPlace("Sevilla");
		product1.setSellerName("Joaquin");
		product1.setPhoneNumber(954112233);
		product1.setPrice(20.0f);
		product1.setRating(0);
		product1.setImage("/img/GTA.jpg");

		EverisProduct product2 = new EverisProduct();
		product2.setProductName("Imagina ser de Front");
		product2.setCategory("Electronica");
		product2.setDescription("Videojuego de Salesianos de Cadiz");
		product2.setPlace("Cadiz");
		product2.setSellerName("Luis");
		product2.setPhoneNumber(956112233);
		product2.setPrice(30.0f);
		product2.setRating(0);
		product2.setImage("/img/imagina.jpg");

		EverisProduct product3 = new EverisProduct();
		product3.setProductName("BMW Z4");
		product3.setCategory("Vehiculos");
		product3.setDescription("BMW Z4 con 2 años de uso");
		product3.setPlace("Sevilla");
		product3.setSellerName("Pedro");
		product3.setPhoneNumber(623432328);
		product3.setPrice(31000.0f);
		product3.setRating(0);
		product3.setImage("/img/bmw.jpg");

		EverisProduct product4 = new EverisProduct();
		product4.setProductName("Camiseta barça");
		product4.setCategory("Ropa");
		product4.setDescription("Camiseta del barça vendida por tenerla repetida");
		product4.setPlace("Barcelona");
		product4.setSellerName("Gerard");
		product4.setPhoneNumber(634832403);
		product4.setPrice(85.0f);
		product4.setRating(0);
		product4.setImage("/img/camisetabarcelona.jpg");

		EverisProduct product5 = new EverisProduct();
		product5.setProductName("Helicóptero teledirigido");
		product5.setCategory("Juguetes");
		product5.setDescription("Helicóptero teledirigido en perfecto estado");
		product5.setPlace("Madrid");
		product5.setSellerName("Manuel");
		product5.setPhoneNumber(662473238);
		product5.setPrice(36.0f);
		product5.setRating(0);
		product5.setImage("/img/helicoptero.jpg");

		EverisProduct product6 = new EverisProduct();
		product6.setProductName("Lavadora");
		product6.setCategory("Hogar");
		product6.setDescription("Lavadora Siemens");
		product6.setPlace("Valencia");
		product6.setSellerName("Francisco");
		product6.setPhoneNumber(643854030);
		product6.setPrice(1100.0f);
		product6.setRating(0);
		product6.setImage("/img/lavadora.jpg");

		EverisProduct product7 = new EverisProduct();
		product7.setProductName("Don Quijote de la Mancha");
		product7.setCategory("Libros");
		product7.setDescription("Don Quijote de la Mancha editorial Especial");
		product7.setPlace("Jaen");
		product7.setSellerName("Pedro");
		product7.setPhoneNumber(663233321);
		product7.setPrice(15.0f);
		product7.setRating(0);
		product7.setImage("/img/donquijote.jpg");

		productService.addProduct(product1);
		productService.addProduct(product2);
		productService.addProduct(product3);
		productService.addProduct(product4);
		productService.addProduct(product5);
		productService.addProduct(product6);
		productService.addProduct(product7);

		System.out.println("-----------------");

	}

}
