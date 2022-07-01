package nashtech.ass.phuochg.coffeeshop.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Check;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Check(constraints = "quantity >= 0")
@Table(name = "product")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduct;
	
	@Column(nullable = false, length = 256, unique = true)
	private String productName;

	@Column(nullable = false )
	private double price;

	@Column(length = 1000)
	private String image;
	
	@Column(nullable = false  )
	private int quantity;

	@Column(length = 256)
	private String createDate;

	@Column(length = 256)
	
	private String updateDate;
	
	
	
	@ManyToMany(mappedBy = "listProducts")
    private Set<Account> accounts;

	@ManyToOne
	@JoinColumn(name = "idCategory",referencedColumnName = "idCategory")
	private Category category;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<OrderDetails> orderDetails;
	
	

}
