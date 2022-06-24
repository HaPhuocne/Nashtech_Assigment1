package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.entities.Categories;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoriesRepository;
import nashtech.ass.phuochg.coffeeshop.services.CategoryService;

@Component
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoriesRepository categoriesRepository;
	
	@Override
	public Categories updateCategory(long id, Categories categories) {
			if (categories != null) {
				Categories reCategories = categoriesRepository.getOne(id);
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
			Categories categories = categoriesRepository.getById(id);
			if (categories != null) {
				categoriesRepository.delete(categories);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Categories> getAllCategory() {
		// TODO Auto-generated method stub
		return categoriesRepository.findAll();
	}

	@Override
	public Categories getOneCategory(long id) {
		
		return categoriesRepository.getById(id);
	}

	@Override
	public Categories addPCategory(Categories categories) {
		
		return categoriesRepository.save(categories);
	}

	
}
