package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import nashtech.ass.phuochg.coffeeshop.entities.CartItem;
import nashtech.ass.phuochg.coffeeshop.services.CartItemService;

public class CartItemServiceImpl implements CartItemService {
	Map<Long, CartItem> maps=new HashMap<Long, CartItem>();

	@Override
	public double getAmount() {
		return maps.values().stream().mapToDouble(item->item.getQuantity()*item.getPrice()).sum();
	}

	@Override
	public int getCount() {
		return maps.values().size();
	}

	@Override
	public Collection<CartItem> getAlCartItems() {
		return maps.values();
	}

	@Override
	public void clearProduct() {
		maps.clear();

	}

	@Override
	public CartItem updateProduct(Long idProduct, int quantity) {
		CartItem cartItem=maps.get(idProduct);
		cartItem.setQuantity(quantity);
		return cartItem;
	}

	@Override
	public void removeProduct(Long idCartItem) {
		maps.remove(idCartItem);
	}

	@Override
	public void addProduct(CartItem item) {
		CartItem cartItem=maps.get(item.getIdProduct());
		if(cartItem==null) {
			maps.put(item.getIdProduct(), item);
		}else {
			cartItem.setQuantity(cartItem.getQuantity()+1);
		}

	}

}
