package nashtech.ass.phuochg.coffeeshop.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nashtech.ass.phuochg.coffeeshop.entities.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional <Account> findByEmail(String email);
    

    
   
}
