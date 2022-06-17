package nashtech.ass.phuochg.coffeeshop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orderdetails")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderDetails {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idOrderDetail;
	
	
	@ManyToOne
	@JoinColumn(name = "idOrder")
	private Orders orders;

//	@Column
//	private Long idProduct;
	
	@Column
	private String orderdetailName;
	
	@Column
	private int quantity;
	
	@Column
	private double orderdetailPrice;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idProduct",referencedColumnName = "idProduct")
	private Products products;


}
