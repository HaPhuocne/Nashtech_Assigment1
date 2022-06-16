package nashtech.ass.phuochg.coffeeshop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "information")
@Builder
@Setter
@Getter
public class Information {
	@Id
	private Long idInfo;
	@Column(nullable = false,length = 256 )
	private String name;
	
	@Column(nullable = false,length = 10 )
	private String phoneNumber;
	
	@Column(nullable = false,length = 256 )
	private String address;

}
