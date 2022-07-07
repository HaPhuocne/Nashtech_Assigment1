package nashtech.ass.phuochg.coffeeshop.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.CartItem;

@Repository

public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional <Account> findByEmail(String email);
    @Query("Select a.cartItemCollection from Account a where a.idAccount = :idAccount ")
    public List<CartItem> findCartByIdAccount(Long idAccount);




}
