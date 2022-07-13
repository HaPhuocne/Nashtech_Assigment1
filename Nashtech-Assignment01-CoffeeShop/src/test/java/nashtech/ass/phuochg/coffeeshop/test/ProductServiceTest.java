package nashtech.ass.phuochg.coffeeshop.test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import nashtech.ass.phuochg.coffeeshop.dto.CategoryDto;
import nashtech.ass.phuochg.coffeeshop.dto.ProductDto;
import nashtech.ass.phuochg.coffeeshop.entities.Category;
import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
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
	ModelMapper modelMapper;

	
	  @BeforeEach
	    void beforeEach() {
		  productRepository = mock(ProductRepository.class);
		  categoryRepository = mock(CategoryRepository.class);
		  modelMapper = mock(ModelMapper.class);

		  productServiceImpl = new ProductServiceImpl(productRepository, categoryRepository,modelMapper);
		  category = mock(Category.class);
		  productDto = mock(ProductDto.class);
		  product = mock(Product.class);
		  
		  when(productRepository.save(product)).thenReturn(product);
		  when(modelMapper.map(productDto,Product.class)).thenReturn(product);
			
//	        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
//	        when(productRepository.save(product)).thenReturn(product);
	       
	    }

	  
	@Test
	public void getAllProducts_ShouldReturnHttpOk_WhenDataValid() {
		List<Product> list = new ArrayList<Product>();
		list.add(product);
		
		when(productRepository.findAll()).thenReturn(list);
		when(modelMapper.map(product, ProductDto.class)).thenReturn(productDto);
		ResponseEntity<?>  result =  productServiceImpl.getAllProduct();
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	public void getProduct_ShouldReturnProductDto_WhenDataValid() {
		when(productRepository.findById(1L)).thenReturn(Optional.of(product));
		when(modelMapper.map(product, ProductDto.class)).thenReturn(productDto);
		ProductDto result = productServiceImpl.findByIdProduct(1L);
		assertThat(result, is(productDto));
	}
	@Test
	public void getProduct_ShouldThrowResourceFoundException_WhenBookIdNotFound() {
		when(productRepository.findById(1L)).thenReturn(Optional.empty());
		ResourceFoundExceptions exception = Assertions.assertThrows(ResourceFoundExceptions.class, 
				() -> productServiceImpl.findByIdProduct(1L));
		assertThat(exception.getMessage(), is("Product not found"));
	}
	@Test
	void deleteProduct_ShouldReturnStatusOk_WhenDataValid() {
		when(productRepository.findById(1L)).thenReturn(Optional.of(product));
		when(modelMapper.map(product, ProductDto.class)).thenReturn(productDto);
		ResponseEntity<?> result = productServiceImpl.deleteProduct(1L);
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	void DeleteProduct_ThrowNotFoundException_WhenCategoryNotFound() {	
		when(productRepository.findById(1L)).thenReturn(Optional.empty());
		ResourceFoundExceptions exception = Assertions.assertThrows(ResourceFoundExceptions.class,
                () -> productServiceImpl.deleteProduct(1L));
        assertThat(exception.getMessage(), is("Product is not found"));
	}
	
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

		
	}



	
}
