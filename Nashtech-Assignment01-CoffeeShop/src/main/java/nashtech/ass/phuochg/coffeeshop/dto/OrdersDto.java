/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nashtech.ass.phuochg.coffeeshop.dto;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nashtech.ass.phuochg.coffeeshop.entities.Account;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersDto {

	private Long idOrder;

	private String orderDate;

	private Double total;

	private Collection<OrderdetailsDto> orderdetailsCollection;

	private Account account;

}
