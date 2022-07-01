package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoryRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@Component
public class ProductServiceImpl implements ProductServices {

	@Autowired(required = false)
	private ProductRepository productRepository;
	@Autowired(required = false)
	Product products;
	@Autowired(required = false)
	CategoryRepository categoriesRepository;

	public Product addProduct(Product products) {
		boolean idexist = categoriesRepository.existsById(products.getCategory().getIdCategory());
		if (idexist) {
			try {
				return productRepository.save(products);
			} catch (Exception e) {
				e.toString();
			}
		}
		throw new ResourceFoundExceptions("Insert Fails");

	}

	public Product updateProduct(long id, Product products) {
		if (products != null) {
			Product reProducts = productRepository.getOne(id);
			if (reProducts != null) {
				try {
					reProducts.setProductName(products.getProductName());
					reProducts.setCategory(products.getCategory());
					reProducts.setImage(products.getImage());
					reProducts.setPrice(products.getPrice());
					reProducts.setCreateDate(products.getCreateDate());
					reProducts.setUpdateDate(products.getUpdateDate());
					return productRepository.save(reProducts);
				} catch (Exception e) {
					e.toString();
				}
			}
		}
		throw new ResourceFoundExceptions("Update Fails");
	}

	public boolean deleteProduct(long id) {
		try {
			if (id >= 1) {
				Product products = productRepository.getById(id);
				if (products != null) {
					productRepository.delete(products);
					return true;
				}
			}
			return false;
		} catch (Exception e) {
			e.toString();
		}

	}

	public Product getOneProduct1(long id) {

		return productRepository.getById(id);
	}

	public List<Product> getAllProduct() {
		return productRepository.findAll();
	}

	@Override

	public List<Product> getAllProductbyCategory(long id) {
		return productRepository.getProductbyIdcategory(id);
	}

	public Product getOneProduct(long id) {
		return productRepository.getByIdProduct(id);
	}

}
