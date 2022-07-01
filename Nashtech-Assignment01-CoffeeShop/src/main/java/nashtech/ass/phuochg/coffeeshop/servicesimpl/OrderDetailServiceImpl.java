package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.entities.OrderDetails;
import nashtech.ass.phuochg.coffeeshop.repositories.OrderDetailRepository;
import nashtech.ass.phuochg.coffeeshop.services.OrderDetailService;

@Component
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Override
	public List<OrderDetails> findByIdOrder(Long idOrder) {
		return orderDetailRepository.findAllyIdOrder(idOrder);
	}

}
