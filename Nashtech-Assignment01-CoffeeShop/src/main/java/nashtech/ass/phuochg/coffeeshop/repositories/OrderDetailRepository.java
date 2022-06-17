package nashtech.ass.phuochg.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nashtech.ass.phuochg.coffeeshop.entities.OrderDetails;

public interface OrderDetailRepository extends JpaRepository<OrderDetails, Long> {

}
