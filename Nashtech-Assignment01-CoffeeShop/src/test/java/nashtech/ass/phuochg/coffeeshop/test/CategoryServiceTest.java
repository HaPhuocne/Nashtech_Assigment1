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
import nashtech.ass.phuochg.coffeeshop.entities.Category;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoryRepository;
import nashtech.ass.phuochg.coffeeshop.servicesimpl.CategoryServiceImpl;

public class CategoryServiceTest {
	CategoryRepository categoryRepository;
	CategoryServiceImpl categoryServiceImpl;
	ModelMapper modelMapper;
	CategoryDto categoryDto;
	Category category;
	
	@BeforeEach
	void beforeEach() {
		categoryRepository = mock(CategoryRepository.class);
		modelMapper = mock(ModelMapper.class);
		categoryServiceImpl = new CategoryServiceImpl(categoryRepository,modelMapper);
		categoryDto = mock(CategoryDto.class);
		category = mock(Category.class);
		
		when(categoryRepository.save(category)).thenReturn(category);
		when(modelMapper.map(categoryDto,Category.class)).thenReturn(category);
	}
	
	@Test
	void getCategory_ShouldReturnList_WhenDataValid() {
		// 1. create mock data
		List<Category> list = new ArrayList<>();
		list.add(category);
		
		
		when(categoryRepository.findAll()).thenReturn(list);
		
		List<CategoryDto> result = categoryServiceImpl.getAllCategory();
		
		assertThat(result.size(), is(list.size()));
	}
	@Test
	void addCategory_ShouldReturnCategoryDto_WhenDataValid() {
		when(modelMapper.map(category, CategoryDto.class)).thenReturn(categoryDto);
		CategoryDto result = categoryServiceImpl.addCategory(categoryDto);		
		assertThat(result, is(categoryDto));
	}
	
	@Test
	void updateCategory_ShouldReturnCategoryDto_WhenDataValid() {
		when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
		when(modelMapper.map(category, CategoryDto.class)).thenReturn(categoryDto);
		CategoryDto result = categoryServiceImpl.updateCategory(1L, categoryDto);
		assertThat(result, is(categoryDto));
	}
	@Test
	void updateCategory_ThrowNotFoundException_WhenCategoryNotFound() {
		when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
		ResourceFoundExceptions exception = Assertions.assertThrows(ResourceFoundExceptions.class,
                () -> categoryServiceImpl.updateCategory(1L, categoryDto));
        assertThat(exception.getMessage(), is("Category not found"));
	}
	
	@Test
	void deleteCategory_ShouldReturnStatusOk_WhenDataValid() {
		when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
		when(modelMapper.map(category, CategoryDto.class)).thenReturn(categoryDto);
		ResponseEntity<?> result = categoryServiceImpl.deleteCategory(1L);
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}
	@Test
	void deleteCategory_ThrowNotFoundException_WhenCategoryNotFound() {	
		when(categoryRepository.findById(1L)).thenReturn(Optional.empty());
		ResourceFoundExceptions exception = Assertions.assertThrows(ResourceFoundExceptions.class,
                () -> categoryServiceImpl.deleteCategory(1L));
        assertThat(exception.getMessage(), is("Category is not found"));
	}
	
}

