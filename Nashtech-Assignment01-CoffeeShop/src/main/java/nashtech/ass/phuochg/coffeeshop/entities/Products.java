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
@Table(name = "products")
@Getter
@Setter
public class Products {	

	public Products() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idProduct;
	
	@Column
	
	private Long idCategory;
	
	@Column(nullable = false,length = 256)
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
