package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Service;
import nashtech.ass.phuochg.coffeeshop.entities.Products;
@Service
@NamedQueries({
    @NamedQuery(name = "Products.getidCategory", query = "SELECT p FROM Products p where p.idCategory = :idCategory ")})
public interface ProductServices {

	public Products addProduct(Products products);
	
	public Products updateProduct(long id , Products products);

	public boolean deleteProduct(long id);
	
	
	public List<Products> getAllProduct();
	
	public List<Products> getAllProductbyCategory(long id);
	
	public Products getOneProduct(long id);

}
