package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;



import nashtech.ass.phuochg.coffeeshop.dto.OrderdetailsDto;
import nashtech.ass.phuochg.coffeeshop.dto.OrdersDto;
import nashtech.ass.phuochg.coffeeshop.entities.Orderdetails;
import nashtech.ass.phuochg.coffeeshop.entities.Orders;
import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.OrderDetailRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.OrdersRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.services.OrderService;
@Component
public class OrderServiceImpl implements OrderService {
	
	private OrdersRepository orderRepository;
	private OrderDetailRepository orderDetailRepository;
	private ProductRepository productRepository;
	private ModelMapper modelMapper;
	@Override
	public OrdersDto findByIdOrder(long id) {
		Optional<Orders> optional = orderRepository.findById(id);
		if(!optional.isPresent()) {
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
		Orders order = modelMapper.map(ordersDto, Orders.class);
		Optional<Orders> optionalOrder = orderRepository.findById(ordersDto.getIdOrder());
		if(optionalOrder.isPresent()) {
			throw new ResourceFoundExceptions("Don't add Order");
		}
		orderRepository.save(order);
		List<Orderdetails> listOrderdetails = new ArrayList<>();
		Orderdetails orderdetails;
		
		for(OrderdetailsDto s : ordersDto.getOrderdetailsCollection()) {
			Long idProduct =s.getProduct().getIdProduct();
			Optional<Product> optionalProduct = productRepository.findById(idProduct);
			if(!optionalProduct.isPresent()) {
				throw new ResourceFoundExceptions("Product not found");
			}
			orderdetails = modelMapper.map(s, Orderdetails.class);
			orderdetails.setProduct(productRepository.findByIdProduct(idProduct));
			orderdetails.setOrder(order);
			listOrderdetails.add(orderdetails);
		}
		orderDetailRepository.saveAll(listOrderdetails);
		return ResponseEntity.ok(new MessageResponse("The order was added successfully"));
	}
	
}
