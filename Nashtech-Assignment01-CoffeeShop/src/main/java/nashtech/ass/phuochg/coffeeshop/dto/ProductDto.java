/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nashtech.ass.phuochg.coffeeshop.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import nashtech.ass.phuochg.coffeeshop.entities.Category;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
	private Long idProduct;

	private String createDate;

	private String image;
	@NotNull(message = "Price must not be null")
	@Min(value = 0, message = "Price >= 0")
	private double price;
	
	@NotEmpty(message = "productName must not be empty")
	private String productName;
	@NotNull(message = "quantity must not be null")
	@Min(value = 0, message = "Quantity >= 1")
	private int quantity;

	private String updateDate;
    @NotNull(message = "Category must not be null")
	private Category category;


}
