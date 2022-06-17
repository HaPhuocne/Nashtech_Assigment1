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
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idAcount;

	@OneToOne(mappedBy = "accounts")
	private Information information;
	
	@Column(nullable = false, unique = true ,length = 256)
	private String email;
	
	@Column(nullable = false,length = 64 )
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "idRole")
	private Roles roles;
	
	

	
	

}
