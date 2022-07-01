package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.entities.Product;
@Service
public interface ProductServices {

	Product addProduct(Product products);
	
	Product updateProduct(long id , Product products);

	 boolean deleteProduct(long id);
	
	 List<Product> getAllProduct();
	
	 List<Product> getAllProductbyCategory(long id);

	 Product getOneProduct(long id);
	

}
