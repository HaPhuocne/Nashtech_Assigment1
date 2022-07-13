package nashtech.ass.phuochg.coffeeshop.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.dto.PasswordDto;
import nashtech.ass.phuochg.coffeeshop.services.AccountServices;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/account")
public class AccountController {
	@Autowired
	AccountServices accountServices;

	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('customer') or hasAuthority('admin')")
	public ResponseEntity<?> updatePassword(@PathVariable("id") Long id,@Valid @RequestBody PasswordDto accountDto){
		return accountServices.updateAccount(id, accountDto);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('admin')")
	public ResponseEntity<?> deleteAccount(@PathVariable Long id){
		return accountServices.deleteAccount(id);
	}
}
