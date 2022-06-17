package nashtech.ass.phuochg.coffeeshop.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;

	@ManyToOne
	@JoinColumn(name = "idCategory")
	private Categories categories;
	
	@OneToOne(mappedBy = "products")
	private OrderDetails orderDetails;
	
	@Column(nullable = false, length = 256)
	private String productName;

	@Column(nullable = false)
	private double price;

	@Column(length = 1000)
	private String image;

	@Column(nullable = false)
	private int quantity;

	@Column(length = 256)
	private String createDate;

	@Column(length = 256)
	private String updateDate;
	
	
	
	

}
