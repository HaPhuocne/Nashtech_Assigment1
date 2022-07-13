/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nashtech.ass.phuochg.coffeeshop.entities;

import java.io.Serializable;
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
@Table(name = "orderdetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Orderdetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_detail")
    private Long idOrderDetail;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Integer quantity;
    @JoinColumn(name = "id_order", referencedColumnName = "id_order")
    @ManyToOne
    private Orders order;
    @JoinColumn(name = "id_product", referencedColumnName = "id_product")
    @ManyToOne
    private Product product;

    
    
}
