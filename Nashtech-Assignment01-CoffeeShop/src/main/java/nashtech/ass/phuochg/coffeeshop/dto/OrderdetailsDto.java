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
import nashtech.ass.phuochg.coffeeshop.entities.Orders;
import nashtech.ass.phuochg.coffeeshop.entities.Product;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderdetailsDto  {

      
    private Double orderdetailPrice;
    private Double price;
    private Integer quantity;

    private Product product;

    
    
}
