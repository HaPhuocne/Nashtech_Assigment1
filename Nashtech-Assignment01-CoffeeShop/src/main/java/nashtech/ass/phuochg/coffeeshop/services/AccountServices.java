package nashtech.ass.phuochg.coffeeshop.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.dto.PasswordDto;
import nashtech.ass.phuochg.coffeeshop.entities.Account;

@Service
public interface AccountServices {
//public Account addAccount(Account account ,Information information);
	
	public ResponseEntity<?> updateAccount(long id , PasswordDto accountDto);
	public ResponseEntity<?> deleteAccount(long id);
	public List<Account> getAllAccount();
	public ResponseEntity<?> getOrdersbyIdAccount(Long idAccount);
	}

