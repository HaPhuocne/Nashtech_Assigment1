package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.dto.CartItemDto;
import nashtech.ass.phuochg.coffeeshop.entities.Account;
import nashtech.ass.phuochg.coffeeshop.entities.CartItem;
import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.exceptions.handlers.ResourceFoundExceptions;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.CartItemRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.response.MessageResponse;
import nashtech.ass.phuochg.coffeeshop.services.CarItemService;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@Component
public class CartItemServiceImpl implements CarItemService {
	@Autowired
	AccountRepository accountRepository;
	@Autowired
	ProductServices productServices;
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public ResponseEntity<?> getCartByIdAccount(Long idAccount) {
		Optional<Account> optionalAccount = accountRepository.findById(idAccount);
		if (!optionalAccount.isPresent()) {
			throw new ResourceFoundExceptions("Account not found");
		}
		List<CartItem> list = accountRepository.findCartByIdAccount(idAccount);
		List<CartItemDto> dto = new ArrayList<CartItemDto>();
		list.forEach(c -> dto.add(modelMapper.map(c, CartItemDto.class)));
		return ResponseEntity.ok(dto);
	}

	@Override
	public ResponseEntity<?> addCart(CartItemDto cartItemDto) {
		// TODO Auto-generated method stub
		Optional<Product> optionalProduct = productRepository.findById(cartItemDto.getProduct().getIdProduct());
		if (!optionalProduct.isPresent()) {
			throw new ResourceFoundExceptions("Product not found");
		}
		Optional<Account> optionalAccount = accountRepository.findById(cartItemDto.getAccount().getIdAccount());
		if (!optionalAccount.isPresent()) {
			throw new ResourceFoundExceptions("Account not found");
		}		
			cartItemRepository.save(modelMapper.map(cartItemDto, CartItem.class));

		return ResponseEntity.ok(new MessageResponse("Cart is added successfully"));

	}

	@Override
	public ResponseEntity<?> updateCart(Long id,CartItemDto cartItemDto) {
		Optional<Product> optionalProduct = productRepository.findById(cartItemDto.getProduct().getIdProduct());
		if (!optionalProduct.isPresent()) {
			throw new ResourceFoundExceptions("Product not found");
		}
		Optional<Account> optionalAccount = accountRepository.findById(cartItemDto.getAccount().getIdAccount());
		if (!optionalAccount.isPresent()) {
			throw new ResourceFoundExceptions("Account not found");
		}
		Optional<CartItem> optionalCart = cartItemRepository.findById(id);
		if (optionalCart.isPresent()) {
			CartItem cart = optionalCart.get();
			if (cart.getQuantity() == 0) {
				cartItemRepository.delete(cart);
			}
			cart.setQuantity(cartItemDto.getQuantity());
			cartItemRepository.save(cart);
			return ResponseEntity.ok(new MessageResponse("Cart is updated successfully"));
		}
		throw new ResourceFoundExceptions("Cart not found");
	}

	@Override
	public ResponseEntity<?> deleteCart(Long idAccount) {
		Optional<Account> optionalAccount = accountRepository.findById(idAccount);
		if(!optionalAccount.isPresent()) {
			throw new ResourceFoundExceptions("Account not found");
		}
		List<CartItem> list = cartItemRepository.findByIdAccount(idAccount);
		cartItemRepository.deleteAll(list);
		return ResponseEntity.ok(new MessageResponse("Deleted successfully"));
	}

}
