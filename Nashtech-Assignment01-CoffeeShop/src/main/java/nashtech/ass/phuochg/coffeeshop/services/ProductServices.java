package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.dto.ProductDto;
@Service
public interface ProductServices {

	ResponseEntity<?> addProduct(ProductDto productDto);
	
	ResponseEntity<?> updateProduct(long id , ProductDto productDto);

	ResponseEntity<?> deleteProduct(long id);
	
	 ResponseEntity<?> getAllProduct();
	
	 List<ProductDto> getAllProductbyCategory(long id);

	 ProductDto findByIdProduct(long id);
	

}
