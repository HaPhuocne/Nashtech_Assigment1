package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.entities.Products;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {

	@Autowired(required = false)
	private ProductRepository productRepository;
	@Autowired(required = false)
	Products products;

	public Products addProduct(Products products) {

		return productRepository.save(products);
	}

	public Products updateProduct(long id, Products products) {
		if (products != null) {
			Products reProducts = productRepository.getOne(id);
			if (reProducts != null) {
				reProducts.setProductName(products.getProductName());
				reProducts.setCategories(products.getCategories());
				reProducts.setImage(products.getImage());
				reProducts.setPrice(products.getPrice());
				reProducts.setCreateDate(products.getCreateDate());
				reProducts.setUpdateDate(products.getUpdateDate());
				return productRepository.save(reProducts);

			}
		}
		return null;
	}

	
	public boolean deleteProduct(long id) {
		if (id >= 1) {
			Products products = productRepository.getById(id);
			if (products != null) {
				productRepository.delete(products);
				return true;
			}
		}
		return false;
	}

	
	public Products getOneProduct(long id) {

		return productRepository.getById(id);
	}

	public List<Products> getAllProduct() {
		return productRepository.findAll();
	}


}
