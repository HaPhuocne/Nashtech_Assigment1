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
@Table(name = "orders")
@Builder
@Getter
@Setter
public class Orders {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idOrder;
	
	@Column
	private String orderDate;
	
	@Column
	private double total;

}
