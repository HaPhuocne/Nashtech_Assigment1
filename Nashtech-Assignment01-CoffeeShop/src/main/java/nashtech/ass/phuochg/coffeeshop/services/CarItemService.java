package nashtech.ass.phuochg.coffeeshop.services;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.dto.CartItemDto;

@Service
public interface CarItemService {
	public Collection<CartItemDto> getCartByIdAccount(Long idAccount);

	public ResponseEntity<?> addCart(CartItemDto cartItemDto);

	public ResponseEntity<?> updateCart(Long id,CartItemDto cartItemDto);

	public ResponseEntity<?> deleteCart(Long idAccount);
}
