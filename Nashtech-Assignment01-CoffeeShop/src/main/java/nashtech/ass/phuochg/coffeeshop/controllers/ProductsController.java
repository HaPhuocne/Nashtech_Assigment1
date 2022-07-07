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

import nashtech.ass.phuochg.coffeeshop.dto.ProductDto;
import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.entities.ResponseObject;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductServices productServices;

	@PostMapping("/")
	public ResponseEntity<?> addProduct(@Valid @RequestBody ProductDto productDto) {
		return productServices.addProduct(productDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @Valid @RequestBody ProductDto productDto) {

		return productServices.updateProduct(id, productDto);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
		return productServices.deleteProduct(id);
	}

	@GetMapping("/")
	public ResponseEntity<?> getAllProducts() {
		return productServices.getAllProduct();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseObject> getAllProductsByCategory(@PathVariable("id") long id) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok", "List product successfully", productServices.getAllProductbyCategory(id)));

	}
}