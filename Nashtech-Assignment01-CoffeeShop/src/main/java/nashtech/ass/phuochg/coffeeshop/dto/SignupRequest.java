package nashtech.ass.phuochg.coffeeshop.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class SignupRequest {
	@NotEmpty(message = "Email must not be empty")
	@Size(min = 3, max = 64)
	@Email
	private String email;
	@NotEmpty(message = "Role must not be empty")
	private String role;
	@NotEmpty(message = "Address must not be empty")
	private String address;
	@NotEmpty(message = "Name must not be empty")
	private String name;
	@NotEmpty(message = "PhoneNumber must not be empty")
	private String phoneNumber;

	@NotBlank
	@Size(min = 6, max = 40)
	private String password;


}