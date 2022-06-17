package nashtech.ass.phuochg.coffeeshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import nashtech.ass.phuochg.coffeeshop.entities.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
