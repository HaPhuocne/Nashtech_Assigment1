package nashtech.ass.phuochg.coffeeshop.controllers;


import javax.validation.Valid;

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

import nashtech.ass.phuochg.coffeeshop.dto.CategoryDto;
import nashtech.ass.phuochg.coffeeshop.entities.ResponseObject;
import nashtech.ass.phuochg.coffeeshop.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/")
	public CategoryDto addCategory(@Valid @RequestBody CategoryDto categoryDto) {
		return categoryService.addCategory(categoryDto);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseObject> updateCategory(@PathVariable long id,@Valid @RequestBody CategoryDto categoryDto) {
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "update category successfully",
				categoryService.updateCategory(id, categoryDto)));
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