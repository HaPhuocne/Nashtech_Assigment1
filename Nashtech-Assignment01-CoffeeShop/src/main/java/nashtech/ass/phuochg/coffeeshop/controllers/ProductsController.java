package nashtech.ass.phuochg.coffeeshop.controllers;

import java.util.List;
import java.util.Optional;

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

import nashtech.ass.phuochg.coffeeshop.entities.Products;
import nashtech.ass.phuochg.coffeeshop.entities.ResponseObject;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@RestController
@RequestMapping("/products")
public class ProductsController {

	@Autowired
	private ProductServices productServices;
	@Autowired
	private ProductRepository productR;

	@PostMapping("/")
	public ResponseEntity<ResponseObject> addProduct(@RequestBody Products products) {
		List<Products> foundProduct = productR.findByProductName(products.getProductName().trim());
		if (foundProduct.size() > 0 || products.getQuantity() < 0) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("failed", "Insert product fails", ""));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Insert product successfully", productServices.addProduct(products)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseObject> updateProduct(@PathVariable("id") long id, @RequestBody Products products) {
		boolean exsitsProduct = productR.existsById(id);
		if (exsitsProduct) {
			List<Products> foundProduct = productR.findByProductName(products.getProductName().trim());
			if (foundProduct.size() > 0 || products.getQuantity() < 0) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
						.body(new ResponseObject("failed", "Insert product fails", ""));
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update product successfully",
						productServices.updateProduct(id, products)));
			}
		} else {
			products.setIdProduct(id);
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Insert product successfully",
					productServices.updateProduct(id, products)));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseObject> deleteProduct(@PathVariable("id") long id) {
		boolean exsitsProduct = productR.existsById(id);
		if (exsitsProduct)
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("ok", "Delete product successsful", productServices.deleteProduct(id)));
		else
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("failed", "Delete product fails", ""));

	}

	@GetMapping("/")
	public ResponseEntity<ResponseObject> getAllProducts() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "List product successfully", productServices.getAllProduct()));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseObject> getAllProductsByCategory(@PathVariable("id") long id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "List product successfully",productServices.getAllProductbyCategory(id)));
		
	}
}