package nashtech.ass.phuochg.coffeeshop.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "accounts")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account implements Serializable {

    public Account(String email2, String encode) {
		this.email = email2;
		this.password = encode;
	}
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id_account")
    private Long idAccount;
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "email")
    private String email;
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "account")
    private Collection<Information> informationCollection;
    @OneToMany(mappedBy = "account")
    private Collection<Orders> ordersCollection;
    @JoinColumn(name = "id_role", referencedColumnName = "id_role")
    @ManyToOne
    private Roles role;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<ProductRating> productRatingCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "account")
    private Collection<CartItem> cartItemCollection;

   
}
