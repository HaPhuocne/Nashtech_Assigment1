/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nashtech.ass.phuochg.coffeeshop.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

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
public class InformationDto  {

  
    private Long idInfo;
	@NotEmpty(message = "Address must not be empty")

    private String address;
	@NotEmpty(message = "Name must not be empty")

    private String name;
	@NotEmpty(message = "phoneNumber name must not be empty")
	@Pattern(regexp = "^0\\d{9}", message = "Phone Number must have 10 number and start with 0")
    private String phoneNumber; 
    private AccountDto account;

    
}
