package nashtech.ass.phuochg.coffeeshop.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.dto.CartItemDto;
import nashtech.ass.phuochg.coffeeshop.dto.CategoryDto;
import nashtech.ass.phuochg.coffeeshop.dto.OrderdetailsDto;
import nashtech.ass.phuochg.coffeeshop.dto.OrdersDto;
import nashtech.ass.phuochg.coffeeshop.entities.Orderdetails;
import nashtech.ass.phuochg.coffeeshop.repositories.OrderDetailRepository;
import nashtech.ass.phuochg.coffeeshop.services.CarItemService;
import nashtech.ass.phuochg.coffeeshop.services.OrderService;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {
//	@Autowired
//	CarItemService carItemService;
//	@Autowired
//	OrderService orderService;
//	@Autowired
//	ProductServices productServices;
//	@Autowired
//	OrderDetailRepository orderDetailRepository;
//	@Autowired
//	ModelMapper modelMapper;
//	@GetMapping("/")
//	public ResponseEntity<?> checkOut(@PathVariable("id")Long id, @RequestBody OrdersDto ordersDto) {
//		List<OrderdetailsDto> listOrderDetails = new ArrayList<>();
//		Collection<CartItemDto> cartItems = carItemService.getCartByIdAccount(id);
//		orderService.addOrder(ordersDto);
//
//		for (CartItemDto cart : cartItems) {
//			OrderdetailsDto orderDetail = new OrderdetailsDto();
//			orderDetail.setQuantity(cart.getQuantity());
//			orderDetail.setOrder(ordersDto);
//			orderDetail.setProduct(productServices.findByIdProduct(cart.getProduct().getIdProduct()));
//			listOrderDetails.add(orderDetail);
//			modelMapper.map(orderDetail, Orderdetails.class);
//		}
//		return orderDetailRepository.saveAll(listOrderDetails);
//	}
}
