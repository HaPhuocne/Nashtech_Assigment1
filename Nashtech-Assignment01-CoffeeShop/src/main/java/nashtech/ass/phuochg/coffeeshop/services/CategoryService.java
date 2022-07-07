package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.dto.CategoryDto;
import nashtech.ass.phuochg.coffeeshop.entities.Category;

@Service
public interface CategoryService {
	
	public CategoryDto addCategory(CategoryDto categoryDto);

	public CategoryDto updateCategory(long id , CategoryDto categoryDto);

	public ResponseEntity<?>  deleteCategory(long id);
	
	public List<CategoryDto> getAllCategory();
	
	public Category findbyIdCategory(long id);
	
	
}
