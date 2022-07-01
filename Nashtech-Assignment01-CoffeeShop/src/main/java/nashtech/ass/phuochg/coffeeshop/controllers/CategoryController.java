package nashtech.ass.phuochg.coffeeshop.controllers;


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

import nashtech.ass.phuochg.coffeeshop.entities.Category;
import nashtech.ass.phuochg.coffeeshop.entities.ResponseObject;
import nashtech.ass.phuochg.coffeeshop.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public ResponseEntity<ResponseObject> addCategory(@RequestBody Category categories) {
		return ResponseEntity.status(HttpStatus.OK).body(
				new ResponseObject("ok", "Insert category successfully", categoryService.addCategory(categories)));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseObject> updateCategory(@PathVariable("id") long id,
			@RequestBody Category categories) {
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update category successfully",
				categoryService.updateCategory(id, categories)));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseObject> deleteCategory(@PathVariable("id") long id) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Delete category successsful", categoryService.deleteCategory(id)));
	}
	@GetMapping("/")
	public ResponseEntity<ResponseObject> getAllCategories() {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "List Category successfully", categoryService.getAllCategory()));
	}

}