package nashtech.ass.phuochg.coffeeshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "orderdetails")
@Builder
@Getter
@Setter
public class OrderDetails {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idOrderDetail;
	
	@Column(nullable = false)
	private long idProduct;
	
	@Column(nullable = false)
	private long idOrder;
	
	@Column
	private String orderdetailName;
	
	@Column
	private int quantity;
	
	@Column
	private double orderdetailPrice;

}
