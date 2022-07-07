package nashtech.ass.phuochg.coffeeshop.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.dto.CartItemDto;

@Service
public interface CarItemService {
	public ResponseEntity<?> getCartByIdAccount(Long idAccount);

	public ResponseEntity<?> addCart(CartItemDto cartItemDto);

	public ResponseEntity<?> updateCart(Long id,CartItemDto cartItemDto);

	public ResponseEntity<?> deleteCart(Long idAccount);
}
