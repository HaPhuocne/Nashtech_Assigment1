package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.entities.Category;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoryRepository;
import nashtech.ass.phuochg.coffeeshop.services.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository categoriesRepository;
	
	@Override
	public Category updateCategory(long id, Category categories) {
			if (categories != null) {
				Category reCategories = categoriesRepository.getOne(id);
				if (reCategories != null) {
					reCategories.setNameCategory(categories.getNameCategory());
				
					return categoriesRepository.save(reCategories);

				}
			}
			return null;
	}

	@Override
	public boolean deleteCategory(long id) {
		if (id >= 1) {
			Category categories = categoriesRepository.getById(id);
			if (categories != null) {
				categoriesRepository.delete(categories);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Category> getAllCategory() {
		// TODO Auto-generated method stub
		return categoriesRepository.findAll();
	}

	@Override
	public Category getOneCategory(long id) {
		
		return categoriesRepository.getById(id);
	}

	@Override
	public Category addCategory(Category categories) {
		
		return categoriesRepository.save(categories);
	}

	
}
