package nashtech.ass.phuochg.coffeeshop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.services.AccountServices;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	AccountServices accountServices;
	@GetMapping("/{id}")
	public ResponseEntity<?> getOrders(@PathVariable("id") Long id){
		return accountServices.getOrdersbyIdAccount(id);
	}
}
