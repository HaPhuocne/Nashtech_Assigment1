/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nashtech.ass.phuochg.coffeeshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderdetailsDto {

	private Long idOrderDetail;
	private Double price;
	private Integer quantity;

	private ProductDto product;
	private OrdersDto order;

}
