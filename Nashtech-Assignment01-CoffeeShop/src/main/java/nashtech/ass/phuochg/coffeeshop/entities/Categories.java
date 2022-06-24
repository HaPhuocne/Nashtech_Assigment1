package nashtech.ass.phuochg.coffeeshop.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="categories")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Categories {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategory;
	
	@Column(nullable = false,length = 256)
	private String nameCategory;
	
	
	@OneToMany(mappedBy = "categories", cascade = CascadeType.ALL)
	private Set<Products> products;
	
}
