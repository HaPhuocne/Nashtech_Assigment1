package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import org.springframework.stereotype.Service;
import nashtech.ass.phuochg.coffeeshop.entities.Products;

public interface ProductServices {

	public Products addProduct(Products products);
	
	public Products updateProduct(long id , Products products);

	public boolean deleteProduct(long id);
	
	public List<Products> getAllProduct();
	
	public Products getOneProduct(long id);

}
