package nashtech.ass.phuochg.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nashtech.ass.phuochg.coffeeshop.entities.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
