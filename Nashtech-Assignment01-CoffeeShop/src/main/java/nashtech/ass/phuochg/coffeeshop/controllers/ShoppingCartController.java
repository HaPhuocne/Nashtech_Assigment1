package nashtech.ass.phuochg.coffeeshop.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import nashtech.ass.phuochg.coffeeshop.entities.CartItem;
import nashtech.ass.phuochg.coffeeshop.entities.OrderDetails;
import nashtech.ass.phuochg.coffeeshop.entities.Orders;
import nashtech.ass.phuochg.coffeeshop.entities.Product;
import nashtech.ass.phuochg.coffeeshop.entities.ResponseObject;
import nashtech.ass.phuochg.coffeeshop.repositories.AccountRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.OrderDetailRepository;
import nashtech.ass.phuochg.coffeeshop.repositories.ProductRepository;
import nashtech.ass.phuochg.coffeeshop.services.AccountServices;
import nashtech.ass.phuochg.coffeeshop.services.CartItemService;
import nashtech.ass.phuochg.coffeeshop.services.OrderDetailService;
import nashtech.ass.phuochg.coffeeshop.services.OrderService;
import nashtech.ass.phuochg.coffeeshop.services.ProductServices;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {

	@Autowired
	ProductServices productServices;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	CartItemService cartItemService;

	@Autowired(required = false)
	OrderService orderService;

	@Autowired
	OrderDetailService orderDetailService;

	@Autowired
	AccountServices accountServices;

	@Autowired
	OrderDetailRepository orderDetailRepository;

	@Autowired
	AccountRepository accountRepository;

	@GetMapping("/")
	public ResponseEntity<ResponseObject> getAllProducts() {
		Collection<CartItem> cartItems = cartItemService.getCartItems();
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "List cart successfully", cartItems));
	}

	@PostMapping("/{id}")
	public ResponseEntity<ResponseObject> addProductToCart(@PathVariable("id") Long idProduct) {
		Product product = productServices.getOneProduct(idProduct);

		if (product != null) {
			CartItem item = new CartItem();
			item.setIdProduct(product.getIdProduct());
			item.setProductName(product.getProductName());
			item.setPrice(product.getPrice());
			item.setImage(product.getImage());
			item.setQuantity(1);
			cartItemService.add(item);
		}
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "add Product To Cart successfully", ""));
	}

	@GetMapping("/{id}")
	public String remove(@PathVariable(name = "id") Long productid) {
		cartItemService.remove(productid);
		return "redirect:/shoppingCart/cart";
	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseObject> UpdateProductToCart(@PathVariable("id") Long idProduct,
			@RequestParam("quantity") int quantity) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(new ResponseObject("ok", "Update Product To Cart successfully", ""));
	}

	@GetMapping("clear")
	public ResponseEntity<ResponseObject> clearCart() {
		cartItemService.clear();
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Clear Cart successfully", ""));

	}

	@GetMapping("/viewCart")
	public ResponseEntity<ResponseObject> viewShopping(@PathVariable("id") Long idAccount) {
		Collection<CartItem> cartItems = cartItemService.getCartItems();
		boolean accountexist = accountRepository.existsById(idAccount);
		if (accountexist) {		
			cartItemService.getAmount();
			cartItemService.getCount();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", "Clear Cart successfully", ""));
		} 
		return null;
	}

	@GetMapping("/checkOut")
	public ResponseEntity<ResponseObject> checkOut(@RequestBody Orders orders) {
		List<OrderDetails> listOrderDetails = new ArrayList<>();
		Collection<CartItem> cartItems = cartItemService.getCartItems();

		orders.setTotal(cartItemService.getAmount());
		orderService.addOrders(orders);

		for (CartItem cart : cartItems) {
			OrderDetails orderDetail = new OrderDetails();
			orderDetail.setQuantity(cart.getQuantity());
			orderDetail.setOrders(orders);
			orderDetail.setProduct(productServices.getOneProduct(cart.getIdProduct()));
			orderDetail.setPrice(cart.getPrice());
			listOrderDetails.add(orderDetail);
		}
		orderDetailRepository.saveAll(listOrderDetails);
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseObject("ok", " Order success", orders));
	}

}
