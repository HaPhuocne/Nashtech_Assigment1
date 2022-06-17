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
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInfo;
	
	@Column
	private Long idAcount;
//	
	@Column(nullable = false,length = 256 )
	private String name;
	
	@Column(nullable = false,length = 10 )
	private String phoneNumber;
	
	@Column(nullable = false,length = 256 )
	private String address;
	
	@OneToOne(cascade =CascadeType.ALL )
	@JoinColumn(name ="idAcount",referencedColumnName = "idAcount")
	private Account account;
	

}
