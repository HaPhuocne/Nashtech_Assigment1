package nashtech.ass.phuochg.coffeeshop.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private final AccountRepository accountR;

	public UserDetailsServiceImpl(AccountRepository accountR) {
		this.accountR = accountR;
	}

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Account acc = accountR.findByEmail(email).orElseThrow(
				() -> new UsernameNotFoundException("User Not Found with -> username or email : " + email));

		return UserDetailsImpl.build(acc);
	}

}
