package nashtech.ass.phuochg.coffeeshop.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
	
	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
	private Set<OrderDetails> orderDetails;

}
