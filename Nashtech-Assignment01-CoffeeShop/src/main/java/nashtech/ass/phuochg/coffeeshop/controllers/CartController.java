package nashtech.ass.phuochg.coffeeshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.dto.CartItemDto;
import nashtech.ass.phuochg.coffeeshop.services.CarItemService;

@RestController
@RequestMapping("/shoppingcart")
public class CartController {
	@Autowired
	CarItemService carItemService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCartByIdAccount(@PathVariable("id") Long id){
		return carItemService.getCartByIdAccount(id);
	}
	@PostMapping("/")
	public ResponseEntity<?> addCart(@RequestBody CartItemDto cartItemDto){
		return carItemService.addCart(cartItemDto);
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCart(@PathVariable("id")Long id,@RequestBody CartItemDto cartItemDto){
		return carItemService.updateCart(id,cartItemDto);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCart(@PathVariable Long id){
		return carItemService.deleteCart(id);
	}

}
