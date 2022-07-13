package nashtech.ass.phuochg.coffeeshop.test;




import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import nashtech.ass.phuochg.coffeeshop.dto.CategoryDto;
import nashtech.ass.phuochg.coffeeshop.dto.ProductDto;
import nashtech.ass.phuochg.coffeeshop.entities.Category;
import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoryRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.servicesimpl.ProductServiceImpl;

public class ProductServiceTest {
	
	ProductRepository productRepository;
	CategoryRepository  categoryRepository;
	ProductServiceImpl productServiceImpl;
	CategoryDto categoryDto;
	ProductDto productDto;
	Category category;
	Product product;

	
	  @BeforeEach
	    void beforeEach() {
		  productRepository = mock(ProductRepository.class);
		  categoryRepository = mock(CategoryRepository.class);
		  productServiceImpl = new ProductServiceImpl(productRepository, categoryRepository);

		  category = mock(Category.class);
		  product = mock(Product.class);
//	        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
//	        when(productRepository.save(product)).thenReturn(product);
	       
	    }

	  
//	@Test
//	public void getAllProducts_ShouldReturnHttpOk_WhenDataValid() {
//		List<Product> list = new ArrayList<Product>();
//
//		for(int i = 0; i < 5; i++) {
//			list.add(mock(Product.class));
//		}
//		when(productRepository.findAll()).thenReturn(list);
//	Requ	List<Product> result = (List<Product>) productServiceImpl.getAllProduct();
//		assertThat(result.getStatusCode(), is(HttpStatus.OK));
//	}

	@Test
	public void addProduct_ShouldReturnStatusOk_WhenDataValid() {
		
		
		ProductDto productDto = new ProductDto();	
		productDto.setProductName("coffee");
		productDto.setCreateDate("test");
		productDto.setImage("test");
		productDto.setPrice(10000);
		productDto.setUpdateDate("test");
		productDto.setQuantity(100);
		productDto.setCategory(new ModelMapper().map(category, CategoryDto.class));
		when(categoryRepository.findById(productDto.getCategory().getIdCategory())).thenReturn(Optional.of(category));

		when(productRepository.save(new ModelMapper().map(productDto, Product.class))).thenReturn(product);
		new ModelMapper().map(product, ProductDto.class);
		new ModelMapper().map(category, CategoryDto.class);

		ResponseEntity<?> responseEntity = productServiceImpl.addProduct(productDto);
		System.out.println(responseEntity);
		assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
//		}
		
	}



	
}
