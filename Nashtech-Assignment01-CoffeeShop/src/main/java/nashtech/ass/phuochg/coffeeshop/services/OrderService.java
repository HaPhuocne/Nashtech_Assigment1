package nashtech.ass.phuochg.coffeeshop.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.dto.OrdersDto;

@Service
public interface OrderService {

	
	public OrdersDto findByIdOrder(long id);
	public ResponseEntity<?> getAllOrder();
	public ResponseEntity<?> addOrder(OrdersDto dto);



}
