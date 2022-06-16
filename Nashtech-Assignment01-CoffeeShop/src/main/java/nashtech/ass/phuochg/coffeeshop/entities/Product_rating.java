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
@Table (name = "product_rating" )
@Builder
@Getter
@Setter
public class Product_rating {
	@Id
	private long id;
	@Column(nullable = false)
	private long idAcount;
	
	@Column(length = 256)
	private String comment;
	
	private int rating;


}
