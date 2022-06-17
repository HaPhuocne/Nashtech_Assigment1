package nashtech.ass.phuochg.coffeeshop.entities;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "accounts")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAcount;

	@Column(nullable = false, unique = true, length = 256)
	private String email;

	@Column(nullable = false, length = 64)
	private String password;

	
	
	@ManyToOne
	@JoinColumn(name = "idRole")
	private Roles roles;
	
	@OneToMany(mappedBy = "account")
	private Set<Orders> orders;
	
	@OneToOne(mappedBy = "account")
	private Information information;

	@ManyToMany
	@JoinTable(name = "product_rating", joinColumns = @JoinColumn(name = "idAcount"), inverseJoinColumns = @JoinColumn(name = "idProduct"))

	private List<Products> listProducts;

}
