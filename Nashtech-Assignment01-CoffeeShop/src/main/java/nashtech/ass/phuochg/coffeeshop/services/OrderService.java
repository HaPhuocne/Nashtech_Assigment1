package nashtech.ass.phuochg.coffeeshop.services;

import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.entities.Orders;

@Service
public interface OrderService {
	 Orders addOrders(Orders orders);
}
