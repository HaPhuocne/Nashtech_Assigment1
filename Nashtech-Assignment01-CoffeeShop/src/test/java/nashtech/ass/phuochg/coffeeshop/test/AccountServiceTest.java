package nashtech.ass.phuochg.coffeeshop.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import nashtech.ass.phuochg.coffeeshop.dto.PasswordDto;
import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.RolesRepository;
import nashtech.ass.phuochg.coffeeshop.servicesimpl.AccountServiceImpl;

public class AccountServiceTest {
	@Autowired
	AccountServiceImpl accountServiceImpl;
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ModelMapper modelMapper;
	@Autowired
	Account account;
	@Autowired
	PasswordDto passwordDto ;
	@Autowired
    PasswordEncoder encoder;
	@Autowired
    RolesRepository rolesRepository;
	
	private	Account initialAccount;
	private Account expectedAccount;

	
	@BeforeEach
	public void beforeEach() {
		
		accountRepository = mock(AccountRepository.class);
		modelMapper = mock(ModelMapper.class);
		passwordDto = mock(PasswordDto.class);
		account 	= mock(Account.class);
		encoder 	= mock(PasswordEncoder.class);
		accountServiceImpl = new AccountServiceImpl(accountRepository,modelMapper,encoder);
		initialAccount = mock(Account.class);
		
		when(accountRepository.save(initialAccount)).thenReturn(expectedAccount);
		when(modelMapper.map(passwordDto, Account.class)).thenReturn(initialAccount);
		
		}
	
	@Test
	public void updatePassword_ShouldReturnHttpOk_WhenDataValid() {
		when(accountRepository.findById(1L)).thenReturn(Optional.of(account));
		ResponseEntity<?> result = accountServiceImpl.updateAccount(1L,passwordDto);
		verify(account).setPassword(passwordDto.getPassword());
		assertThat(result.getStatusCode(), is(HttpStatus.OK));
	}

	
	@Test
	public void updatePassword_ShouldThrowResourceNotFoundException_WhenAccountIdNotFound() {
		when(accountRepository.findById(1L)).thenReturn(Optional.empty());
		ResourceFoundExceptions exception = Assertions.assertThrows(ResourceFoundExceptions.class,
				() -> accountServiceImpl.updateAccount(1L, passwordDto));
        assertThat(exception.getMessage(), is("Account is not found"));
	}
	
}
