package nashtech.ass.phuochg.coffeeshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.entities.Products;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;


@RestController
@RequestMapping("/products")
public class ProductsController {
	
	@Autowired
	private ProductServices productServices;
	
	
	@PostMapping("/add")
	public Products addProduct(@RequestBody Products products) {
		return productServices.addProduct(products);
	}
	
	@PutMapping("/update")
	public Products updateProduct(@RequestParam("id") long id,@RequestBody Products products) {
		return productServices.updateProduct(id, products);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteProduct(@PathVariable("id") long id) {
		return productServices.deleteProduct(id);
	}
	
	@GetMapping("/list")
	public List<Products> getAllProducts(){
		return productServices.getAllProduct();
	}
}