//package nashtech.ass.phuochg.coffeeshop.test;
//
//import static org.mockito.Mockito.when;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.modelmapper.ModelMapper;
//
//import nashtech.ass.phuochg.coffeeshop.dto.CategoryDto;
//import nashtech.ass.phuochg.coffeeshop.entities.Category;
//import nashtech.ass.phuochg.coffeeshop.entities.Product;
//import nashtech.ass.phuochg.coffeeshop.repositories.CategoryRepository;
//import nashtech.ass.phuochg.coffeeshop.servicesimpl.CartItemServiceImpl;
//
//public class CategoryServiceTest {
//
//	@Mock
//	CategoryRepository categoryRepository;
//	
//	@InjectMocks
//	CartItemServiceImpl cartItemServiceImpl;
//	
//	@Test
//	void whenGetAll_shouldReturnList() {
//		// 1. create mock data
//		List<Category> mockCategory = new ArrayList<>();
//		List<Product> mockProduct = new ArrayList<>();
//		ModelMapper modelMapper = new ModelMapper();
//		for(int i = 0; i < 5; i++) {
//			mockCategory.add(new Category((long)i, "test", mockProduct));
//		}
//		
//		// 2. define behavior of Repository
//		when(categoryRepository.findAll()).thenReturn(mockCategory);
//		
//		// 3. call service method
//		List<CategoryDto> actualBooks = cartItemServiceImpl.g();
//		
//		// 4. assert the result
//		assertThat(actualBooks.size()).isEqualTo(mockBooks.size());
//		
//		// 4.1 ensure repository is called
//		verify(bookRepository).findAll();
//	}
//}
//
