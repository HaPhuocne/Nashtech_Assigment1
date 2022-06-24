package nashtech.ass.phuochg.coffeeshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.entities.Categories;
import nashtech.ass.phuochg.coffeeshop.entities.ResponseObject;
import nashtech.ass.phuochg.coffeeshop.repositories.CategoriesRepository;
import nashtech.ass.phuochg.coffeeshop.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	@Autowired
	private CategoriesRepository categoriesRepository;

	@PostMapping("/")
	public ResponseEntity<ResponseObject> addCategory(@RequestBody Categories categories) {
		List<Categories> foundCategories = categoriesRepository.findByNameCategory(categories.getNameCategory().trim());
		if (foundCategories.size() > 0) {
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("failed", "Insert product fails", ""));
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Insert category successfully", categoryService.addPCategory(categories)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseObject> updateCategory(@PathVariable("id") long id, @RequestBody Categories categories) {
		boolean exsitsCategory = categoriesRepository.existsById(id);
		if (exsitsCategory) {
			List<Categories> foundCategories = categoriesRepository.findByNameCategory(categories.getNameCategory().trim());
			if (foundCategories.size() > 0 ) {
				return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
						.body(new ResponseObject("failed", "update category fails", ""));
			} else {
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update category successfully",
						categoryService.updateCategory(id, categories)));
			}
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Insert category successfully",
					categoryService.updateCategory(id, categories)));
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseObject> deleteCategory(@PathVariable("id") long id) {
		boolean exsitsCategory = categoriesRepository.existsById(id);
		if (exsitsCategory)
			return ResponseEntity.status(HttpStatus.OK)
					.body(new ResponseObject("ok", "Delete category successsful", categoryService.deleteCategory(id)));
		else
			return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
					.body(new ResponseObject("failed", "Delete category fails", ""));

	}

	@GetMapping("/")
	public ResponseEntity<ResponseObject> getAllCategories() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "List Category successfully", categoryService.getAllCategory()));
	}


}