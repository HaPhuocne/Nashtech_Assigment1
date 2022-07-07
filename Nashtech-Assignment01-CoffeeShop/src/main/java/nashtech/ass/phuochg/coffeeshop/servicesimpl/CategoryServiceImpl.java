package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.dto.CategoryDto;
import nashtech.ass.phuochg.coffeeshop.entities.Category;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoryRepository;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.services.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public CategoryDto addCategory(CategoryDto categoryDto) {
		Category category = categoryRepository.save(modelMapper.map(categoryDto, Category.class));
		return modelMapper.map(category,CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(long id, CategoryDto categoryDto) {
		Optional<Category> categoryOptional = categoryRepository.findById(id);
		if(categoryOptional.isPresent()) {
			Category category = categoryOptional.get();
			modelMapper.map(categoryDto, category);
			category = categoryRepository.save(category);
			return modelMapper.map(category, CategoryDto.class);
		}
		throw new ResourceFoundExceptions("Category not found");
	}

	@Override
	public ResponseEntity<?> deleteCategory(long id) {
		Optional<Category> optional = categoryRepository.findById(id);
		if(optional.isPresent()) {
			Category category = optional.get();
				categoryRepository.delete(category);
				return ResponseEntity.ok(new MessageResponse("The category deleted successfully"));
			}
		throw new ResourceFoundExceptions("Category is not found");
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> list = categoryRepository.findAll();
		List<CategoryDto> listDto = new ArrayList<CategoryDto>();
		list.forEach(c -> listDto.add(modelMapper.map(c, CategoryDto.class)));
		return listDto;
	}

	@Override
	public Category findbyIdCategory(long id) {	
		return null;
	}
	
	
	
}
