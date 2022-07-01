package nashtech.ass.phuochg.coffeeshop.services;

import java.util.Collection;

import org.springframework.stereotype.Service;

import nashtech.ass.phuochg.coffeeshop.entities.CartItem;

@Service
public interface CartItemService {

	void add(CartItem item);

	void remove(Long ProductId);

	Collection<CartItem> getCartItems();

	void clear();

	void update(Long idProduct, int quantity);

	double getAmount();

	int getCount();
}
