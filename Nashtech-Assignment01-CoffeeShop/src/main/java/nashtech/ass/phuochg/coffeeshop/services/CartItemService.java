package nashtech.ass.phuochg.coffeeshop.services;

import java.util.Collection;

import nashtech.ass.phuochg.coffeeshop.entities.CartItem;

public interface CartItemService {
	double getAmount();
	int getCount();
	Collection<CartItem> getAlCartItems();
	void clearProduct();
	CartItem updateProduct(Long idProduct, int quantity);
	void removeProduct(Long idCartItem);
	void addProduct(CartItem item);

}
