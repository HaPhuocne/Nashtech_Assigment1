package nashtech.ass.phuochg.coffeeshop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "information")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Information {

	public Information(String name2, String address2, String phone_Number, Account account2) {
		this.name = name2;
		this.address = name2;
		this.phoneNumber = phone_Number;
		this.account = account2;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInfo;
	@NotEmpty(message = "name not Found")
	@Column(nullable = false, length = 256)
	private String name;
	@NotEmpty(message = "phoneNumber not Found")
	@Column(nullable = false, length = 10,unique = true)
	private String phoneNumber;
	@NotEmpty(message = "address not Found")
	@Column(nullable = false, length = 256)
	private String address;

	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idAcount")
	private Account account;
}
