/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nashtech.ass.phuochg.coffeeshop.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

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
@Table(name = "product_rating")
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRating implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_productRate")
	private Long idproductRate;
	@Size(max = 256)
	@Column(name = "comment")
	private String comment;
	@NotNull
	@Column(name = "rating")
	private int rating;
	@JoinColumn(name = "id_acount", referencedColumnName = "id_account")
	@ManyToOne(optional = false)
	private Account account;
	@JoinColumn(name = "id_product", referencedColumnName = "id_product")
	@ManyToOne(optional = false)
	private Product product;

}
