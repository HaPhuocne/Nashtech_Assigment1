package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.dto.AccountDto;
import nashtech.ass.phuochg.coffeeshop.dto.CartItemDto;
import nashtech.ass.phuochg.coffeeshop.dto.OrderdetailsDto;
import nashtech.ass.phuochg.coffeeshop.dto.OrdersDto;
import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.Orderdetails;
import nashtech.ass.phuochg.coffeeshop.entities.Orders;
import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.OrderDetailRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.OrdersRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.services.CarItemService;
import nashtech.ass.phuochg.coffeeshop.services.OrderService;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@Component
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrdersRepository orderRepository;
	@Autowired
	OrderDetailRepository orderDetailRepository;
	@Autowired
	ProductServices productServices;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	CarItemService carItemService;

	@Override
	public OrdersDto findByIdOrder(long id) {
		Optional<Orders> optional = orderRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ResourceFoundExceptions("Order not found");
		}
		Orders order = optional.get();
		return modelMapper.map(order, OrdersDto.class);
	}

	@Override
	public ResponseEntity<?> getAllOrder() {
		List<Orders> list = orderRepository.findAll();
		List<OrdersDto> listDto = new ArrayList<OrdersDto>();
		list.forEach(s -> listDto.add(modelMapper.map(s, OrdersDto.class)));

		return ResponseEntity.ok(listDto);
	}

	@Override
	public ResponseEntity<?> addOrder(OrdersDto ordersDto) {
		Collection<CartItemDto> cartItems = carItemService.getCartByIdAccount(ordersDto.getAccount().getIdAccount());		
		if (cartItems.isEmpty()) {
			throw new ResourceFoundExceptions("The order was not added successfully");
		}
		Orders orders = orderRepository.save(modelMapper.map(ordersDto, Orders.class));
		List<Orderdetails> listOrderDetails = new ArrayList<>();
		for (CartItemDto cart : cartItems) {
			Orderdetails orderdetails = new Orderdetails();
			orderdetails.setQuantity(cart.getQuantity());
			orderdetails.setProduct(modelMapper.map(cart.getProduct(), Product.class));
			orderdetails.setOrder(orders);
			listOrderDetails.add(orderdetails);
//		OrderdetailsDto orderDetail = new OrderdetailsDto();
//		orderDetail.setQuantity(cart.getQuantity());
//		orderDetail.setOrder(ordersDto);
//		orderDetail.setProduct(productServices.findByIdProduct(cart.getProduct().getIdProduct()));			
//		listOrderDetails.add(modelMapper.map(orderDetail, Orderdetails.class));			
		}
		orderDetailRepository.saveAll(listOrderDetails);
		carItemService.deleteCart(ordersDto.getAccount().getIdAccount());
		return ResponseEntity.ok(new MessageResponse("The order was added successfully"));
	}
	
}
