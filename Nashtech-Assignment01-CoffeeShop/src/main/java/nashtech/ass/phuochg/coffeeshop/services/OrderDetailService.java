package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.entities.OrderDetails;


@Service
public interface OrderDetailService {
	 List<OrderDetails> findByIdOrder(Long idOrder);
}
