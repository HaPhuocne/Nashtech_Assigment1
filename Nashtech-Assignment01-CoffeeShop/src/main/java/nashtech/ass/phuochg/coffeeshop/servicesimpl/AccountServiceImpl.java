package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.dto.PasswordDto;
import nashtech.ass.phuochg.coffeeshop.dto.OrdersDto;
import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.services.AccountServices;
@Component
public class AccountServiceImpl implements AccountServices {
	@Autowired
	 AccountRepository accountRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> updateAccount(long id, PasswordDto accountDto) {
		// TODO Auto-generated method stub
		Optional<Account> optional = accountRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ResourceFoundExceptions("Account is not found");
		}
		Account account = optional.get();
		account.setPassword(accountDto.getPassword());
		accountRepository.save(account);
		
		return ResponseEntity.ok(new MessageResponse("Update password successfully"));
	}
	@Override
	public ResponseEntity<?> deleteAccount(long id) {
		Optional<Account> optional = accountRepository.findById(id);
		if(!optional.isPresent()) {
			throw new ResourceFoundExceptions("Account is not found");
		}
		Account account = optional.get();
		accountRepository.delete(account);
		return ResponseEntity.ok(new MessageResponse("The account delete successfully"));
	}
	@Override
	public List<Account> getAllAccount() {
		return accountRepository.findAll();
	}
	@Override
	public ResponseEntity<?> getOrdersbyIdAccount(Long idAccount) {
		// TODO Auto-generated method stub
				Optional<Account> optional = accountRepository.findById(idAccount);
				if(!optional.isPresent()) {
					throw new ResourceFoundExceptions("Account not found");
				}
				Account account = optional.get();
				if(account.getOrdersCollection().size() == 0) {
					return ResponseEntity.ok("Account don't have orders");
				}
				List<OrdersDto> list = new ArrayList<OrdersDto>();
				account.getOrdersCollection().forEach(order -> list.add(modelMapper.map(order, OrdersDto.class)));
				return ResponseEntity.ok(list);
	}


	
}
