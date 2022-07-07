
package nashtech.ass.phuochg.coffeeshop.dto;


import javax.validation.constraints.NotEmpty;

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
public class CategoryDto {
	private Long idCategory;
	@NotEmpty(message = "Category name must not be empty")
	private String nameCategory;

}
