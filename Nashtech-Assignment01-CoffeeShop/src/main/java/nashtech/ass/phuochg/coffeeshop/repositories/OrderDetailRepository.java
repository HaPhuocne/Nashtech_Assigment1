package nashtech.ass.phuochg.coffeeshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import nashtech.ass.phuochg.coffeeshop.entities.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, Long> {
	@Query("SELECT od FROM OrderDetails od where id_order= :idOrder")
	 List<OrderDetails> findAllyIdOrder(@Param("idOrder")Long idOrder);


	}
	
	
