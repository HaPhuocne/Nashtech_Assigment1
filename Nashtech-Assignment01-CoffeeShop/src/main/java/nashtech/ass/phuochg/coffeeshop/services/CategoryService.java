package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.entities.Category;

@Service
public interface CategoryService {
	
	public Category addCategory(Category categories);

	public Category updateCategory(long id , Category categories);

	public boolean deleteCategory(long id);
	
	public List<Category> getAllCategory();
	
	public Category getOneCategory(long id);
	
	
}
