package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.entities.Orders;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.OrdersRepository;
import nashtech.ass.phuochg.coffeeshop.services.OrderService;
@Component
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrdersRepository ordersRepository;
	@Autowired
	AccountRepository accountRepository; 

	@Override
	public Orders addOrders(Orders orders) {
		return ordersRepository.save(orders);
	}

}
