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
@Table(name = "accounts")
@Builder
@Getter
@Setter
public class Account {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idAcount;
	
	@Column(nullable = false, unique = true ,length = 256)
	private String email;
	
	@Column(nullable = false,length = 64 )
	private String password;
}
