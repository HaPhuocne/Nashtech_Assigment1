/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nashtech.ass.phuochg.coffeeshop.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
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

/**
 *
 * @author Phước Hà
 */
@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_product")
	private Long idProduct;
	@Size(max = 256)
	@Column(name = "create_date")
	private String createDate;
	@Size(max = 1000)
	@Column(name = "image")
	private String image;
	@Column(name = "price")
	private double price;
	@Size(min = 1, max = 256)
	@Column(name = "product_name")
	private String productName;
	@Column(name = "quantity")
	private int quantity;
	@Size(max = 256)
	@Column(name = "update_date")
	private String updateDate;
	@JoinColumn(name = "id_category", referencedColumnName = "id_category")
	@ManyToOne
	private Category category;
	@OneToMany(mappedBy = "product")
	private Collection<Orderdetails> orderdetailsCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Collection<ProductRating> productRatingCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Collection<CartItem> cartItemCollection;

	

}
