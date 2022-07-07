package nashtech.ass.phuochg.coffeeshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.dto.PasswordDto;
import nashtech.ass.phuochg.coffeeshop.services.AccountServices;

@RestController
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountServices accountServices;

	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePassword(@PathVariable("id") Long id,@Valid @RequestBody PasswordDto accountDto){
		return accountServices.updateAccount(id, accountDto);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAccount(@PathVariable Long id){
		return accountServices.deleteAccount(id);
	}
}
