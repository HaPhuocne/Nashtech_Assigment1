package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.List;
import java.util.Optional;

import javax.management.relation.Role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.Information;
import nashtech.ass.phuochg.coffeeshop.entities.Products;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.InfomationRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.RolesRepository;
import nashtech.ass.phuochg.coffeeshop.security.services.UserDetailsImpl;
import nashtech.ass.phuochg.coffeeshop.services.AccountServices;

public class AccountServiceImpl implements AccountServices {
	Account account;
	AccountRepository accountR;
//	
//	@Autowired
//	Information infor;
//	@Autowired
//	InfomationRepository inforR;
//	
//	@Autowired
//	Role role;
//	@Autowired
//	RolesRepository roleR;

	
	
	@Override
	public Account addAccount(Account account ,Information information) {					
		return accountR.save(account);
	}

	@Override
	public Account updateAccount(long id, Account account) {
		if(account !=null) {
			Account reAccount = accountR.getById(id);
			if(reAccount != null) {
				reAccount.setPassword(account.getPassword());
				reAccount.setRoles(account.getRoles());
				return accountR.save(reAccount);
			}
		}				
		return null;
	}

	@Override
	public boolean deleteAccount(long id) {
		if(id >1) {
			Account account = accountR.getById(id);
			if(account != null) {
				accountR.delete(account);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Account> getAllAccount() {
	
		return accountR.findAll();
	}

	@Override
	public Account getOneAccount(long id) {
		
		return accountR.getById(id);
	}

	
}
