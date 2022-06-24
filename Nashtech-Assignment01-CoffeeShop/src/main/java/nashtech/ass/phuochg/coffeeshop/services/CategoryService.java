package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.entities.Categories;

@Service
public interface CategoryService {
	
	public Categories addPCategory(Categories categories);

	public Categories updateCategory(long id , Categories categories);

	public boolean deleteCategory(long id);
	
	public List<Categories> getAllCategory();
	
	public Categories getOneCategory(long id);
	
	
}
