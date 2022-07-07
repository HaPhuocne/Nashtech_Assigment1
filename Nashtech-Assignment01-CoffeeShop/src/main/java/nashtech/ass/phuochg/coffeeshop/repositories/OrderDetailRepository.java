package nashtech.ass.phuochg.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nashtech.ass.phuochg.coffeeshop.entities.Orderdetails;



public interface OrderDetailRepository extends JpaRepository<Orderdetails, Long> {
//	@Query("SELECT od FROM OrderDetails od where od.order.idOrder= :idOrder")
//	 List<Orderdetails> findAllyIdOrder(Long idOrder);


	}
	
	
