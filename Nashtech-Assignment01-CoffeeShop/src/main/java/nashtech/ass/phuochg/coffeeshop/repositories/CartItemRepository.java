package nashtech.ass.phuochg.coffeeshop.repositories;

import nashtech.ass.phuochg.coffeeshop.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem,Long> {
   @Query("SELECT c FROM CartItem c WHERE c.account.idAccount = :idAccount")
	public List<CartItem> findByIdAccount(Long idAccount);
}
