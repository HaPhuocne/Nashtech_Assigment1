package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.Information;

@Service
public interface AccountServices {
public Account addAccount(Account account ,Information information);
	
	public Account updateAccount(long id , Account products);

	public boolean deleteAccount(long id);
	
	public List<Account> getAllAccount();
	
	public Account getOneAccount(long id);
}
