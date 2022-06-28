package nashtech.ass.phuochg.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nashtech.ass.phuochg.coffeeshop.entities.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

}
