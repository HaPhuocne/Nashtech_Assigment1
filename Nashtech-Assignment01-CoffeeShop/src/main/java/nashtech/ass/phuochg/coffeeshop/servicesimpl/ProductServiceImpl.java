package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.dto.ProductDto;
import nashtech.ass.phuochg.coffeeshop.entities.Category;
import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoryRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@Component
public class ProductServiceImpl implements ProductServices {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	 CategoryRepository categoryRepository;
	@Autowired
	 ModelMapper modelMapper;

	
	
	@Override
	public ResponseEntity<?> addProduct(ProductDto productDto) {
		Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategory().getIdCategory());
		if(!optionalCategory.isPresent()) {
			return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
		}
		
		productRepository.save(modelMapper.map(productDto,Product.class));
		return ResponseEntity.ok(new MessageResponse("Add new Product successfully"));
	}

	@Override
	public  ResponseEntity<?> updateProduct(long id, ProductDto productDto) {
				Optional<Product> optionalProduct = productRepository.findById(id);
				if(!optionalProduct.isPresent()) {
					throw new ResourceFoundExceptions("Product not found");
				}
				Optional<Category> optionalCategory = categoryRepository.findById(productDto.getCategory().getIdCategory());
				if(!optionalCategory.isPresent()) {
					return ResponseEntity.badRequest().body(new MessageResponse("Category not found"));
				}
				
				
				Product product = optionalProduct.get();

				modelMapper.map(productDto, product);
				product = productRepository.save(product);
				return ResponseEntity.ok(new MessageResponse("Update Product successfully"));
	}

	@Override
	public ResponseEntity<?> deleteProduct(long id) {
		Optional<Product> optional = productRepository.findById(id);
		if(optional.isPresent()) {
			Product product = optional.get();
			productRepository.delete(product);
				return ResponseEntity.ok(new MessageResponse("The book deleted successfully")) ;
			}	
		throw new ResourceFoundExceptions("Product is not found");
	}

	@Override
	public ResponseEntity<?> getAllProduct() {
		List<Product> list = productRepository.findAll();
		List<ProductDto> dto = new ArrayList<ProductDto>();
		list.forEach(b -> dto.add(modelMapper.map(b, ProductDto.class)));
		return ResponseEntity.ok(dto) ;
	}

	@Override
	public List<ProductDto> getAllProductbyCategory(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDto findByIdProduct(long id) {
				Optional<Product> optional = productRepository.findById(id);
				if(optional.isPresent()) {
					Product product = optional.get();
					return modelMapper.map(product, ProductDto.class);
				}
				throw new ResourceFoundExceptions("Product not found");
	}

	
}
