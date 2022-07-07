package nashtech.ass.phuochg.coffeeshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import nashtech.ass.phuochg.coffeeshop.entities.Orderdetails;
import nashtech.ass.phuochg.coffeeshop.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{
	@Query("SELECT od.orderdetailsCollection FROM Orders od where od.idOrder= :idOrder")
	public List<Orderdetails> findAllyIdOrder(Long idOrder);
	public Orders findByIdOrder(Long id);
	public List<Orders> findAll();


	
}
