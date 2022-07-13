package nashtech.ass.phuochg.coffeeshop.controllers;

import nashtech.ass.phuochg.coffeeshop.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import nashtech.ass.phuochg.coffeeshop.services.AccountServices;
import nashtech.ass.phuochg.coffeeshop.services.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	@Autowired
	AccountServices accountServices;
	@Autowired
	OrderService orderServices;
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('customer') or hasAuthority('admin')")
	public ResponseEntity<?> getOrders(@PathVariable("id") Long id){
		return accountServices.getOrdersbyIdAccount(id);
	}
	@GetMapping("/")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<?> getAllOrder(){
		return getAllOrder();
	}
	@PostMapping("/")
	public ResponseEntity<?> addOrder(@RequestBody OrdersDto ordersDto){
		return orderServices.addOrder(ordersDto);
	}
	
}
