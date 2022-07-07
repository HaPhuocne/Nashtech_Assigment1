/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nashtech.ass.phuochg.coffeeshop.entities;

import java.io.Serializable;
import java.util.Collection;

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
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Phước Hà
 */
@Entity
@Table(name = "orders")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order")
	private Long idOrder;
	@Size(max = 255)
	@Column(name = "order_date")
	private String orderDate;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "total")
	private Double total;
	@OneToMany(mappedBy = "order")
	private Collection<Orderdetails> orderdetailsCollection;
	@JoinColumn(name = "id_account", referencedColumnName = "id_account")
	@ManyToOne
	private Account account;

}
