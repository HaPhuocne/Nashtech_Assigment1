package nashtech.ass.phuochg.coffeeshop.services;

import org.springframework.beans.factory.annotation.Autowired;

import nashtech.ass.phuochg.coffeeshop.entities.Products;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;

public class ProductServices {

	@Autowired 
	ProductRepository productRepository;
	
	public void add() {
		Products pro = new Products();
		pro.setProductName("test");
		pro.setCreateDate("test");
		pro.setUpdateDate("test");
		pro.setImage("test");
		pro.setPrice(100);
		pro.setQuantity(100);
		
		productRepository.save(pro);
		
	}

}
