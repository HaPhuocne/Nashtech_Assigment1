package nashtech.ass.phuochg.coffeeshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.entities.ResponseObject;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductServices productServices;

	@PostMapping("/")
	public ResponseEntity<ResponseObject> addProduct(@Valid @RequestBody Product products) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Insert product successfully", productServices.addProduct(products)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseObject> updateProduct(@PathVariable("id") long id, @RequestBody Product products) {

		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok", "update product successfully", productServices.updateProduct(id, products)));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseObject> deleteProduct(@PathVariable("id") long id) {
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("ok", "Delete product successsful", productServices.deleteProduct(id)));
	}

	@GetMapping("/")
	public ResponseEntity<ResponseObject> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "List product successfully", productServices.getAllProduct()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseObject> getAllProductsByCategory(@PathVariable("id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok", "List product successfully", productServices.getAllProductbyCategory(id)));

	}
}