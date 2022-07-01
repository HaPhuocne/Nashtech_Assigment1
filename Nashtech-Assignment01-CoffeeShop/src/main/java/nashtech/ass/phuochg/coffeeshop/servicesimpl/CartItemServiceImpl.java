package nashtech.ass.phuochg.coffeeshop.servicesimpl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import nashtech.ass.phuochg.coffeeshop.entities.CartItem;
import nashtech.ass.phuochg.coffeeshop.services.CartItemService;


@Component
public class CartItemServiceImpl implements CartItemService {

	private Map<Long, CartItem> map = new HashMap<>();

	@Override
	public void add(CartItem item) {

		CartItem existItem = map.get(item.getIdProduct());
		if (existItem != null) {
			existItem.setQuantity(item.getQuantity() + existItem.getQuantity());
		} else {
			map.put(item.getIdProduct(), item);
		}
	}

	@Override
	public void remove(Long ProductId) {
		map.remove(ProductId);
	}

	@Override
	public Collection<CartItem> getCartItems() {
		return map.values();
	}

	@Override
	public void clear() {
		map.clear();
	}

	@Override
	public void update(Long idProduct, int quantity) {
		CartItem item = map.get(idProduct);
		item.setQuantity(quantity);
		if (item.getQuantity() <= 0) {
			map.remove(idProduct);
		}
	}

	@Override
	public double getAmount() {
		return map.values().stream().mapToDouble(item -> item.getQuantity() * item.getPrice()).sum();
	}

	@Override
	public int getCount() {
		if (map.isEmpty()) {
			return 0;
		}
		return map.values().size();
	}

}
